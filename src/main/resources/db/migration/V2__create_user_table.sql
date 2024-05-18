Create TABLE users
(
    id                SERIAL PRIMARY KEY,
    username          VARCHAR(50) NOT NULL UNIQUE CHECK ( LENGTH(username) >= 2 and LENGTH(username) <= 50),
    password          VARCHAR(64) NOT NULL check ( LENGTH(password) >= 10 and LENGTH(password) <= 64),
    email             VARCHAR     NOT NULL check (CHAR_LENGTH(email) >= 10),
    created_date      DATE        NOT NULL,
    last_updated_date DATE        NOT NULL,
    role              Varchar     NOT NULL check(role in ('USER','ADMIN')),
    enabled           BOOLEAN     NOT NULL
);
ALTER SEQUENCE note_id_seq RESTART WITH 1;
ALTER TABLE public.note
    ADD CONSTRAINT note_fk FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE;

