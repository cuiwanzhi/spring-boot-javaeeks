--#1.用户表（uses)
create table user(
                     id int primary key AUTO_INCREMENT,	#用户ID
                     name varchar(255)  not null,				#用户名
                     password	varchar(255) not null ,				#用户密码
                     gender varchar(2) ,						#用户性别
                     contact varchar(255) ,					#联系方式
                     e_mail varchar(255) ,						#电子邮箱
                     complete int  DEFAULT '0'                 #是否完善用户信息
);

--#1.学生表（student)
create table student(
                     id int primary key AUTO_INCREMENT,	#id
                     name varchar(255) NOT NULL,				#姓名
                     age	int NOT NULL,				#年龄
                     gender varchar(2) NOT NULL,						#性别
                     grade int not null ,                           #年级
                     stu_class int not null ,                       #原班级
                     pickup varchar(255) not null ,                                 #接送情况
                     midday varchar(255) not null ,                                   #午托
                     contact varchar(255) NOT NULL,					#家长联系方式
                     in_date datetime default now(),                                   #数据插入时间
                     user_name varchar(255) not null ,                         #插入人姓名
                     last_update_name varchar(255)   default '无'                        #最后一次修改人

);

