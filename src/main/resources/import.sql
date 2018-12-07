/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  madave91
 * Created: 14-Oct-2018
 */

insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (1, 'Absolut Vodka', 500, 1.4, 1.4, 'shot','vodka');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (2, 'Aperol', 400, 1.4, 1.4, 'shot','liqueur');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (3, 'Bacardi Carta Blanca', 600, 2.1, 2.1, 'shot','rum');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (4, 'Bacardi Limon', 600, 1.4, 1.4, 'shot','rum');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (5, 'Bacardi Mojito', 650, 1.4, 1.4, 'shot','rum');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (6, 'Baileys', 700, 0.7, 0.7, 'shot','liqueur');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (7, 'Ballantines', 600, 1.4, 1.4, 'shot','whisky');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (8, 'Becherovka', 500, 1.4, 1.4, 'shot','liqueur');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (9, 'Beefeater', 700, 1.4, 1.4, 'shot','gin');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (10,' Berentzen Apfel', 600, 0.7, 0.7, 'shot','liqueur');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (11, 'Bols Vodka', 450, 1.4, 1.4, 'shot','vodka');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (12, 'Campari', 500, 0.7, 0.7, 'shot','liqueur');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (13, 'Captain Morgan White', 600, 1.4, 1.4, 'shot','rum');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (14, 'Captain Morgan Spice', 600, 1.4, 1.4, 'shot','rum');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (15, 'Chivas Regal 12', 600, 1.4, 1.4, 'shot','whisky');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (16, 'Chivas Regal 18', 800, 1.4, 1.4, 'shot','whisky');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (17, 'Famous Grouse', 600, 1.4, 1.4, 'shot','whisky');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (18, 'Finlandia', 550, 2.1, 2.1, 'shot','vodka');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (19, 'Jack Daniels', 550, 1.4, 1.4, 'shot','whisky');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (20, 'Jagermeister', 450, 2.8, 2.8, 'shot','liqueur');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (21, 'Jameson', 600, 1.4, 1.4, 'shot','whiksy');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (22, 'Jim Beam', 550, 1.4, 1.4, 'shot','whiksy');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (23, 'Johnnie Walker Red Label', 550, 1.4, 1.4, 'shot','whiksy');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (24, 'Johnnie Walker Black Label', 700, 1.4, 1.4, 'shot','whiksy');
insert into products (product_id, product_name, product_price, product_default_quantity, product_actual_quantity, product_type, product_details) values (25, 'Johnnie Walker Black Label', 700, 1.4, 1.4, 'shot','whiksy');

insert into users (user_id, user_fname, user_lname, user_login_name, birth_date, email, phone_number) values(1, 'David', 'Madacsi', 'madave91', '1991-03-24', 'madave91@gmail.com', '+3307615902');
insert into users (user_id, user_fname, user_lname, user_login_name, birth_date, email, phone_number) values(2, 'Ders', 'Horvath', 'ders', '1992-11-03', 'minkosful@gmail.com', '+3670124578');
insert into users (user_id, user_fname, user_lname, user_login_name, birth_date, email, phone_number) values(3, 'Domonkos', 'Nemeth', 'minkos', '1993-09-22', 'ders@gmail.com', '+36302548474');

insert into customer_order(order_id, order_date, paid, price) values (1, sysdate(), false, 0)
insert into customer_order(order_id, order_date, paid, price) values (2, sysdate(), true, 0)

insert into customer_order_product(transaction_id, comment, price, quantity, customer_order_order_id, product_name) values (1, 'citrommal', 550, 3, 1, 'Finlandia')
insert into customer_order_product(transaction_id, comment, price, quantity, customer_order_order_id, product_name) values (2, '', 600, 3, 1, 'Jameson')

insert into tables(table_id, seat_number) values (1, 5)
insert into tables(table_id, seat_number) values (2, 6)
insert into tables(table_id, seat_number) values (3, 4)

insert into reservations(reservation_id, table_table_id, reservation_name, reservation_date, from_time, until_time)values(1,1, 'Kis Lajos', '2019-01-22', PARSEDATETIME('16:30', 'HH:mm'), PARSEDATETIME('18:00', 'HH:mm'))
insert into reservations(reservation_id, table_table_id, reservation_name, reservation_date, from_time, until_time)values(2,1, 'Hurrikán Hugó', '2019-01-22', PARSEDATETIME('17:30', 'HH:mm'), PARSEDATETIME('19:30', 'HH:mm'))
insert into reservations(reservation_id, table_table_id, reservation_name, reservation_date, from_time, until_time)values(3,2, 'Dzsuvás Django','2019-02-23', PARSEDATETIME('16:30', 'HH:mm'), PARSEDATETIME('18:00', 'HH:mm'))
insert into reservations(reservation_id, table_table_id, reservation_name, reservation_date, from_time, until_time)values(4,3, 'Huszár Herold', '2019-01-20', PARSEDATETIME('16:30', 'HH:mm'), PARSEDATETIME('18:00', 'HH:mm'))
insert into reservations(reservation_id, table_table_id, reservation_name, reservation_date, from_time, until_time)values(5,1, 'Fiktív Ferenc', '2019-01-10', PARSEDATETIME('16:30', 'HH:mm'), PARSEDATETIME('18:00', 'HH:mm'))

insert into work_schedule(schedule_id, user_user_id, work_date, from_time, until_time) values(1, 1, '2018-11-12', PARSEDATETIME('10:30', 'HH:mm'), PARSEDATETIME('18:00', 'HH:mm'))
insert into work_schedule(schedule_id, user_user_id, work_date, from_time, until_time) values(2, 2, '2018-11-12', PARSEDATETIME('17:30', 'HH:mm'), PARSEDATETIME('04:00', 'HH:mm'))
insert into work_schedule(schedule_id, user_user_id, work_date, from_time, until_time) values(3, 1, '2018-11-13', PARSEDATETIME('10:30', 'HH:mm'), PARSEDATETIME('18:00', 'HH:mm'))



