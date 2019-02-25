package me.lv.record.service.impl;

import me.lv.record.dao.AreaDao;
import me.lv.record.dao.RecordDao;
import me.lv.record.entity.AreaDO;
import me.lv.record.entity.RecordDO;
import me.lv.record.entity.dto.RecordDTO;
import me.lv.record.entity.dto.SearchDTO;
import me.lv.record.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<AreaDO> areaDOS = areaDao.listAreas();
        List<RecordDTO> recordDTOS = new ArrayList<>();
        List<RecordDO> recordDOS = recordDao.listRecords(searchDTO);
        Map<String, String> areaMap = new HashMap<>(16);

        areaDOS.forEach(areaDO -> areaMap.put(areaDO.getId(), areaDO.getName()));
        recordDOS.forEach(recordDO -> {
            RecordDTO recordDTO = new RecordDTO();
            BeanUtils.copyProperties(recordDO, recordDTO);
            recordDTO.setRegion(areaMap.get(String.valueOf(recordDO.getRegion())));
            recordDTOS.add(recordDTO);
        });
        return recordDTOS;
    }

    @Override
    public void insertRecord(RecordDTO recordDTO) {

        recordDao.insertRecord(recordDTO);
    }
}
