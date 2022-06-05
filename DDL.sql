create schema store;

use store;

create user 'user'@'localhost' identified by 'pass123';

grant select, delete, update on store.* to user@'localhost';

create table vendedor (
  vendedor_id bigint unsigned not null auto_increment,
  vendedor_nome varchar(20) not null,
  vendedor_matricula varchar(50) not null,
  primary key (vendedor_id),
  unique key uni_vendedor_nome (vendedor_nome)
);

create table produto (
  produto_id bigint unsigned not null auto_increment,
  produto_nome varchar(20) not null,
  produto_preco float not null,
  primary key (produto_id),
  unique key uni_produto_nome (produto_nome)
);

create table cliente (
  cliente_id bigint unsigned not null auto_increment,
  cliente_nome varchar(20) not null,
  cliente_matricula varchar(50) not null,
  primary key (cliente_id),
  unique key uni_cliente_nome (cliente_nome)
);

create table compra (
  produto_id bigint unsigned not null,
  cliente_id bigint unsigned not null,
  vendedor_id bigint unsigned not null,
  primary key (produto_id, cliente_id, vendedor_id),
  foreign key compra_produto_fk (produto_id) references produto (produto_id),
  foreign key compra_cliente_fk (cliente_id) references cliente (cliente_id),
  foreign key compra_vendedor_fk (vendedor_id) references vendedor (vendedor_id)
);