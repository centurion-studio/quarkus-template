CREATE TABLE customer
(
    customer_id SERIAL PRIMARY KEY,
    first_name  TEXT NOT NULL,
    middle_name TEXT,
    last_name   TEXT NOT NULL,
    suffix      TEXT,
    email       TEXT,
    phone       TEXT
);