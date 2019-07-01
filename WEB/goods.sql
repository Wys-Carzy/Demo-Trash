CREATE TABLE Goods( 
Id VARCHAR(20) NOT NULL ,
Name VARCHAR(50) NOT NULL ,
Number int NOT NULL ,
describe VARCHAR(999) NOT NULL,
img VARCHAR(999) NULL
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `goods`  (
  `Id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Number` int(11) NULL DEFAULT NULL,
  `describe` varchar(50) NOT NULL,
  `img` varchar(50) NULL
);


INSERT INTO Goods VALUES ('Apple', 'iPhone5S', '4599', '装逼利器，值得拥有', './img/picture/iPhone5S.jpg');

INSERT INTO Goods  VALUES ('Samsung', 'Samsung Note3', '3999', '三星唯一旗舰，S系列都去死吧', './img/picture/Note3.jpg');

INSERT INTO Goods  VALUES ('iPad', 'iPad Air', '3599', '放大版iPhone，除了没有通话功能', './img/picture/iPad.jpg');

INSERT INTO Goods  VALUES ('iMac', 'MacBook Pro', '14999','买来装Windows，闲的蛋疼','./img/picture/MacBook.jpg');

INSERT INTO Goods  VALUES ('Dell', 'Alienware 18', '35999','强悍的配置，流弊的厚度','./img/picture/alienware18.jpg');

INSERT INTO Goods  VALUES ('Xiaomi', 'Xiaomi MI3', '1999','移动版第二核弹，质量最差', './img/picture/mi3.jpg');

INSERT INTO Goods  VALUES ('MeiZu', 'MeiZu MX3', '1799','宁死不用高通，老大最流弊', './img/picture/MX3.jpg');

INSERT INTO Goods  VALUES ('HTC', 'HTC The New One', '5299','最长下吧，谁与争锋', './img/picture/M8.png');

INSERT INTO Goods  VALUES ('Sony', 'Sony Xperia Z2', '3999','散热铜管，厉不厉害', './img/picture/Z2.jpg');

INSERT INTO Goods  VALUES ('Nokia', 'Lmia1520', '2500','系统是WP，无其他槽点', './img/picture/1520.jpg');

INSERT INTO Goods  VALUES ('MiPad', 'MiPad', '1699','最强核弹，看谁不爽炸谁', './img/picture/mipad.jpg');

INSERT INTO Goods  VALUES ('MiTV', 'MiTV', '3999','真4K假4K，傻傻分不清楚', './img/picture/mitv.jpg');

CREATE TABLE Shopping (
ID varchar(50) NOT NULL ,
`NAME` varchar(50) NOT NULL ,
USERNAME varchar(50) NOT NULL ,
Number int NOT NULL ,
MONEY int NOT NULL ,
IMG VARCHAR(50) NOT NULL 
);

CREATE TABLE indent(
Id VARCHAR(20) NOT NULL ,
Name VARCHAR(50) NOT NULL,
Username VARCHAR(50) NOT NULL,
Number int NOT NULL ,
money int not NULL,
img VARCHAR(999) NULL
);

CREATE TABLE collect (
ID VARCHAR(50) NOT NULL ,
NAME VARCHAR(50) NOT NULL ,
USERNAME VARCHAR(50) NOT NULL ,
MONEY int NOT NULL ,
IMG VARCHAR(50) NOT NULL 
);

INSERT INTO Users (Name, Password) VALUES ('admin', '123');

INSERT INTO Users (Name, Password) VALUES ('jack', '123');

ALTER TABLE Users ADD PRIMARY KEY (Name);