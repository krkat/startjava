\c robots;

DROP TABLE IF EXISTS jaegers;
CREATE TABLE jaegers(
    id INT PRIMARY KEY,
    model_name VARCHAR(30),
    mark VARCHAR(7),
    height DECIMAL(10,3),
    weight DECIMAL(10,3),
    status VARCHAR(30),
    origin VARCHAR(30),
    launch DATE,
    kaiju_kill INT
);

\ir populate.sql;
\ir queries.sql;