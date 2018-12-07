CREATE DATABASE estacionamento;
USE estacionamento;

CREATE TABLE cliente(
nome varchar(50),
cpf varchar(16),
email varchar(50),
celular varchar(50),
telefone varchar(50),
cep varchar(50),
primary key (cpf));

CREATE TABLE veiculo(
placa varchar(8),
modelo varchar(20),
marca varchar(20),
cor varchar(20),
porte varchar(20),
cpfC varchar(16),
telefone varchar(50),
horaE timestamp,
horaS timestamp,
tipo varchar(20),
primary key(placa),
foreign key(cpfC) references cliente(cpf)
);

select * from veiculo;
drop database estacionamento;