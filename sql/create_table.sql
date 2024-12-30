-- 创建库
create database if not exists jd_registration;

-- 切换库
use jd_registration;

-- 机构表
create table if not exists t_org_info
(
    id           int auto_increment comment '主键ID' primary key,
    hospital_no   char(32)                            not null comment '医院编码',
    hospital_name varchar(128)                        not null comment '医院名称',
    introduction varchar(256)                         null comment '医院简介',
    address      varchar(128)                         null comment '医院地址',
    logo         varchar(128)                         null comment '医院logo',
    status       tinyint                              not null comment '状态 0-停用 1-启用',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '机构表' collate = utf8mb4_unicode_ci;

-- 科室表
create table if not exists t_dept_info
(
    id           int auto_increment comment '主键ID' primary key,
    dept_code    char(32)                             not null comment '科室编码',
    dept_name    varchar(128)                         not null comment '科室名称',
    hospital_no  varchar(32)                          not null comment '医院编码',
    introduction varchar(256)                         null comment '科室简介',
    status       tinyint                              not null comment '状态 0-停用 1-启用',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '科室表' collate = utf8mb4_unicode_ci;

-- 用户表
create table if not exists t_user
(
    id          int auto_increment comment '主键ID' primary key,
    user_id     varchar(32)                          not null comment '用户ID',
    user_nick   varchar(32)                          not null comment '用户昵称',
    account     varchar(11)                          not null comment '用户手机号',
    status      tinyint                              not null comment '状态 0-停用 1-禁用',
    createTime  datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime  datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '用户表' collate = utf8mb4_unicode_ci;

-- 患者表
create table if not exists t_patient_info
(
    id           int auto_increment comment '主键ID' primary key,
    user_id      varchar(32)                          not null comment '用户ID',
    patient_id   varchar(32)                          not null comment '患者ID',
    patient_name varchar(32)                          not null comment '患者姓名',
    cert_no      char(18)                             not null comment '身份证',
    card_no      char(10)                             not null comment '就诊卡',
    mobile       varchar(11)                          not null comment '手机号',
    status       tinyint                              not null comment '状态 0-停用 1-禁用',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '患者表' collate = utf8mb4_unicode_ci;

-- 医生表
create table if not exists t_doctor_info
(
    id           int auto_increment comment '主键ID' primary key,
    hospital_no  char(32)                             not null comment '医院编码',
    dept_code    char(32)                             not null comment '科室编码',
    doctor_code  char(32)                             not null comment '医生编码',
    doctor_name  varchar(128)                         not null comment '医生姓名',
    avatarImg    varchar(128)                         null comment '医生头像',
    title        varchar(32)                          null comment '职称',
    skills       varchar(500)                         null comment '擅长',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '医生表' collate = utf8mb4_unicode_ci;

-- 医生排班表
create table if not exists t_schedule_info
(
    id           int auto_increment comment '主键ID' primary key,
    hospital_no  char(32)                             not null comment '医院编码',
    dept_code    char(32)                             not null comment '科室编码',
    doctor_code  char(32)                             not null comment '医生编码',
    doctor_name  varchar(128)                         not null comment '医生姓名',
    sche_date    date                                 not null comment '排班日期',
    schedule_id  varchar(32)                          not null comment '排班ID',
    register_fee decimal(4, 2)                        not null comment '挂号费',
    surplus      smallint                             not null comment '余号数',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '医生排班表' collate = utf8mb4_unicode_ci;

-- 医生号源表
create table if not exists t_sche_num_info
(
    id           int auto_increment comment '主键ID' primary key,
    hospital_no  char(32)                             not null comment '医院编码',
    dept_code    char(32)                             not null comment '科室编码',
    doctor_code  char(32)                             not null comment '医生编码',
    doctor_name  varchar(128)                          not null comment '医生姓名',
    sche_date    date                                 not null comment '排班日期',
    schedule_id  varchar(32)                          not null comment '排班ID',
    sche_num_id  varchar(32)                          not null comment '号源ID',
    start_time   time                                 not null comment '开始时间',
    end_time     time                                 not null comment '结束时间',
    register_fee decimal(4, 2)                        not null comment '挂号费',
    surplus      smallint                             not null comment '余号数',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '医生号源表' collate = utf8mb4_unicode_ci;

-- 预约记录表
create table if not exists t_register
(
    id              int auto_increment comment '主键ID' primary key,
    user_id         varchar(32)                          not null comment '用户ID',
    patient_id      varchar(32)                          not null comment '患者ID',
    schedule_id     varchar(32)                          not null comment '排班ID',
    booking_time   datetime                              not null comment '预约时间',
    register_fee    decimal(4, 2)                        not null comment '挂号费',
    pay_status      tinyint default 0                    not null comment '支付状态 0-未支付 1-已支付 2-退款',
    status          tinyint                              not null comment '预约状态 0-取消 1-成功',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '预约记录表' collate = utf8mb4_unicode_ci;

-- 订单记录表
create table if not exists t_order
(
    id           int auto_increment comment '主键ID' primary key,
    order_id     varchar(32)                          not null comment '订单ID',
    biz_id       varchar(32)                          not null comment '业务ID',
    order_amt    decimal(4, 2)                        not null comment '订单金额',
    order_status varchar(10)                          not null comment '订单状态',
    order_time   datetime                             null comment '支付时间',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
    ) comment '订单记录表' collate = utf8mb4_unicode_ci;
