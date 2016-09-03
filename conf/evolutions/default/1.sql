# --- !Ups

create table companies (
    status ENUM( 'ACTIVE', 'INACTIVE', 'ON HOLD') NOT NULL,
    abc_id CHAR(7) NOT NULL,
    name VARCHAR(255),
    
    primary key (abc_id)
);

# --- !Downs

drop table if exists contacts;