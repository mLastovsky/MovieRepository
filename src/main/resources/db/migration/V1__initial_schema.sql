CREATE TABLE IF NOT EXISTS Director
(
    id        SERIAL PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Movie
(
    id          SERIAL PRIMARY KEY,
    director_id INT REFERENCES Director (id) ON DELETE CASCADE,
    name        VARCHAR(255) NOT NULL
);
