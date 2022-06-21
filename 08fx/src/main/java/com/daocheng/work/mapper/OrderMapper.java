package com.daocheng.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daocheng.work.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> findAll();
}
