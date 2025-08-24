-- Create the content table
CREATE TABLE IF NOT EXISTS content (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50),
    content_type VARCHAR(50),
    date_created TIMESTAMP,
    date_updated TIMESTAMP,
    url VARCHAR(500)
);