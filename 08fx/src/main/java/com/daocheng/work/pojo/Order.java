package com.daocheng.work.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;

import java.util.Date;

@TableName("t_order")
@Data
public class Order {

    private Long orderId;

    private String orderStatus;

    private Integer productCount;

    private Double price;

    private Long userId;

    private Long orderCreateTime;

    private Long orderFinishTime;

    private Date createTime; //datetime

    private Date updateTime; //datetime

    private Byte isDelete;
}
