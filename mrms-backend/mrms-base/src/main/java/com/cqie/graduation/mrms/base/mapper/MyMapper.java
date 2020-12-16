package com.cqie.graduation.mrms.base.mapper;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author xd
 */
@Repository
public interface MyMapper<T> extends BaseMapper<T>, Mapper<T>, MySqlMapper<T> {

}