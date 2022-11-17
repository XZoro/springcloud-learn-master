package com.example.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bean.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 000061382
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {


    Storage getInfoById(@Param("id") Long id);

    void updateNum(@Param("id") Long id, @Param("num") Long num);

}




