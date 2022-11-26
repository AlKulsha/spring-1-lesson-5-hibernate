DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE  users (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO users (name) VALUES ('Bob'), ('Jack');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE  products (id bigserial PRIMARY KEY, title VARCHAR(255), price INTEGER);
INSERT INTO products (title, price) VALUES ('box', 50), ('throne', 1230), ('phone', 15600), ('book', 5600) ;

DROP TABLE IF EXISTS users_products CASCADE;
CREATE TABLE users_products (user_id integer REFERENCES users (id), product_id integer REFERENCES products (id));
INSERT INTO users_products (user_id, product_id) VALUES (1, 1), (1, 2), (1, 3), (2, 4);
