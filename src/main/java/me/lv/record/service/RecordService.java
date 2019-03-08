package me.lv.record.service;

import com.github.pagehelper.PageInfo;
import me.lv.record.entity.dto.InsertRecodeDTO;
import me.lv.record.entity.dto.RecordDTO;
import me.lv.record.entity.dto.SearchDTO;
import me.lv.record.entity.dto.UpdateRecordDTO;

/**
 * @author lv
 */
public interface RecordService {

    /**
     * 获取记录
     *
     * @param searchDTO
     * @return
     */
    PageInfo<RecordDTO> listRecords(SearchDTO searchDTO);

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
