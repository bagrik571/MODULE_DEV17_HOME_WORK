CREATE TABLE note
(
    id      SERIAL PRIMARY KEY,
    user_id BIGINT                               NOT NULL,
    title   VARCHAR CHECK (length(title) <= 150) NOT NULL,
    content VARCHAR
);
ALTER SEQUENCE note_id_seq RESTART WITH 1;


