drop table if exists t_user;

/*==============================================================*/
/* Table: user                                                */
/*==============================================================*/
create table t_user (
   user_id              int auto_increment primary key,
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
   state                int                  default 0,
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
   create_time          timestamp not null default 0,
   update_time          timestamp not null default 0
);

drop table if exists t_department;

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table t_department (
   dept_id             int primary key auto_increment,
   dept_name            varchar(32)          null,
   dept_code            varchar(32)          null,
   leader_user_id       int                  null,
   dept_tel             varchar(32)          null,
   dept_fax             varchar(32)          null,
   dept_typeid          int                  null,
   state                int                  default 0,
   dept_area            varchar(32)          null,
   dept_address         varchar(32)          null,
   dept_email           varchar(32)          null,
   p_id                 int                  null,
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
   dict_code            varchar(32)          primary key,
   dict_name            varchar(32)          null,
   dict_type            varchar(32)          null,
   state                int                  default 0,
   remark               varchar(255)         null
);

drop table if exists t_role;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table t_role (
   role_code          varchar(32)  primary key,
   role_name            varchar(32)   unique null,
   sys                  int                  null,
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
   menu_code            varchar(32)    primary key,
   menu_parent          varchar(32)         not null,
   menu_name            varchar(32)          null,
   link                 varchar(32)          null,
   sort                  int                  null,
   state                int                  default 0,
   btn                  int                  null
);

drop table if exists t_role_menu;

/*==============================================================*/
/* Table: role_menu                                             */
/*==============================================================*/
drop table if exists t_role_menu;
create table t_role_menu (
   role_code              varchar(32)                  not null,
   menu_code              varchar(32)                  not null,
   primary key (role_code, menu_code)
);
/*==============================================================*/
/* Table: user_dept                                             */
/*==============================================================*/
drop table if exists t_user_dept;
create table t_user_dept (
   user_id              int                  not null,
   dept_id              int                  not null,
   primary key (user_id, dept_id)
);
