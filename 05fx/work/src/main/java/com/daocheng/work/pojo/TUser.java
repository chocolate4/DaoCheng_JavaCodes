package com.daocheng.work.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class TUser {
    //将属性所对应的字段指定为主键
    @TableId(value = "id",type = IdType.AUTO) //value属性用于指定主键字段,并设置自增id，数据库字段也需要是自增id
    private Integer id;
    //指定字段名
    @TableField("username")
    private String username;  //UserName 默认对应 user_name

    private String password;

    private Integer age;

    private String sex;

    private String email;

    @TableLogic //逻辑删除
    private Integer isDelete;
}
