package me.lv.record.service.impl;

import me.lv.record.dao.AreaDao;
import me.lv.record.dao.RecordDao;
import me.lv.record.entity.dto.InsertRecodeDTO;
import me.lv.record.entity.dto.RecordDTO;
import me.lv.record.entity.dto.SearchDTO;
import me.lv.record.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lv
 */
@Service
public class RecordServiceImpl implements RecordService{

    private Logger logger = LoggerFactory.getLogger(RecordServiceImpl.class);

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private RecordDao recordDao;

    @Override
    public List<RecordDTO> listRecords(SearchDTO searchDTO) {
        return recordDao.listRecords(searchDTO);
    }

    @Override
    public void insertRecord(InsertRecodeDTO recordDTO) {
        recordDao.insertRecord(recordDTO);
    }
}
