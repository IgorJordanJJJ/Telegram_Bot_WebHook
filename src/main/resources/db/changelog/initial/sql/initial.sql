CREATE TABLE test(
    id               integer,
    nickname         varchar(256),
    rang             varchar(256),
    number_of_points integer not null,
    admin            CHAR(1) DEFAULT 'N' CHECK (admin IN ('Y', 'N'))
)
