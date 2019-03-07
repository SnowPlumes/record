package me.lv.record.service;

import me.lv.record.entity.AreaDO;

import java.util.List;

/**
 * @author lv
 */
public interface AreaService {
    /**
     * 获取地区
     *
     * @return
     */
    List<AreaDO> listAreas();
}
