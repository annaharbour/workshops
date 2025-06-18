DROP DATABASE IF EXISTS dealership;
CREATE DATABASE IF NOT EXISTS dealership;
USE dealership;

# ---------------------------------------------------------------------- #
# Add table "vehicles"                                                 #
# ---------------------------------------------------------------------- #

CREATE TABLE vehicles(
	VIN varchar(250) PRIMARY KEY NOT NULL UNIQUE,
    vehicle_year YEAR NOT NULL,
	make varchar(50) NOT NULL,
	model varchar(50) NOT NULL,
    vehicle_type varchar(50) NOT NULL,
	color varchar(50) NOT NULL,
    mileage int NOT NULL,
    price decimal
);

# ---------------------------------------------------------------------- #
# Add table "sales_contracts"                                                 #
# ---------------------------------------------------------------------- #

CREATE TABLE sales_contracts(
	id int AUTO_INCREMENT PRIMARY KEY,
	name varchar(50) NOT NULL,
	phone varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
	VIN varchar(50) NOT NULL,
    financed bool NOT NULL,
	FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

# ---------------------------------------------------------------------- #
# Add table "lease_contracts"                                                 #
# ---------------------------------------------------------------------- #

CREATE TABLE lease_contracts(
	id int AUTO_INCREMENT PRIMARY KEY,
	name varchar(50) NOT NULL,
	phone varchar(50) NOT NULL,
	VIN varchar(50) NOT NULL,
	FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);
