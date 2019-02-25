package me.lv.record.dao;

import me.lv.record.entity.RecordDO;
import me.lv.record.entity.dto.RecordDTO;
import me.lv.record.entity.dto.SearchDTO;

import java.util.List;

/**
 * @author lv
 */
public interface RecordDao {

    /**
     * 获取记录
     *
     * @param searchDTO
     * @return
     */
    List<RecordDO> listRecords(SearchDTO searchDTO);

    /**
     * 新增记录
     *
     * @param recordDTO
     */
    void insertRecord(RecordDTO recordDTO);
}
