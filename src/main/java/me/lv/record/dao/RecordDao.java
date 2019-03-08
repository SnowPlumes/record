package me.lv.record.dao;

import me.lv.record.entity.RecordDO;
import me.lv.record.entity.dto.InsertRecodeDTO;
import me.lv.record.entity.dto.RecordDTO;
import me.lv.record.entity.dto.SearchDTO;
import me.lv.record.entity.dto.UpdateRecordDTO;

import java.util.List;

/**
 * @author lv
 */
public interface RecordDao {

    /**
     * 根据抬头获取记录
     *
     * @param title
     * @return
     */
    RecordDO getRecordByTitle(String title);

    /**
     * 获取记录
     *
     * @param searchDTO
     * @return
     */
    List<RecordDTO> listRecords(SearchDTO searchDTO);

    /**
     * 新增记录
     *
     * @param recordDTO
     */
    void insertRecord(InsertRecodeDTO recordDTO);

    /**
     * 删除记录
     *
     * @param id
     */
    void deleteRecord(Integer id);

    /**
     * 修改记录
     *
     * @param updateRecordDTO
     */
    void updateRecord(UpdateRecordDTO updateRecordDTO);
}
