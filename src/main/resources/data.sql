DROP TABLE IF EXISTS signup;

CREATE TABLE signup (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(128),
    address VARCHAR(128),
    religion VARCHAR(128),
    PRIMARY KEY (id)
);

INSERT INTO signup (name, address, religion) VALUES 
    ('Bob', 'Streety Street', 'Lutheran'),
    ('Dave', 'Roady Road', 'Hindu');