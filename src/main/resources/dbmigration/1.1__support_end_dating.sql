-- apply changes
create table leitura (
  id                            bigint auto_increment not null,
  version                       integer not null,
  hora                          time not null,
  leitura                       varchar(255) not null,
  observacao                    varchar(255) not null,
  quant                         integer not null,
  status                        varchar(7) not null,
  coleta_id                     bigint not null,
  produto_id                    bigint not null,
  saldo                         integer not null,
  constraint ck_leitura_status check ( status in ('SUCESSO','ERRO')),
  constraint pk_leitura primary key (id)
);

create index ix_leitura_coleta_id on leitura (coleta_id);
alter table leitura add constraint fk_leitura_coleta_id foreign key (coleta_id) references coleta (id) on delete restrict on update restrict;

create index ix_leitura_produto_id on leitura (produto_id);
alter table leitura add constraint fk_leitura_produto_id foreign key (produto_id) references produto (id) on delete restrict on update restrict;

