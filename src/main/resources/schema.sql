    CREATE TABLE IF NOT EXISTS messages (
        id VARCHAR(60) PRIMARY KEY DEFAULT gen_random_uuid(),
        text VARCHAR NOT NULL
    );