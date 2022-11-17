package com.example.seatastorage.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bean.entity.Storage;
import com.example.dao.mapper.StorageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Date: 2022/1/24 18:01
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Service
public class StorageService extends ServiceImpl<StorageMapper, Storage> {

    @Resource
    StorageMapper storageMapper;

    public void deduct(Long id, Long num){
        Storage storage = storageMapper.getInfoById(id);
        if (Objects.isNull(storage)){
            throw new RuntimeException();
        }

        storageMapper.updateNum(id, num);

    }

    public Storage getInfoById(Long id){
        return storageMapper.getInfoById(id);
    }
}
