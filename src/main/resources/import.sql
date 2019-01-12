insert into clients (name,city,address,phone) values ('Diana Gallego', 'Cartagena','San Fernando','123');
insert into clients (name,city,address,phone) values ('Luis Lopez', 'Bogota','Kennedy','789654');
insert into clients (name,city,address,phone) values ('Mariana Pajon', 'Medellin','Poblado','456321');
insert into clients (name,city,address,phone) values ('Carlos Lopez', 'Cartagena','Amberes','6632514');
insert into clients (name,city,address,phone) values ('Claudia Donado', 'Santa Marta','La troncal','7896541');
insert into clients (name,city,address,phone) values ('Jairo Perez', 'Perira','Ibiza','74125369');
insert into clients (name,city,address,phone) values ('Valery Melendez', 'Monteria','Robles','7455215');
insert into clients (name,city,address,phone) values ('Eduardo Castro', 'Bogota','Chico','741258');
insert into clients (name,city,address,phone) values ('Luis Lopez', 'Cartagena','Bocagrande','1234523');
--Tarjetas
insert into client_cards(cliente_id_client,number,ccv,card_type) values (1,4556362514258796,556,'Credito');
insert into client_cards(cliente_id_client,number,ccv,card_type) values (1,4554563211425879,425,'Debito');
insert into client_cards(cliente_id_client,number,ccv,card_type) values (3,7896563211425879,7896,'Debito');
insert into client_cards(cliente_id_client,number,ccv,card_type) values (4,4212358532652321,789,'Credito');
insert into client_cards(cliente_id_client,number,ccv,card_type) values (6,7854263215236524,654,'Debito');
insert into client_cards(cliente_id_client,number,ccv,card_type) values (3,9865847563214587,123,'Debito');
insert into client_cards(cliente_id_client,number,ccv,card_type) values (5,5785522222522222,741,'Credito');
insert into client_cards(cliente_id_client,number,ccv,card_type) values (2,1235242365865475,852,'Debito');
insert into client_cards(cliente_id_client,number,ccv,card_type) values (4,4563218532142365,963,'Debito');

--consumos
insert into consumption_client(description,amount,tarjeta_id_card,create_at) values ('Compra de TV', 2560999, 1, '2017-01-01');
insert into consumption_client(description,amount,tarjeta_id_card,create_at) values ('Crucero', 12560400, 1, '2018-10-05');
insert into consumption_client(description,amount,tarjeta_id_card,create_at) values ('Compra de Carro', 40230990, 2,'2015-08-11');
insert into consumption_client(description,amount,tarjeta_id_card,create_at) values ('Pago de Matricula', 5890000, 3,'2017-06-03');

--asesor

insert into agent(name,speciality) values ('Oscar Lopez', 'Agente Comercial');
insert into agent(name,speciality) values ('Martelito Perez', 'Agente Ejecutivo');
insert into agent(name,speciality) values ('Andres Rodriguez', 'Agente Banca Empresarial');
insert into agent(name,speciality) values ('Pepito Castañeda', 'Agente Banca Personal');
insert into agent(name,speciality) values ('Andres Posada', 'Agente de Vivienda');
insert into agent(name,speciality) values ('Isabella Madrid', 'Agente de Autos');
insert into agent(name,speciality) values ('Luna Rehenals', 'Agente de Libranza');

