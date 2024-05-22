DROP DATABASE IF EXISTS OLLIVANDERS_TEST;

CREATE DATABASE IF NOT EXISTS OLLIVANDERS_TEST;

USE OLLIVANDERS_TEST;

CREATE TABLE T_ITEMS
(
ID INT UNSIGNED AUTO_INCREMENT NOT NULL,
NOMBRE VARCHAR(50) NOT NULL,
QUALITY INT NOT NULL,
SELL_IN INT NOT NULL,
TIPO ENUM("NORMAL","SULFURAS","BACKSTAGE PASS", "AGED BRIE","CONJURED") DEFAULT "NORMAL",
PRIMARY KEY(ID)
) ENGINE MyISAM;

INSERT INTO T_ITEMS
(NOMBRE, QUALITY, SELL_IN, TIPO)
VALUES
("+5 Dexterity Vest", 10, 20,"NORMAL"),
("Aged Brie", 2, 0,"AGED BRIE"),
("Elixir of the Mongoose", 5, 7,"NORMAL"),
("Sulfuras, Hand of Ragnaros", 80, 0,"SULFURAS"),
("Sulfuras, Hand of Ragnaros", 80, -1,"SULFURAS"),
("Backstage passes to a TAFKAL80ETC concert", 20, 15,"BACKSTAGE PASS"),
("Backstage passes to a TAFKAL80ETC concert", 49, 10,"BACKSTAGE PASS"),
("Backstage passes to a TAFKAL80ETC concert", 49, 6,"BACKSTAGE PASS"),
("Conjured Mana Cake", 3, 6,"CONJURED");

SELECT * FROM OLLIVANDERS_TEST.T_ITEMS;