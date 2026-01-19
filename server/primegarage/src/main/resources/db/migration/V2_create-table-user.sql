CREATE TABLE user (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      email VARCHAR(50),
      password CHAR (10),
      name VARCHAR(100) NOT NULL,
      phone CHAR(11) NOT NULL,
      date_of_birth DATE NOT NULL
)