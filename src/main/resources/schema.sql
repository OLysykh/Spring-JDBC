CREATE TABLE IF NOT EXISTS book( id BIGSERIAL PRIMARY KEY,
    bookName TEXT NOT NULL,
    bookAuthor TEXT NOT NULL,
    added timestamp DEFAULT now()
);