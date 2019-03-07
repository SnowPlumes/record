package me.lv.record.service.impl;

import me.lv.record.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.Part;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lzw
 * @date 2018/6/13
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public String uploadPictureWithPart(Part part) throws Exception {
        String dataStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String fileName = getFileName(part);

        // 获取图片的扩展名
        String extensionName = StringUtils.substringAfter(fileName, ".");
        // 新的图片文件名 = 获取时间戳+"."图片扩展名
        String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;

        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) {
            path = new File("");
        }

        //如果上传目录为/static/images/upload/，则可以如下获取：
        File upload = new File(path.getAbsolutePath(),"static/images/upload/");

        // 文件路径
        String filePath = "/" + dataStr + "/";
        File file = new File(upload + filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        part.write(upload + filePath + File.separator + newFileName);
        return filePath + newFileName;
    }

    private String getFileName(Part part) {
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        return fileName;
    }

}
