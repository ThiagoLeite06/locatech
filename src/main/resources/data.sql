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