package me.lv.record.dao;

import me.lv.record.entity.AreaDO;
import me.lv.record.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * @author lv
 */
@Component
public class AreaDao {

    @Value("${data.area.local}")
    private String areaFile;

    public List<AreaDO> listAreas() {
        return ExcelUtil.importExcel(new File(areaFile));
    }
}
