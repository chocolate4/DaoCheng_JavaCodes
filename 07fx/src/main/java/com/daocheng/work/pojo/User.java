package com.daocheng.work.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user")
public class User {

    private Long userId;

    private Integer addressId;

    private Character userName;

    private String password;

    private Long phoneNumber;

    private String email;

    private Byte sex;

    private Short age;

    private Integer zip;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;
}
