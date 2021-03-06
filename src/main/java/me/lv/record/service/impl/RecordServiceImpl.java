package me.lv.record.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.lv.record.dao.AreaDao;
import me.lv.record.dao.RecordDao;
import me.lv.record.entity.RecordDO;
import me.lv.record.entity.dto.InsertRecodeDTO;
import me.lv.record.entity.dto.RecordDTO;
import me.lv.record.entity.dto.SearchDTO;
import me.lv.record.entity.dto.UpdateRecordDTO;
import me.lv.record.exception.ServiceException;
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
    public PageInfo<RecordDTO> listRecords(SearchDTO searchDTO) {
        PageHelper.startPage(searchDTO.getPage(), searchDTO.getPageSize());
        List<RecordDTO> recordDTOS = recordDao.listRecords(searchDTO);
        PageInfo<RecordDTO> pageInfo = new PageInfo<>(recordDTOS);
        return pageInfo;
    }

    @Override
    public void insertRecord(InsertRecodeDTO recordDTO) throws ServiceException{
        RecordDO record = recordDao.getRecordByTitle(recordDTO.getTitle());
        if (record != null) {
            throw new ServiceException("抬头已存在");
        }
        recordDao.insertRecord(recordDTO);
    }

    @Override
    public void deleteRecord(Integer id) {
        recordDao.deleteRecord(id);
    }

    @Override
    public void updateRecord(UpdateRecordDTO updateRecordDTO) {
        recordDao.updateRecord(updateRecordDTO);
    }
}
