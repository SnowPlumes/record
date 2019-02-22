package me.lv.record.service.impl;

import me.lv.record.dao.AreaDao;
import me.lv.record.entity.AreaDO;
import me.lv.record.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lv
 */
@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<AreaDO> listAreas() {
        return areaDao.listAreas();
    }
}
