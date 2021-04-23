alter table NOTIFICATION drop column "outerId";

alter table NOTIFICATION
    add OUTER_ID BIGINT not null;