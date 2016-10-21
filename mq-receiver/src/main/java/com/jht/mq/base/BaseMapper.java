package com.jht.mq.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by ${huipei.x} on 2016/8/15.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
