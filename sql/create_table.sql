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


INSERT INTO t_org_info (hospital_no, hospital_name, introduction, address, logo, status, app_id)
VALUES
    ('H001', '北京协和医院', '北京协和医院是中国历史最悠久的医院之一', '北京市东城区', 'logo_001.png', 1, 'appid_001'),
    ('H002', '上海华东医院', '上海华东医院是上海市知名医院', '上海市浦东新区', 'logo_002.png', 1, 'appid_002'),
    ('H003', '广州中山医院', '中山医院是广州的三级甲等医院', '广州市海珠区', 'logo_003.png', 1, 'appid_003'),
    ('H004', '深圳人民医院', '深圳市人民医院是综合性医院', '深圳市福田区', 'logo_004.png', 1, 'appid_004'),
    ('H005', '南京鼓楼医院', '南京鼓楼医院是江苏省内顶尖医院之一', '南京市鼓楼区', 'logo_005.png', 1, 'appid_005');
INSERT INTO t_dept_info (hospital_no, dept_code, dept_name, parent_dept_code, status, address)
VALUES
    ('H001', 'D001', '内科', NULL, 1, '北京市东城区内科'),
    ('H001', 'D002', '外科', NULL, 1, '北京市东城区外科'),
    ('H002', 'D003', '皮肤科', NULL, 1, '上海市浦东新区皮肤科'),
    ('H003', 'D004', '眼科', NULL, 1, '广州市海珠区眼科'),
    ('H004', 'D005', '牙科', NULL, 1, '深圳市福田区牙科');
INSERT INTO t_user (user_id, user_nick, account, hospital_no, status)
VALUES
    ('U001', '张三', '13800000001', 'H001', 1),
    ('U002', '李四', '13800000002', 'H002', 1),
    ('U003', '王五', '13800000003', 'H003', 1),
    ('U004', '赵六', '13800000004', 'H004', 1),
    ('U005', '钱七', '13800000005', 'H005', 1);
INSERT INTO t_patient_info (user_id, patient_id, patient_name, cert_no, patient_no, mobile, sex, age, status)
VALUES
    ('U001', 'P001', '张伟', '110101199001010001', 'P001', '13800000001', 'M', 30, 1),
    ('U002', 'P002', '李娜', '110101199202020002', 'P002', '13800000002', 'F', 28, 1),
    ('U003', 'P003', '王小明', '110101199303030003', 'P003', '13800000003', 'M', 25, 1),
    ('U004', 'P004', '赵雪', '110101199404040004', 'P004', '13800000004', 'F', 35, 1),
    ('U005', 'P005', '钱红', '110101199505050005', 'P005', '13800000005', 'F', 40, 1);
INSERT INTO t_doctor_info (hospital_no, dept_code, doctor_code, doctor_name, title, skills)
VALUES
    ('H001', 'D001', 'DC001', '李医生', '主任医师', '擅长治疗高血压，糖尿病'),
    ('H001', 'D002', 'DC002', '王医生', '副主任医师', '擅长胃肠疾病的诊治'),
    ('H002', 'D003', 'DC003', '张医生', '主治医师', '擅长皮肤病，过敏性疾病'),
    ('H003', 'D004', 'DC004', '李医生', '副主任医师', '擅长眼科疾病的治疗'),
    ('H004', 'D005', 'DC005', '刘医生', '主治医师', '擅长口腔疾病治疗');
INSERT INTO t_schedule_info (hospital_no, dept_code, doctor_code, doctor_name, sche_date, schedule_id, register_fee, surplus)
VALUES
    ('H001', 'D001', 'DC001', '李医生', '2025-01-01', 'S001', 50.00, 5),
    ('H001', 'D002', 'DC002', '王医生', '2025-01-02', 'S002', 60.00, 10),
    ('H002', 'D003', 'DC003', '张医生', '2025-01-03', 'S003', 40.00, 3),
    ('H003', 'D004', 'DC004', '李医生', '2025-01-04', 'S004', 70.00, 7),
    ('H004', 'D005', 'DC005', '刘医生', '2025-01-05', 'S005', 80.00, 8);
INSERT INTO t_sche_num_info (hospital_no, dept_code, doctor_code, doctor_name, sche_date, schedule_id, sche_num_id, start_time, end_time, register_fee, surplus)
VALUES
    ('H001', 'D001', 'DC001', '李医生', '2025-01-01', 'S001', 'SN001', '08:00', '09:00', 50.00, 5),
    ('H001', 'D002', 'DC002', '王医生', '2025-01-02', 'S002', 'SN002', '09:00', '10:00', 60.00, 10),
    ('H002', 'D003', 'DC003', '张医生', '2025-01-03', 'S003', 'SN003', '10:00', '11:00', 40.00, 3),
    ('H003', 'D004', 'DC004', '李医生', '2025-01-04', 'S004', 'SN004', '11:00', '12:00', 70.00, 7),
    ('H004', 'D005', 'DC005', '刘医生', '2025-01-05', 'S005', 'SN005', '14:00', '15:00', 80.00, 8);
INSERT INTO t_register (hospital_no, hospital_name, dept_code, dept_name, doctor_code, doctor_name, user_id, patient_id, patient_no, patient_name, register_id, schedule_id, sche_num_id, sche_date, start_time, end_time, register_fee, order_id, register_status)
VALUES
    ('H001', '北京协和医院', 'D001', '内科', 'DC001', '李医生', 'U001', 'P001', 'P001', '张伟', 'R001', 'S001', 'SN001', '2025-01-01', '08:00', '09:00', 50.00, 'ORD001', 'WAIT_PAY'),
    ('H001', '北京协和医院', 'D002', '外科', 'DC002', '王医生', 'U002', 'P002', 'P002', '李娜', 'R002', 'S002', 'SN002', '2025-01-02', '09:00', '10:00', 60.00, 'ORD002', 'SUCCEED'),
    ('H002', '上海华东医院', 'D003', '皮肤科', 'DC003', '张医生', 'U003', 'P003', 'P003', '王小明', 'R003', 'S003', 'SN003', '2025-01-03', '10:00', '11:00', 40.00, 'ORD003', 'WAIT_PAY'),
    ('H003', '广州中山医院', 'D004', '眼科', 'DC004', '李医生', 'U004', 'P004', 'P004', '赵雪', 'R004', 'S004', 'SN004', '2025-01-04', '11:00', '12:00', 70.00, 'ORD004', 'SUCCEED'),
    ('H004', '深圳人民医院', 'D005', '牙科', 'DC005', '刘医生', 'U005', 'P005', 'P005', '钱红', 'R005', 'S005', 'SN005', '2025-01-05', '14:00', '15:00', 80.00, 'ORD005', 'WAIT_PAY');
INSERT INTO t_order (order_id, biz_id, order_amt, order_status, pay_type, order_time)
VALUES
    ('ORD001', 'BIZ001', 50.00, 'WAIT_PAY', 'WX', '2025-01-01 08:00:00'),
    ('ORD002', 'BIZ002', 60.00, 'PAID', 'INSUR', '2025-01-02 09:00:00'),
    ('ORD003', 'BIZ003', 40.00, 'WAIT_PAY', 'WX', '2025-01-03 10:00:00'),
    ('ORD004', 'BIZ004', 70.00, 'PAID', 'INSUR', '2025-01-04 11:00:00'),
    ('ORD005', 'BIZ005', 80.00, 'WAIT_PAY', 'WX', '2025-01-05 14:00:00');


