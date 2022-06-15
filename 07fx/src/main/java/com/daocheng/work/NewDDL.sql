CREATE TABLE t_order (
order_id BIGINT NOT NULL COMMENT '订单id',
order_status VARCHAR(32) NOT NULL DEFAULT '' COMMENT '订单状态',
product_count int NOT NULL DEFAULT 0 COMMENT '订单中商品数量',
price double NOT NULL DEFAULT 0.0 COMMENT '订单价格',
user_id BIGINT NOT NULL DEFAULT 0 COMMENT '用户id',
order_create_time bigint NOT NULL DEFAULT 0 COMMENT '订单创建时间',
order_finish_time bigint NOT NULL DEFAULT 0 COMMENT '订单完成时间',
create_time datetime NOT NULL DEFAULT '9999-12-31:23:59:59' COMMENT '记录创建时间',
update_time datetime NOT NULL DEFAULT '9999-12-31:23:59:59' COMMENT '记录修改时间',
is_delete TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除',
PRIMARY KEY(order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '订单信息'
;



CREATE TABLE t_user (
  user_id BIGINT NOT NULL COMMENT '用户id',
  address_id INT NOT NULL DEFAULT 0 COMMENT '地址id',
  user_name varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  password varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  phone_number INT NOT NULL DEFAULT 0 COMMENT '电话号',
  email varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
  sex TINYINT NOT NULL DEFAULT 0 COMMENT '性别',
  age SMALLINT NOT NULL DEFAULT 0 COMMENT '年龄',
  zip INT NOT NULL DEFAULT 0 COMMENT '邮政编码',
  create_time datetime NOT NULL DEFAULT '9999-12-31:23:59:59' COMMENT '记录创建时间',
  update_time datetime NOT NULL DEFAULT '9999-12-31:23:59:59' COMMENT '记录修改时间',
  is_delete TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户信息'
;

CREATE TABLE t_product (
  order_id BIGINT NOT NULL PRIMARY KEY COMMENT '订单id',
  product_id BIGINT NOT NULL DEFAULT 0 COMMENT '产品id',
  product_name varchar(128) NOT NULL DEFAULT '' COMMENT '商品名',
  product_price double NOT NULL DEFAULT 0.0 COMMENT '商品出厂价',
  barcode varchar(64) NOT NULL DEFAULT '0' COMMENT '条形码',
  number int NOT NULL DEFAULT 0 COMMENT '订单中商品数量',
  create_time datetime NOT NULL DEFAULT '9999-12-31:23:59:59' COMMENT '记录创建时间',
  update_time datetime NOT NULL DEFAULT '9999-12-31:23:59:59' COMMENT '记录修改时间',
  is_delete TINYINT NOT NULL DEFAULT 0 COMMENT '逻辑删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '商品信息'
;


CREATE TABLE `t_address` (
  `address_id` INT NOT NULL DEFAULT 0 COMMENT '地址id',
  `county` varchar(32) NOT NULL DEFAULT '' COMMENT '国家',
  `province` varchar(32) NOT NULL DEFAULT '' COMMENT '省份',
  `city` varchar(32) NOT NULL DEFAULT '' COMMENT '城市',
  `area` varchar(32) NOT NULL DEFAULT '' COMMENT '地区',
  `street` varchar(32) NOT NULL DEFAULT '' COMMENT '街道'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '地区维表'
;