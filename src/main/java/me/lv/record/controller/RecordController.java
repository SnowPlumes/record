package me.lv.record.controller;

import me.lv.record.entity.AreaDO;
import me.lv.record.entity.dto.JsonResponse;
import me.lv.record.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author lv
 */

@CrossOrigin
@RestController
public class RecordController {
    Logger logger = LoggerFactory.getLogger(RecordController.class);

    @Autowired
    private AreaService areaService;

    @GetMapping("listAreas")
    public JsonResponse listAreas() {
        return JsonResponse.success(areaService.listAreas());
    }

}
