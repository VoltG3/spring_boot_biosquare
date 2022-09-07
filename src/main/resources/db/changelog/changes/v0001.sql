CREATE TABLE biosquares (
    id bigserial NOT NULL,
    landcode VARCHAR(2),
    landname VARCHAR(44),
    region VARCHAR(8),
    population BIGINT,
    landarea FLOAT,
    landmap VARCHAR(39),
    PRIMARY KEY (id)
);

create sequence biosquares_id start with 1000;