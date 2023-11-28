CREATE TABLE IF NOT EXISTS category(
cate_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
content VARCHAR(100) NOT NULL,
is_drop CHAR(1) DEFAULT 0,
is_show CHAR(1) DEFAULT 1
);

INSERT INTO category VALUES(1, '내용', '0', '1');




CREATE TABLE board(
board_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
is_notice CHAR(1) DEFAULT 0,
title VARCHAR(255) NOT NULL,
content_normal TEXT NOT NULL,
content_html TEXT NOT NULL,
is_secret CHAR(1) DEFAULT 0,
board_type VARCHAR(100),
writer VARCHAR(255) NOT NULL,
create_at DATETIME NOT NULL,
modifyer VARCHAR(255),
modify_at DATETIME,
cate_id BIGINT NOT NULL,
member_id BIGINT NOT NULL,

CONSTRAINT FK_category_board FOREIGN KEY (cate_id) REFERENCES category(cate_id),
CONSTRAINT FK_member_board FOREIGN KEY (member_id) REFERENCES member(member_id)
)

INSERT INTO board(board_id, is_notice, title, content_normal, content_html, is_secret, board_type, writer, create_at, cate_id, member_id) 
VALUES(1, '0', '타이틀', '내용', '<div>내용</div>', '0', '종류', 'member1', NOW(), 1, 1);




CREATE TABLE attach_file(
fileIdx INT PRIMARY KEY,
fileName VARCHAR(255) NOT NULL,
fileSize INT NOT NULL,
orgFileName VARCHAR(255) NOT NULL,
regDate DATETIME NOT NULL,
modifyDate DATETIME,
downCnt INT DEFAULT 0,
boardIdx INT NOT NULL
);



CREATE TABLE level_role_set(
level_idx INT,
role INT
);


CREATE TABLE member(
member_id INT PRIMARY KEY,
email VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
name VARCHAR(100) NOT NULL,
phone_num VARCHAR(100) NOT NULL,
reg_date DATETIME NOT NULL,
modify_date DATETIME NOT NULL,
ip INT NOT NULL,
level_idx INT NOT NULL,
unique (email)
);


INSERT INTO member(member_id, email, ip, name, password, phone_num, reg_date) 
VALUES(1, 'member1', '192.168.0.0', '사용자이름', '1234', '01012341234', NOW())


CREATE TABLE log(
log_id BIGINT PRIMARY KEY AUTO_INCREMENT,
content VARCHAR(255) NOT NULL,
ip VARCHAR(100) NOT NULL,
user_email VARCHAR(255) NOT NULL,
create_at DATETIME NOT NULL,
modify_at DATETIME
)


