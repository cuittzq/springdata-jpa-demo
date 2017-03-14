# # # # # # # # # # # #
#   此文件请不要整理  #
# # # # # # # # # # # #

# MySql建库语句, 自动生成的可能会造成中文乱码, 请手动执行
# DROP DATABASE IF EXISTS demo;
# CREATE DATABASE IF NOT EXISTS demo DEFAULT CHARACTER SET utf8;

# DROP DATABASE IF EXISTS demo_test;
# CREATE DATABASE IF NOT EXISTS demo_test DEFAULT CHARACTER SET utf8;

#插入部门信息测试数据
INSERT INTO m_dept (dept_name) VALUES ('部门1');
INSERT INTO m_dept (dept_name) VALUES ('部门2');
INSERT INTO m_dept (dept_name) VALUES ('部门3');
INSERT INTO m_dept (dept_name) VALUES ('部门4');
INSERT INTO m_dept (dept_name) VALUES ('部门5');
INSERT INTO m_dept (dept_name) VALUES ('部门6');
INSERT INTO m_dept (dept_name) VALUES ('部门7');
INSERT INTO m_dept (dept_name) VALUES ('部门8');
INSERT INTO m_dept (dept_name) VALUES ('部门9');
INSERT INTO m_dept (dept_name) VALUES ('部门10');
INSERT INTO m_dept (dept_name) VALUES ('部门11');
INSERT INTO m_dept (dept_name) VALUES ('部门12');
INSERT INTO m_dept (dept_name) VALUES ('部门13');
INSERT INTO m_dept (dept_name) VALUES ('部门14');
INSERT INTO m_dept (dept_name) VALUES ('部门15');
INSERT INTO m_dept (dept_name) VALUES ('部门16');
INSERT INTO m_dept (dept_name) VALUES ('部门17');
INSERT INTO m_dept (dept_name) VALUES ('部门18');
INSERT INTO m_dept (dept_name) VALUES ('部门19');
INSERT INTO m_dept (dept_name) VALUES ('部门20');

# 插入职位信息测试数据
INSERT INTO m_employee_level (level_name) VALUES ('职位1');
INSERT INTO m_employee_level (level_name) VALUES ('职位2');
INSERT INTO m_employee_level (level_name) VALUES ('职位3');
INSERT INTO m_employee_level (level_name) VALUES ('职位4');
INSERT INTO m_employee_level (level_name) VALUES ('职位5');
INSERT INTO m_employee_level (level_name) VALUES ('职位6');
INSERT INTO m_employee_level (level_name) VALUES ('职位7');
INSERT INTO m_employee_level (level_name) VALUES ('职位8');
INSERT INTO m_employee_level (level_name) VALUES ('职位9');
INSERT INTO m_employee_level (level_name) VALUES ('职位10');
INSERT INTO m_employee_level (level_name) VALUES ('职位11');
INSERT INTO m_employee_level (level_name) VALUES ('职位12');
INSERT INTO m_employee_level (level_name) VALUES ('职位13');
INSERT INTO m_employee_level (level_name) VALUES ('职位14');
INSERT INTO m_employee_level (level_name) VALUES ('职位15');
INSERT INTO m_employee_level (level_name) VALUES ('职位16');
INSERT INTO m_employee_level (level_name) VALUES ('职位17');
INSERT INTO m_employee_level (level_name) VALUES ('职位18');
INSERT INTO m_employee_level (level_name) VALUES ('职位19');
INSERT INTO m_employee_level (level_name) VALUES ('职位20');

