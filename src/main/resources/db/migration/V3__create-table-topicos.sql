create table topicos(
id bigint not null auto_increment,
titulo varchar(100) not null unique,
mensaje varchar(200) not null unique,
fecha_creacion datetime not null,
estatus varchar(100) not null,
curso_id bigint not null,
usuario_id bigint not null,

primary key(id)
)