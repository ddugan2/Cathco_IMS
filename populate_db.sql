USE cims;

INSERT INTO employees (employee_id, employee_password, employee_name, employee_role, title) VALUES
	(10001, 'password123', 'George Manager', 3, 'General Manager'),
    (10002, 'password123', 'Irene Supervisor', 2, 'Inventory Specialist'),
    (10003, 'password123', 'Frank Employee', 1, 'Cashier');
    
INSERT INTO items (item_id, item_name, price, cost) VALUES
	(200001, 'Lays Original Snack Bag', 1.99, 0.97),
	(200002, '5 Ream Copy Paper', 7.99, 5.05),
    (200003, 'Chap Stick Original Moisturizer', 0.99, 0.40);
    
SELECT * FROM employees;
SELECT * FROM items;
