#1.用户表（uses)
create table user(
                     id int(11) primary key AUTO_INCREMENT,	#用户ID
                     user_name varchar(255) NOT NULL,				#用户名
                     password	varchar(255) NOT NULL,				#用户密码
                     name varchar(255) NOT NULL,							#用户姓名
                     gender varchar(255) NOT NULL,						#用户性别
                     birthday date,													#出生日期
                     contact varchar(255) NOT NULL,					#联系方式
                     e_mail varchar(255) NOT NULL						#电子邮箱
);

#2.管理员表（controller）
create table controller(
                           id int(11) primary key AUTO_INCREMENT,	#管理员ID
                           controller_name varchar(255) NOT NULL,	#用户名
                           password	varchar(255) NOT NULL,				#管理员密码
                           name varchar(255) NOT NULL,							#管理员姓名
                           gender varchar(255) NOT NULL,			    			#管理员性别
                           contact varchar(255) NOT NULL						#联系方式
);

#3.收入表（income）
create table income(
                       id int(11) primary key AUTO_INCREMENT,		#收入ID
                       user_id int(11),													#用户ID
                       income_type varchar(255) NOT NULL,				#收入类型
                       income_number decimal(10, 2),							#收入金额
                                            #年份
                       income_date date,												#收入日期
                       FOREIGN KEY(user_id) REFERENCES user(id)	#增加外键
);

#4.支出表（year）
create table year(
                     id int(11) primary key AUTO_INCREMENT,		#支出ID
                     user_id int(11),													#用户ID
                     year_type varchar(255) NOT NULL,					#支出类型
                     year_number decimal(10, 2),								#支出金额

                     year_date date,														#支出日期
                     FOREIGN KEY(user_id) REFERENCES user(id)	#增加外键
);

insert into user(user_name, password, name, gender, birthday, contact, e_mail) values ('zhangsan','123456','张三','男',NOW(),'12345678901','aa@qq.com'),
                                                                                      ('lisi',   '123456','李四','男',now(),'12345678901','bb@qq.com');
insert into year(user_id, year_type, year_number, year_date) values (1,'转账',50,NOW()),(2,'转账',100,NOW());
insert into income(user_id, income_type, income_number , income_date) values (1,'转账',100,NOW()),(2,'转账',100,NOW());

insert into controller(controller_name, password, name, gender, contact) VALUES ('管理员','123456','赵铁柱','男','12345678901');