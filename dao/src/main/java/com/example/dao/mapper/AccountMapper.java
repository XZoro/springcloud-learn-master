package com.example.dao.mapper;

import com.example.bean.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 000061382
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    Account getInfoByUserId(@Param("userId") String userId);

}




