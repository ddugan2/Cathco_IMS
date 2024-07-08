USE cims;

DELETE FROM employees WHERE employee_id > 0;
DELETE FROM items WHERE item_id > 0;
DELETE FROM transactions WHERE item_id > 0;
