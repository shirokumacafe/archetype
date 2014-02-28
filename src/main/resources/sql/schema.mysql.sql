drop table if exists t_user;

/*==============================================================*/
/* Table: user                                                */
/*==============================================================*/
create table t_user (
   user_id              int auto_increment primary key,
   login_name           varchar(32)          unique,
   password             varchar(255)         null,
   salt                 varchar(32)          null,
   user_role          int                    null,
   state                int                  default 0,
   create_id            int                  null,
   update_id            int                  null,
   create_time          timestamp not null default 0,
   update_time          timestamp not null default 0
);

drop table if exists t_user_info;
create table t_user_info (
   user_id              int primary key,
   user_code            varchar(32)         unique null,
   user_name            varchar(32)          null,
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
   email                varchar(32)          null
);

drop table if exists t_department;

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table t_department (
   dept_id             int primary key auto_increment,
   dept_name            varchar(32)          null,
   dept_code            varchar(32)          unique,
   leader_user_id       int                  null,
   dept_tel             varchar(32)          null,
   dept_fax             varchar(32)          null,
   dept_typeid          int                  null,
   state                int                  default 0,
   dept_area            varchar(32)          null,
   dept_address         varchar(32)          null,
   dept_email           varchar(32)          null,
   dept_pid                 int                  null,
   sort              int                  null,
   create_id            int                  null,
   update_id            int                  null,
   create_time          timestamp not null default 0,
   update_time          timestamp not null default 0
);

drop table if exists t_dict;

/*==============================================================*/
/* Table: dict                                                  */
/*==============================================================*/
create table t_dict (
   dict_id                int primary key auto_increment,
   dict_code            varchar(32)         unique ,
   dict_name            varchar(32)          null,
   dict_type            varchar(32)          null,
   state                int                  default 0,
   remark               varchar(255)         null,
   sort              int                  null,
   create_id            int                  null,
   update_id            int                  null,
   create_time          timestamp not null default 0,
   update_time          timestamp not null default 0
);

drop table if exists t_role;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table t_role (
   role_id              int primary key auto_increment,
   role_code          varchar(32)  unique,
   role_name            varchar(32)   null,
   role_menu      varchar(255) null,
   sys                  int                  not null default 0,
   remark               varchar(255)         null,
   state                int                  default 0,
   create_id            int                  null,
   update_id            int                  null,
   create_time          timestamp not null default 0,
   update_time          timestamp not null default 0
);

drop table if exists t_menu;

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table t_menu (
   menu_id              int primary key auto_increment,
   menu_code            varchar(32)    unique,
   menu_pid          varchar(32)         not null,
   menu_name            varchar(32)          null,
   menu_link                 varchar(32)          null,
   sort                  int                  null,
   state                int                  default 0,
   btn                  int                  default 0
);

drop table if exists t_button;

create table t_button (
   button_id              int primary key auto_increment,
   button_name            varchar(32)          null,
   button_value                 varchar(32)          null
);

drop table if exists t_config;
create table t_config (
   config_id              int primary key auto_increment,
   config_name            varchar(32)          null,
   config_value                 varchar(32)          null,
   remark                 varchar(255) null
);
