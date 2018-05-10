package com.wim.service;

import com.wim.dao.ModelTypeMapper;
import com.wim.pojo.ModelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelTypeService implements IModelTypeService {

    @Autowired
    private ModelTypeMapper modelTypeMapper;

    @Override
    public List<ModelType> selectAll() {
        return modelTypeMapper.selectAll();
    }
}
