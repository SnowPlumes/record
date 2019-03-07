package me.lv.record.dao;

import me.lv.record.entity.AreaDO;
import java.util.List;

/**
 * @author lv
 */
public interface AreaDao {
    /**
     * 获取地区
     *
     * @return
     */
    List<AreaDO> listAreas();
}
