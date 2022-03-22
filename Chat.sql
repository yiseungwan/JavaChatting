/*
관리자 아이디 :supervisor
비밀 번호 :1111
데이터베이스명: chat
테이블명 :ch_member
*/

/*관리자 계정 생성*/
CREATE USER 'supervisor'@'localhost' identified BY '1111';

/*관리자 권한 부여->테이블 모든권한 부여*/
GRANT ALL PRIVILEGES ON *.* TO 'supervisor'@'localhost';

/*관리자 권한 확인*/
SELECT*FROM mysql.user;

/*데이터베이스 생성->chat*/
CREATE DATABASE chat;

/*use데이터베이스 선택*/
USE chat;

/*테이블 생성->ch_member*/
/*칼럼 역할->회원가입정보*/
/*no - 유저 고유번호*/
/*regdate - 회원가입 날짜*/
/*unique - 중복제약조건*/
CREATE TABLE ch_member(
	NO			INT 				NOT NULL	AUTO_INCREMENT,
	userid	VARCHAR(30)		NOT NULL,
	username	VARCHAR(30)		NOT NULL,
	userpw	INT				NOT NULL,
	regdate	TIMESTAMP		DEFAULT NOW(),
	PRIMARY KEY(NO),
	UNIQUE (userid)
	);
	
/*테이블 확인*/
SELECT * FROM ch_member;

/*테이블데이터 삭제(모두)*/
DELETE FROM ch_member;

/*테이블 삭제*/
DROP TABLE ch_member;

/*더미 데이터 삽입*/
INSERT INTO ch_member(userid,username, userpw)
	VALUES('AAA','최정규',1234);
	
INSERT INTO ch_member(userid,username, userpw)
	VALUES('BBB','김동혁',1234);
	
INSERT INTO ch_member(userid,username, userpw)
	VALUES('CCC','이승완',1234);
	
INSERT INTO ch_member(userid,username, userpw)
	VALUES('DDD','심명관',1234);
	

/*테이블 특정데이터 삭제*/
DELETE FROM ch_member
	WHERE NO=1;
	
/*no회원 고유번호 초기화*/
ALTER TABLE ch_member AUTO_INCREMENT = 1;

/*작업 완료 명령*/
COMMIT;