INSERT INTO role_model(role_name)
VALUES
    ('ROLE_ADMIN'),
    ('ROLE_USER');

INSERT INTO user_model(user_name, password)
VALUES
    ('admin', '$2a$04$qcu79M01fmUFVK33j5X.BuEZHEER0DTFBPLmOyf.iegeLIIYuJnia'),
    ('user', '$2a$04$.D3/TQb48W6Qq2vQBCEmZOdqLRhIvIMJdhw5PfPkAgdAtRQ8QUt/O');

INSERT INTO user_model_roles(user_id, role_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);