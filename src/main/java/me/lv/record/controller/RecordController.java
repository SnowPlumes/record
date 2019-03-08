package me.lv.record.controller;

import me.lv.record.entity.dto.InsertRecodeDTO;
import me.lv.record.entity.dto.JsonResponse;
import me.lv.record.entity.dto.SearchDTO;
import me.lv.record.entity.dto.UpdateRecordDTO;
import me.lv.record.exception.ServiceException;
import me.lv.record.service.AreaService;
import me.lv.record.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lv
 */

@CrossOrigin
@RestController
public class RecordController {
    Logger logger = LoggerFactory.getLogger(RecordController.class);

    @Autowired
    private AreaService areaService;

    @Autowired
    private RecordService recordService;

    @GetMapping("listAreas")
    public JsonResponse listAreas() {
        return JsonResponse.success(areaService.listAreas());
    }

    @PostMapping("listRecords")
    public JsonResponse listRecords(@RequestBody SearchDTO searchDTO) {
        return JsonResponse.success(recordService.listRecords(searchDTO));
    }

    @PostMapping("updateRecord")
    public JsonResponse updateRecord(@RequestBody UpdateRecordDTO updateRecordDTO) {
        recordService.updateRecord(updateRecordDTO);
        return JsonResponse.success();
    }

    @PostMapping("insertRecord")
    public JsonResponse insertRecord(@RequestBody InsertRecodeDTO recordDTO) {
        try {
            recordService.insertRecord(recordDTO);
            return JsonResponse.success();
        } catch (ServiceException e) {
            return JsonResponse.fail(e.getMessage());
        }
    }

    @DeleteMapping("deleteRecord")
    public JsonResponse deleteRecord(@RequestParam("recordId") Integer recordId) {
        recordService.deleteRecord(recordId);
        return JsonResponse.success();
    }
}
