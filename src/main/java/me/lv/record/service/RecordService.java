package me.lv.record.service;

import me.lv.record.entity.dto.InsertRecodeDTO;
import me.lv.record.entity.dto.RecordDTO;
import me.lv.record.entity.dto.SearchDTO;

import java.util.List;

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
    List<RecordDTO> listRecords(SearchDTO searchDTO);

    /**
     * 新增记录
     *
     * @param recordDTO
     */
    void insertRecord(InsertRecodeDTO recordDTO);
}
