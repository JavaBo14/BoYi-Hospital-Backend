-- 创建库
create database if not exists jd_registration;

-- 切换库
use jd_registration;

-- 机构表
CREATE TABLE IF NOT EXISTS t_org_info
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    hospital_no   VARCHAR(32)                         NOT NULL COMMENT '医院编码',
    hospital_name VARCHAR(128)                        NOT NULL COMMENT '医院名称',
    introduction  VARCHAR(256) COMMENT '医院简介',
    address       VARCHAR(128) COMMENT '医院地址',
    logo          VARCHAR(128) COMMENT '医院logo',
    status        INT(1)                              NOT NULL COMMENT '状态 0-停用 1-启用',
    app_id        VARCHAR(32)                         NOT NULL COMMENT '小程序APPID',
    create_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '机构表' COLLATE = utf8mb4_unicode_ci;


-- 科室表
CREATE TABLE IF NOT EXISTS t_dept_info
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    hospital_no      VARCHAR(32)                         NOT NULL COMMENT '医院编码',
    dept_code        VARCHAR(32)                         NOT NULL COMMENT '科室编码',
    dept_name        VARCHAR(128)                        NOT NULL COMMENT '科室名称',
    parent_dept_code VARCHAR(32) COMMENT '父级科室编码',
    logo             VARCHAR(128) COMMENT '科室图片',
    introduction     VARCHAR(256) COMMENT '科室简介',
    address          VARCHAR(128) COMMENT '科室地址',
    status           INT(1)                              NOT NULL COMMENT '状态 0-停用 1-启用',
    create_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '科室表' COLLATE = utf8mb4_unicode_ci;


-- 用户表
CREATE TABLE IF NOT EXISTS t_user
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    user_id     VARCHAR(32)                         NOT NULL COMMENT '用户ID',
    user_nick   VARCHAR(32)                         NOT NULL COMMENT '用户昵称',
    account     VARCHAR(11)                         NOT NULL COMMENT '用户手机号',
    hospital_no VARCHAR(32)                         NOT NULL COMMENT '机构编码',
    status      INT(1)                              NOT NULL COMMENT '状态 0-停用 1-禁用',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '用户表' COLLATE = utf8mb4_unicode_ci;


-- 患者表
CREATE TABLE IF NOT EXISTS t_patient_info
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    user_id      VARCHAR(32)                         NOT NULL COMMENT '用户ID',
    patient_id   VARCHAR(32)                         NOT NULL COMMENT '患者ID',
    patient_name VARCHAR(32)                         NOT NULL COMMENT '患者姓名',
    cert_no      VARCHAR(18)                         NOT NULL COMMENT '身份证',
    patient_no   VARCHAR(10)                         NOT NULL COMMENT '患者号',
    mobile       VARCHAR(11)                         NOT NULL COMMENT '手机号',
    sex          CHAR(1)                             NOT NULL COMMENT '性别，M-男 F-女',
    age          INT COMMENT '年龄',
    status       INT(1)                              NOT NULL COMMENT '状态 0-停用 1-禁用',
    create_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '患者表' COLLATE = utf8mb4_unicode_ci;


-- 医生表
CREATE TABLE IF NOT EXISTS t_doctor_info
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    hospital_no VARCHAR(32)                         NOT NULL COMMENT '医院编码',
    dept_code   VARCHAR(32)                         NOT NULL COMMENT '科室编码',
    doctor_code VARCHAR(32)                         NOT NULL COMMENT '医生编码',
    doctor_name VARCHAR(128)                        NOT NULL COMMENT '医生姓名',
    avatar_img  VARCHAR(128) COMMENT '医生头像',
    title       VARCHAR(32) COMMENT '职称',
    skills      VARCHAR(500) COMMENT '擅长',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '医生表' COLLATE = utf8mb4_unicode_ci;


