CREATE TABLE vehicles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(255),
    model VARCHAR(255),
    plate VARCHAR(255),
    vehicle_year INT,
    color VARCHAR(255),
    daily_value DECIMAL(10,2)
);

INSERT INTO vehicles(brand, model, plate, vehicle_year, color, daily_value) VALUES
    ('VW', 'Taos', 'thv-1g34', 2024, 'branca', 380.00);

CREATE TABLE people (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR(255),
    cpf VARCHAR(255),
    phone VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO people(client_name, cpf, phone, email) VALUES
    ('Natalia', '33388877783', '944447777', 'nati@gmail.com');

CREATE TABLE rentals (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    person_id BIGINT NOT NULL,
    vehicle_id BIGINT NOT NULL,
    start_date DATE,
    end_date DATE,
    total_value DECIMAL(10, 2),
    FOREIGN KEY (person_id) references people(id),
    FOREIGN KEY (vehicle_id) references vehicles(id)
);

INSERT INTO rentals(person_id, vehicle_id, start_date, end_date, total_value) VALUES
    (1, 1, '2024-10-01', '2024-10-15', 1500.00 );