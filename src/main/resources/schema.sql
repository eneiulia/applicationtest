DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name VARCHAR(100) UNIQUE NOT NULL,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS account (
    id VARCHAR(45) PRIMARY KEY NOT NULL,
    update_time DATETIME NOT NULL,
    product VARCHAR(100) NOT NULL,
    status VARCHAR(100) NOT NULL,
    type VARCHAR(100) NOT NULL,
    balance FLOAT NOT NULL,
    user_id INT NOT NULL

);

CREATE TABLE IF NOT EXISTS transaction (
    id VARCHAR(45) PRIMARY KEY NOT NULL,
    account_id VARCHAR(45) NOT NULL,
    currency_from VARCHAR(4) NOT NULL,
    currency_to VARCHAR(4) NOT NULL,
    exchange_rate FLOAT NOT NULL,
    original_amount FLOAT NOT NULL,
    creditor_masked_pan VARCHAR(30) NOT NULL,
    creditor_name VARCHAR(30) NOT NULL,
    debtor_masked_pan VARCHAR(30) NOT NULL,
    debtor_name VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL,
    amount FLOAT NOT NULL,
    update_time DATETIME NOT NULL,
    description VARCHAR(100)
);

INSERT INTO user (name, username, password) VALUES
    ('George', 'user_george', '$2a$10$8ye5dKOeM9mb.vlTxtbCheM55gL4otP85K8cxBpFExQsjE54CQPw6'),
    ('Mihai', 'user_mihai', '$2a$10$8ye5dKOeM9mb.vlTxtbCheM55gL4otP85K8cxBpFExQsjE54CQPw6');
