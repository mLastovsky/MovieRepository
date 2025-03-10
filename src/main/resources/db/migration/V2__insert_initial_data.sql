-- Вставляем данные в таблицу Director
INSERT INTO Director (firstName)
VALUES
    ('Christopher'),
    ('Steven'),
    ('Quentin');

-- Вставляем данные в таблицу Movie
INSERT INTO Movie (director_id, name)
VALUES
    (1, 'Inception'),        -- Фильм от Christopher
    (1, 'Interstellar'),     -- Фильм от Christopher
    (2, 'Jaws'),             -- Фильм от Steven
    (2, 'Jurassic Park'),    -- Фильм от Steven
    (3, 'Pulp Fiction'),     -- Фильм от Quentin
    (3, 'Kill Bill');
