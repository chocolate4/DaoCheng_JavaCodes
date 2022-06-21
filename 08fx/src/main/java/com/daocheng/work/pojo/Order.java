package com.daocheng.work.pojo;

import lombok.Data;

import java.util.Date;

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
