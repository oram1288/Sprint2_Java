CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description VARCHAR(200) NOT NULL,
    quantity INTEGER NOT NULL,
    seller_id INTEGER NOT NULL,
    FOREIGN KEY (seller_id) REFERENCES users(id)
);