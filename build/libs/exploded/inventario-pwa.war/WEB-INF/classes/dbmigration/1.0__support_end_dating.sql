-- apply changes
create table cl (
  id                            bigint auto_increment not null,
  version                       integer not null,
  clno                          integer not null,
  departamento                  varchar(255) not null,
  grupo                         varchar(255) not null,
  secao                         varchar(255) not null,
  constraint pk_cl primary key (id)
);

create table coleta (
  id                            bigint auto_increment not null,
  version                       integer not null,
  numleitura                    integer not null,
  inventario_id                 bigint not null,
  lote_id                       bigint not null,
  usuario_id                    bigint not null,
  coletor                       integer not null,
  status                        varchar(7) not null,
  constraint ck_coleta_status check ( status in ('FECHADO','ABERTO')),
  constraint pk_coleta primary key (id)
);

create table fornecedor (
  id                            bigint auto_increment not null,
  version                       integer not null,
  codigo                        varchar(255) not null,
  fantazia                      varchar(255) not null,
  razao                         varchar(255) not null,
  constraint pk_fornecedor primary key (id)
);

create table inventario (
  id                            bigint auto_increment not null,
  version                       integer not null,
  numero                        integer not null,
  data                          date not null,
  observacao                    varchar(255) not null,
  tipoinventario                varchar(16) not null,
  statusinventario              varchar(7) not null,
  loja_id                       bigint not null,
  fornecedor_id                 bigint,
  cl_id                         bigint,
  constraint ck_inventario_tipoinventario check ( tipoInventario in ('Com divergencias','Simples')),
  constraint ck_inventario_statusinventario check ( statusInventario in ('Aberto','Fechado')),
  constraint pk_inventario primary key (id)
);

create table loja (
  id                            bigint auto_increment not null,
  version                       integer not null,
  endereco                      varchar(255) not null,
  nome                          varchar(255) not null,
  sigla                         varchar(255) not null,
  storeno                       integer not null,
  constraint pk_loja primary key (id)
);

create table lote (
  id                            bigint auto_increment not null,
  version                       integer not null,
  descricao                     varchar(255) not null,
  loteavulso                    tinyint(1) default 0 not null,
  numero                        varchar(255) not null,
  loja_id                       bigint not null,
  constraint pk_lote primary key (id)
);

create table produto (
  id                            bigint auto_increment not null,
  version                       integer not null,
  barcode                       varchar(255) not null,
  codigo                        varchar(255) not null,
  descricao                     varchar(255) not null,
  duplicado                     tinyint(1) default 0 not null,
  foralinha                     tinyint(1) default 0 not null,
  grade                         varchar(255) not null,
  usoconsumo                    tinyint(1) default 0 not null,
  cl_id                         bigint not null,
  fornecedor_id                 bigint not null,
  constraint pk_produto primary key (id)
);

create table usuario (
  id                            bigint auto_increment not null,
  version                       integer not null,
  matricula                     integer not null,
  nome                          varchar(255) not null,
  senha                         varchar(255) not null,
  apelido                       varchar(255) not null,
  constraint pk_usuario primary key (id)
);

create index ix_coleta_inventario_id on coleta (inventario_id);
alter table coleta add constraint fk_coleta_inventario_id foreign key (inventario_id) references inventario (id) on delete restrict on update restrict;

create index ix_coleta_lote_id on coleta (lote_id);
alter table coleta add constraint fk_coleta_lote_id foreign key (lote_id) references lote (id) on delete restrict on update restrict;

create index ix_coleta_usuario_id on coleta (usuario_id);
alter table coleta add constraint fk_coleta_usuario_id foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;

create index ix_inventario_loja_id on inventario (loja_id);
alter table inventario add constraint fk_inventario_loja_id foreign key (loja_id) references loja (id) on delete restrict on update restrict;

create index ix_inventario_fornecedor_id on inventario (fornecedor_id);
alter table inventario add constraint fk_inventario_fornecedor_id foreign key (fornecedor_id) references fornecedor (id) on delete restrict on update restrict;

create index ix_inventario_cl_id on inventario (cl_id);
alter table inventario add constraint fk_inventario_cl_id foreign key (cl_id) references cl (id) on delete restrict on update restrict;

create index ix_lote_loja_id on lote (loja_id);
alter table lote add constraint fk_lote_loja_id foreign key (loja_id) references loja (id) on delete restrict on update restrict;

create index ix_produto_cl_id on produto (cl_id);
alter table produto add constraint fk_produto_cl_id foreign key (cl_id) references cl (id) on delete restrict on update restrict;

create index ix_produto_fornecedor_id on produto (fornecedor_id);
alter table produto add constraint fk_produto_fornecedor_id foreign key (fornecedor_id) references fornecedor (id) on delete restrict on update restrict;

