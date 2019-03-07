package me.lv.record.controller;

import me.lv.record.entity.dto.InsertRecodeDTO;
import me.lv.record.entity.dto.JsonResponse;
import me.lv.record.entity.dto.SearchDTO;
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

    @PostMapping("insertRecord")
    public JsonResponse insertRecord(@RequestBody InsertRecodeDTO recordDTO) {
        recordService.insertRecord(recordDTO);
        return JsonResponse.success();
    }
}
