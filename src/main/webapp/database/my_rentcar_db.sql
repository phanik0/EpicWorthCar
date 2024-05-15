CREATE DATABASE my_rentcar_db;

USE my_rentcar_db;

CREATE TABLE users (
    id VARCHAR(20) PRIMARY KEY NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(40) NOT NULL,
    resident_number CHAR(14) NOT NULL UNIQUE CHECK (resident_number REGEXP '^[0-9]{6}-[0-9]{7}$') ,
    phone CHAR(13) UNIQUE NOT NULL CHECK (phone REGEXP '^[0-9]{3}-[0-9]{4}-[0-9]{4}$'),
    email VARCHAR(100) ,
    reg_date DATETIME  NOT NULL DEFAULT NOW(),
    update_date DATETIME,
    address VARCHAR(200),
    admin TINYINT DEFAULT(false)
);
ALTER TABLE users MODIFY COLUMN  email VARCHAR(100);
ALTER TABLE users MODIFY COLUMN  resident_number CHAR(14) NOT NULL UNIQUE CHECK (resident_number REGEXP '^[0-9]{6}-[0-9]{7}$');
CREATE TABLE book_info(
user_id VARCHAR(20) NOT NULL,
car_code INTEGER NOT NULL,
book_date DATE NOT NULL,
end_date DATE NOT NULL,
start_date DATE NOT NULL ,
PRIMARY KEY(user_id,start_date,end_date),
FOREIGN KEY(user_id) REFERENCES users(id),
FOREIGN KEY(car_code) REFERENCES cars(code)
);
CREATE TABLE cars (
    code INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
      license_number VARCHAR(20) NOT NULL,
    name VARCHAR(40) NOT NULL,
     brand_code INTEGER NOT NULL,
    model VARCHAR(20) ,
    type VARCHAR(20) ,
    color VARCHAR(20),
    engine VARCHAR(20),
    rental_fee INTEGER NOT NULL,
    booked_dates JSON DEFAULT NULL
)AUTO_INCREMENT = 1000;


CREATE TABLE categories (
    code INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40)
)AUTO_INCREMENT = 1000;


CREATE TABLE board (
    title VARCHAR(40) NOT NULL,
    body VARCHAR(500) NOT NULL,
    number INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id VARCHAR(20) NOT NULL,
    write_date DATETIME DEFAULT NOW(),
    update_date DATETIME ,
    FOREIGN KEY (id) REFERENCES users(id) 
)AUTO_INCREMENT = 1;
CREATE TABLE notice (
    title VARCHAR(40) NOT NULL,
    body VARCHAR(500) NOT NULL,
    id VARCHAR(20)NOT NULL,
    admin TINYINT NOT NULL,
    number INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    write_date DATETIME DEFAULT NOW() NOT NULL,
    update_date DATETIME,
    FOREIGN KEY (id) REFERENCES users(id) 
)AUTO_INCREMENT = 1;
-- 더미 데이터 삽입
INSERT INTO categories(name) VALUES('현대');
INSERT INTO categories(name) VALUES('기아');
INSERT INTO categories(name) VALUES('페라리');
INSERT INTO categories(name) VALUES('람보르기니');
INSERT INTO categories(name) VALUES('아우디');
INSERT INTO categories(name) VALUES('BMW');
INSERT INTO categories(name) VALUES('벤츠');
INSERT INTO board (title, body, id)
VALUES
    ('첫 번째 게시물', '첫 번째 게시물 내용입니다.', 'asdf'),
    ('두 번째 게시물', '두 번째 게시물 내용입니다.', 'asdf'),
    ('세 번째 게시물', '세 번째 게시물 내용입니다.', 'asdf'),
   ('첫 번째 게시물', '첫 번째 게시물 내용입니다.', 'asdf'),
   ('첫 번째 게시물', '첫 번째 게시물 내용입니다.', 'asdf'),
   ('첫 번째 게시물', '첫 번째 게시물 내용입니다.', 'asdf'),
   ('첫 번째 게시물', '첫 번째 게시물 내용입니다.', 'asdf'),
    ('열 번째 게시물', '열 번째 게시물 내용입니다.', 'asdf');
INSERT INTO cars (license_number, name, brand_code, model, type, color, engine, rental_fee)
VALUES
    ('10하1234', '아반떼SD', 1000, 'Avante SD', '소형', '그레이', '가솔린', 50),
    ('11하5678', '쏘나타', 1000, 'Sonata', '중형', '화이트', '디젤', 60),
    ('12하9876', 'K5', 1001, 'K5', '중형', '블랙', '가솔린', 55),
    ('13하5432', '스포티지', 1001, 'Sportage', 'SUV', '실버', '디젤', 65),
    ('14하2109', '페라리 488', 1002, '488', '스포츠카', '레드', '가솔린', 500),
    ('15하7777', '아우디 A6', 1004, 'A6', '중형', '블루', '디젤', 70),
    ('16하3333', 'BMW 320i', 1005, '320i', '중형', '블랙', '가솔린', 75),
    ('17하9999', '벤츠 E-Class', 1006, 'E-Class', '중형', '실버', '디젤', 80),
    ('18하4567', '람보르기니 우루스', 1003, 'Urus', 'SUV', '옐로우', '가솔린', 300),
    ('19하6543', '기아 K3', 1001, 'K3', '소형', '화이트', '가솔린', 45),
    ('20하8888', '현대 그랜저', 1000, 'Grandeur', '대형', '블랙', '디젤', 90),
    ('21하1111', '포터', 1000, 'Porter', '소형', '화이트', '디젤', 40),
    ('22하2222', '레이', 1000, 'Ray', '소형', '블루', '가솔린', 35),
    ('23하3333', 'K7', 1001, 'K7', '대형', '실버', '디젤', 80),
    ('24하4444', '벨로스터', 1000, 'Veloster', '컴팩트', '레드', '가솔린', 50),
    ('25하5555', '페라리 F8', 1002, 'F8', '스포츠카', '옐로우', '가솔린', 550),
    ('26하6666', '아우디 Q5', 1004, 'Q5', 'SUV', '블랙', '디젤', 75),
    ('27하7777', 'BMW X3', 1005, 'X3', 'SUV', '화이트', '가솔린', 70),
    ('28하8888', '벤츠 S-Class', 1006, 'S-Class', '대형', '블랙', '디젤', 100),
    ('29하9999', '람보르기니 아벤타도르', 1003, 'Aventador', '스포츠카','노랑','가솔린',100);
    
 CREATE USER `web_ops`@`localhost` IDENTIFIED BY 'gyDzK0vb5W2';
GRANT SELECT, DELETE, UPDATE, INSERT ON `my_rentcar_db`.* TO `web_ops`@`localhost`;