-- 医生排班表
CREATE TABLE IF NOT EXISTS t_schedule_info
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    hospital_no  VARCHAR(32)                         NOT NULL COMMENT '医院编码',
    dept_code    VARCHAR(32)                         NOT NULL COMMENT '科室编码',
    doctor_code  VARCHAR(32)                         NOT NULL COMMENT '医生编码',
    doctor_name  VARCHAR(128)                        NOT NULL COMMENT '医生姓名',
    sche_date    DATE                                NOT NULL COMMENT '排班日期',
    schedule_id  VARCHAR(32)                         NOT NULL COMMENT '排班ID',
    register_fee DECIMAL(4, 2)                       NOT NULL COMMENT '挂号费',
    surplus      INT(2)                              NOT NULL COMMENT '余号数',
    create_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '医生排班表' COLLATE = utf8mb4_unicode_ci;


-- 医生号源表
CREATE TABLE IF NOT EXISTS t_sche_num_info
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    hospital_no  VARCHAR(32)                         NOT NULL COMMENT '医院编码',
    dept_code    VARCHAR(32)                         NOT NULL COMMENT '科室编码',
    doctor_code  VARCHAR(32)                         NOT NULL COMMENT '医生编码',
    doctor_name  VARCHAR(128)                        NOT NULL COMMENT '医生姓名',
    sche_date    DATE                                NOT NULL COMMENT '排班日期',
    schedule_id  VARCHAR(32)                         NOT NULL COMMENT '排班ID',
    sche_num_id  VARCHAR(32)                         NOT NULL COMMENT '号源ID',
    start_time   TIME                                NOT NULL COMMENT '开始时间',
    end_time     TIME                                NOT NULL COMMENT '结束时间',
    register_fee DECIMAL(4, 2)                       NOT NULL COMMENT '挂号费',
    surplus      INT(2)                              NOT NULL COMMENT '余号数',
    create_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '医生号源表' COLLATE = utf8mb4_unicode_ci;


-- 预约记录表
CREATE TABLE IF NOT EXISTS t_register
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    hospital_no     VARCHAR(32)                         NOT NULL COMMENT '医院编码',
    hospital_name   VARCHAR(128) COMMENT '医院名称',
    dept_code       VARCHAR(32)                         NOT NULL COMMENT '科室编码',
    dept_name       VARCHAR(128)                        NOT NULL COMMENT '科室名称',
    doctor_code     VARCHAR(32)                         NOT NULL COMMENT '医生编码',
    doctor_name     VARCHAR(128)                        NOT NULL COMMENT '医生姓名',
    user_id         VARCHAR(32)                         NOT NULL COMMENT '用户ID',
    patient_id      VARCHAR(32)                         NOT NULL COMMENT '患者ID',
    patient_no      VARCHAR(10)                         NOT NULL COMMENT '患者号',
    patient_name    VARCHAR(128)                        NOT NULL COMMENT '患者姓名',
    register_id     VARCHAR(32)                         NOT NULL COMMENT '挂号ID',
    schedule_id     VARCHAR(32)                         NOT NULL COMMENT '排班ID',
    sche_num_id     VARCHAR(32)                         NOT NULL COMMENT '号源ID',
    sche_date       VARCHAR(10)                         NOT NULL COMMENT '预约日期',
    start_time      TIME                                NOT NULL COMMENT '开始时间',
    end_time        TIME                                NOT NULL COMMENT '结束时间',
    register_fee    DECIMAL(4, 2)                       NOT NULL COMMENT '挂号费',
    order_id        VARCHAR(32)                         NOT NULL COMMENT '支付订单号',
    register_status VARCHAR(10)                         NOT NULL COMMENT '挂号状态  WAIT_PAY-待支付, SUCCEED-预约成功',
    create_time     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '预约记录表' COLLATE = utf8mb4_unicode_ci;


-- 订单记录表
CREATE TABLE IF NOT EXISTS t_order
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    order_id     VARCHAR(32)                         NOT NULL COMMENT '订单ID',
    biz_id       VARCHAR(32)                         NOT NULL COMMENT '业务ID',
    order_amt    DECIMAL(4, 2)                       NOT NULL COMMENT '订单金额',
    order_status VARCHAR(10)                         NOT NULL COMMENT '订单状态 WAIT_PAY-待支付, PA',
    pay_type     varchar(5)                          NOT NULL COMMENT '支付方式 WX-微信 INSUR-医保',
    order_time   TIMESTAMP                           NOT NULL COMMENT '支付时间',
    create_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)COMMENT '订单记录表' COLLATE = utf8mb4_unicode_ci;


