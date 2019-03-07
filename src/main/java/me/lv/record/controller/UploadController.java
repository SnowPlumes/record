package me.lv.record.controller;

import me.lv.record.constant.ResponseStatus;
import me.lv.record.entity.dto.JsonResponse;
import me.lv.record.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 * @author lzw
 * @date 2018/6/13
 */
@CrossOrigin
@RestController
@RequestMapping("upload")
public class UploadController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "uploadPicture")
    public JsonResponse uploadPicture(HttpServletRequest request) {
        JsonResponse json = new JsonResponse();
        try {
            Part part = request.getPart("file");
            json.setCode(ResponseStatus.SUCCESS);
            json.setMsg("上传成功");
            json.setResults(uploadService.uploadPictureWithPart(part));
        } catch (Exception e) {
            json.setCode(ResponseStatus.FAIL);
            json.setMsg("上传失败");
            logger.error(">>>>>>>> upload error:", e);
        }
        return json;
    }
}
