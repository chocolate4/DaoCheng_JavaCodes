package com.daocheng.work.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_product")
public class Product {

    private Long orderId;

    private Long productId;

    private String productName;

    private Double productPrice;

    private String barcode;

    private Integer number;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

}
