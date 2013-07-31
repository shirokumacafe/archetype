drop table if exists users;

/*==============================================================*/
/* Table: user                                                */
/*==============================================================*/
create table users (
   user_id              SERIAL not null,
   user_code            varchar(32)          null,
   user_name            varchar(32)          null,
   login_name           varchar(32)          null,
   password             varchar(255)         null,
   salt                 varchar(32)          null,
   sex                  int                  null,
   idcard_address       varchar(64)          null,
   idcard               varchar(32)          null,
   home_address         varchar(64)          null,
   tel                  varchar(32)          null,
   contact_tel          varchar(32)          null,
   contact_name         varchar(32)          null,
   bank_dict              varchar(32)                  null,
   bank_account         varchar(32)          null,
   birthday             date                 null,
   state                int                  null,
   postion_level_dict     varchar(32)                  null,
   salary               decimal(8,2)         null,
   postion_state        int                  null,
   join_date            date                 null,
   leave_date           date                 null,
   regular_date         date                 null,
   nation_dict            varchar(32)                  null,
   photo                varchar(64)          null,
   remark               varchar(255)         null,
   postion_dict           varchar(32)                  null,
   major_dict             varchar(32)                  null,
   education_dict         varchar(32)                  null,
   graduate             varchar(32)          null,
   polity               varchar(32)          null,
   qq                   varchar(32)          null,
   email                varchar(32)          null,
   create_id            int                  null,
   update_id            int                  null,
   create_time          TIMESTAMP WITH TIME ZONE null,
   update_time          TIMESTAMP WITH TIME ZONE null,
   constraint PK_USERS primary key (user_id)
);

drop table if exists department;

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table department (
   dept_id              SERIAL not null,
   dept_name            varchar(32)          null,
   dept_code            varchar(32)          null,
   leader_user_id       int                  null,
   dept_tel             varchar(32)          null,
   dept_fax             varchar(32)          null,
   dept_typeid          int                  null,
   state                int                  null,
   dept_area            varchar(32)          null,
   dept_address         varchar(32)          null,
   dept_email           varchar(32)          null,
   p_id                 int                  null,
   sort              int                  null,
   create_id            int                  null,
   update_id            int                  null,
   create_time          TIMESTAMP WITH TIME ZONE null,
   update_time          TIMESTAMP WITH TIME ZONE null,
   constraint PK_DEPARTMENT primary key (dept_id)
);

drop table if exists dict;

/*==============================================================*/
/* Table: dict                                                  */
/*==============================================================*/
create table dict (
   dict_code            varchar(32)          not null,
   dict_name            varchar(32)          null,
   dict_type            varchar(32)          null,
   state                int                  null,
   remark               varchar(255)         null,
   constraint PK_DICT primary key (dict_code)
);

drop table if exists role;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role (
   role_code            varchar(32),
   role_name            varchar(32)   unique null,
   sys                  int                  null,
   remark               varchar(255)         null,
   state                int                  null,
   create_id            int                  null,
   update_id            int                  null,
   create_time          TIMESTAMP WITH TIME ZONE null,
   update_time          TIMESTAMP WITH TIME ZONE null,
   constraint PK_ROLE primary key (role_code)
);

drop table if exists menu;

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu (
   menu_code            varchar(32)    not null,
   menu_parent          varchar(32)         not null,
   menu_name            varchar(32)          null,
   link                 varchar(32)          null,
   sort                  int                  null,
   state                int                  null,
   btn                  int                  null,
   constraint PK_MENU primary key (menu_code)
);

drop table if exists role_menu;

/*==============================================================*/
/* Table: role_menu                                             */
/*==============================================================*/
drop table if exists role_menu;
create table role_menu (
   role_code              varchar(32)                  not null,
   menu_code              varchar(32)                  not null,
   constraint PK_ROLE_MENU primary key (role_code, menu_code)
);
/*==============================================================*/
/* Table: user_dept                                             */
/*==============================================================*/
drop table if exists user_dept;
create table user_dept (
   user_id              int                  not null,
   dept_id              int                  not null,
   constraint PK_USER_DEPT primary key (user_id, dept_id)
);