# 插入员工登录详情信息测试数据
INSERT INTO m_employee_detail VALUES (1, 1, '192.168.1.1', '2017-02-16 17"37"36');
INSERT INTO m_employee_detail VALUES (2, 2, '192.168.1.2', '2017-02-16 17"37"36');
INSERT INTO m_employee_detail VALUES (3, 3, '192.168.1.3', '2017-02-16 17"37"36');
INSERT INTO m_employee_detail VALUES (4, 4, '192.168.1.4', '2017-02-16 17"37"36');
INSERT INTO m_employee_detail VALUES (5, 5, '192.168.1.5', '2017-02-16 17"37"36');
INSERT INTO m_employee_detail VALUES (6, 6, '192.168.1.6', '2017-02-16 17"37"36');
INSERT INTO m_employee_detail VALUES (7, 7, '192.168.1.7', '2017-02-16 17"37"36');
INSERT INTO m_employee_detail VALUES (8, 8, '192.168.1.8', '2017-02-16 17"37"36');
INSERT INTO m_employee_detail VALUES (9, 9, '192.168.1.9', '2017-02-16 17"37"36');
INSERT INTO m_employee_detail VALUES (10, 10, '192.168.1.10', '2017-02-16 17"37"36');

# 插入员工测试数据
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-01', 1, 1, '2016-01-01', 1, '141000199001011001', '员工1', '123456', '13579246811', FALSE, NULL, 'user1');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-02', 1, 1, '2016-01-02', 1, '141000199001011002', '员工2', '123456', '13579246812', FALSE, NULL, 'user2');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-03', 1, 1, '2016-01-03', 1, '141000199001011003', '员工3', '123456', '13579246813', FALSE, NULL, 'user3');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-04', 1, 1, '2016-01-04', 1, '141000199001011004', '员工4', '123456', '13579246814', FALSE, NULL, 'user4');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-05', 1, 1, '2016-01-05', 1, '141000199001011005', '员工5', '123456', '13579246815', FALSE, NULL, 'user5');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-06', 1, 1, '2016-01-06', 1, '141000199001011006', '员工6', '123456', '13579246816', FALSE, NULL, 'user6');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-07', 1, 1, '2016-01-07', 1, '141000199001011007', '员工7', '123456', '13579246817', FALSE, NULL, 'user7');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-08', 1, 1, '2016-01-08', 1, '141000199001011008', '员工8', '123456', '13579246818', FALSE, NULL, 'user8');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-09', 1, 1, '2016-01-09', 1, '141000199001011009', '员工9', '123456', '13579246819', FALSE, NULL, 'user9');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-10', 1, 1, '2016-01-10', 1, '141000199001011010', '员工10', '123456', '13579246820', TRUE, NULL, 'user10');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-11', 1, 1, '2016-01-11', 1, '141000199001011011', '员工11', '123456', '13579246821', TRUE, NULL, 'user11');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-12', 1, 1, '2016-01-12', 1, '141000199001011012', '员工12', '123456', '13579246822', TRUE, NULL, 'user12');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-13', 1, 1, '2016-01-13', 1, '141000199001011013', '员工13', '123456', '13579246823', TRUE, NULL, 'user13');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-14', 1, 1, '2016-01-14', 1, '141000199001011014', '员工14', '123456', '13579246824', TRUE, NULL, 'user14');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-15', 1, 1, '2016-01-15', 1, '141000199001011015', '员工15', '123456', '13579246825', TRUE, NULL, 'user15');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-16', 1, 1, '2016-01-16', 1, '141000199001011016', '员工16', '123456', '13579246826', TRUE, NULL, 'user16');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-17', 1, 1, '2016-01-17', 1, '141000199001011017', '员工17', '123456', '13579246827', TRUE, NULL, 'user17');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-18', 1, 1, '2016-01-18', 1, '141000199001011018', '员工18', '123456', '13579246828', TRUE, NULL, 'user18');
insert into m_employee (emp_address, emp_birthday, dept_id, level_id, emp_entry_date, emp_gender, emp_identity, emp_name, emp_password, emp_phone, emp_status, emp_turnover_date, emp_username) values ('北京', '1990-01-19', 1, 1, '2016-01-19', 1, '141000199001011019', '员工19', '123456', '13579246829', TRUE, NULL, 'user19');