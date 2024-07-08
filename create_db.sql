DROP DATABASE IF EXISTS cims;

CREATE DATABASE IF NOT EXISTS cims;

USE cims;

DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees 
(
		employee_id	INT	PRIMARY KEY,
        employee_password	VARCHAR(20)	NOT NULL,
        employee_name	VARCHAR(25)	NOT NULL,
        employee_role	ENUM('generic', 'inventory', 'manager')	NOT NULL,
        title	VARCHAR(30)	NOT NULL,
        is_removed	BIT	NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS items;

CREATE TABLE IF NOT EXISTS items
(
	item_id	INT	PRIMARY KEY,
    item_name	VARCHAR(50)	NOT NULL,
    price	DECIMAL(6,2)	NOT NULL,
    cost	DECIMAL(6,2)	NOT NULL,
    quantity	INT	NOT NULL	DEFAULT 0,
    is_removed BIT NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS transactions;

CREATE TABLE IF NOT EXISTS transactions
(
	item_id	INT NOT NULL,
    employee_id	INT NOT NULL,
    transaction_timestamp	TIMESTAMP NOT NULL DEFAULT NOW(),
    adjustment_amount	INT	NOT NULL,
    reason	VARCHAR(30)	NOT NULL,
    cost	DECIMAL(6,2)	NOT NULL,
    CONSTRAINT transactions_fk_items
		FOREIGN KEY (item_id)
        REFERENCES items (item_id),
	CONSTRAINT transactions_fk_employees
		FOREIGN KEY (employee_id)
        REFERENCES employees (employee_id)
);
