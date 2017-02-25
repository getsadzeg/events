CREATE TABLE "USER"(
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(30) NOT NULL
    
);

ALTER TABLE "USER" ADD card_id INT REFERENCES CARD(id);

CREATE TABLE EVENT (
    id INT PRIMARY KEY NOT NULL,
    Description text,
    Date date NOT NULL,
    price decimal NOT NULL,
    category VARCHAR(30) NOT NULL,
    places INT NOT NULL,
    type VARCHAR(30) NOT NULL,
    author_id INT REFERENCES "USER"(id)
);

CREATE TABLE TICKET(
    id INT PRIMARY KEY NOT NULL,
    event_id INT REFERENCES EVENT(id)
);

CREATE TABLE CARD (
    id INT PRIMARY KEY NOT NULL,
    money decimal NOT NULL,
    cardCode VARCHAR(30) NOT NULL,
    passCode VARCHAR(30) NOT NULL,
    expirationDate date NOT NULL
    );

INSERT INTO CARD(id, money, cardCode, passCode, expirationDate) VALUES(1, 10, 112222, 111, '2017-08-31');
INSERT INTO CARD(id, money, cardCode, passCode, expirationDate) VALUES(2, 30, 123456, 222, '2017-09-29');
INSERT INTO CARD(id, money, cardCode, passCode, expirationDate) VALUES(3, 50, 333444, 333, '2018-02-02');
INSERT INTO CARD(id, money, cardCode, passCode, expirationDate) VALUES(4, 100, 444555, 444, '2018-03-21');

CREATE TABLE TICKET_HISTORY(
    user_id INT REFERENCES "USER"(id),
    ticket_id INT REFERENCES TICKET(id)
);

ALTER TABLE TICKET_HISTORY ADD status text;