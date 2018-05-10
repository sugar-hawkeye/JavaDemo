package com.wim.controller;

import com.wim.pojo.ModelType;
import com.wim.service.IModelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/modelType")
public class ModelTypeController {

    @Autowired
    private IModelTypeService modelTypeService;

    @GetMapping()
    public String Get(){
        List<ModelType> modelTypeList = modelTypeService.selectAll();
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(modelTypeList);
        return jsonResult;
    }
}
