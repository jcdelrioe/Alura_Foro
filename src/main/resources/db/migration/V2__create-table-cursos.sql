create table cursos(
id bigint not null auto_increment,
nombre_curso varchar(200) not null unique,
categoria varchar(100) not null,

primary key(id)
)