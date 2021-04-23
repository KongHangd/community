create table USER
(
    ID INT auto_increment,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN CHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);
alter table USER
    add bio VARCHAR(256);
create table question
(
    id int auto_increment,
    title VARCHAR(50),
    description TEXT,
    gmt_create BIGINT,
    gmt_modified BIGINT,
    creator int,
    comment_count int default 0,
    view_count int default 0,
    like_count int default 0,
    tag VARCHAR(256),
    constraint QUESTION_PK
        primary key (id)
);
alter table USER
    add avatar_url VARCHAR(100);
create table comment
(
    id BIGINT auto_increment,
    parent_id BIGINT not null,
    type int not null,
    commentator int not null,
    gmt_create BIGINT not null,
    gmt_modified BIGINT not null,
    like_count BIGINT default 0,
    constraint COMMENT_PK
        primary key (id)
);
alter table COMMENT
    add content VARCHAR(1024);
alter table QUESTION alter column ID BIGINT auto_increment;
alter table `USER` alter column ID BIGINT auto_increment;
alter table QUESTION alter column CREATOR BIGINT not null;
alter table COMMENT alter column COMMENTATOR BIGINT not null;
alter table COMMENT
    add comment_count int default 0;
create table notification
(
    id BIGINT auto_increment,
    notifier BIGINT not null,
    receiver BIGINT not null,
    outer_id BIGINT not null,
    type int not null,
    gmt_create BIGINT not null,
    status int default 0 not null,
    constraint NOTIFICATION_PK
        primary key (id)
);
alter table NOTIFICATION
    add NOTIFIER_NAME VARCHAR(100);

alter table NOTIFICATION
    add OUTER_TITLE VARCHAR(256);
