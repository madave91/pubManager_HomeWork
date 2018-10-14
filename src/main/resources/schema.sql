/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  madave91
 * Created: 14-Oct-2018
 */
DROP TABLE IF EXISTS products;
CREATE TABLE products
(
    product_id BIGINT auto_increment not null,
    product_name varchar(255) not null,
    product_price integer not null,
    product_default_quantity real not null,
    product_actual_quantity real not null,
    product_type varchar(20),
    product_details varchar(255),
    primary key(product_id)
);
