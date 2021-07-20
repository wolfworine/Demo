drop table if exists tb_message;
create table tb_message(
  message_id bigint(200) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  message      varchar(255),
  type_message VARCHAR(255)
);

ALTER TABLE tb_message AUTO_INCREMENT = 1;