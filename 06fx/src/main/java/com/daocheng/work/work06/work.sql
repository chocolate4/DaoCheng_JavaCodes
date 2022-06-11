CREATE TABLE `order` (
  `order_id` varchar(100) PRIMARY KEY,
  `order_status` varchar(100),
  `product_count` int ,
  `price` double,
  `user_id` varchar(100),
  `order_create_time` varchar(100),
  `order_settlement_time` varchar(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;


CREATE TABLE `user` (
  `user_id` varchar(100) PRIMARY KEY,
  `address_id` varchar(100),
  `name` varchar(100),
  `phone_number` varchar(100),
  `email` varchar(100),
  `sex` varchar(100),
  `age` varchar(100),
  `county` varchar(100),
  `province` varchar(100),
  `city` varchar(100),
  `area` varchar(100),
  `street` varchar(100),
  `zip` varchar(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;

CREATE TABLE `product` (
  `order_id` varchar(100) PRIMARY KEY,
  `product_id` varchar(100),
  `product_name` varchar(100) ,
  `product_price` double,
  `barcode` varchar(100),
  `number` int
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;