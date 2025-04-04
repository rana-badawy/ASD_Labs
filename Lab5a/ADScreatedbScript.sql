DROP DATABASE IF EXISTS ADS;

CREATE SCHEMA IF NOT EXISTS `ADS` DEFAULT CHARACTER SET utf8 ;
USE `ADS` ;

CREATE TABLE IF NOT EXISTS `ADS`.`dentist` (
  `dentistId` INT NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(10) NOT NULL,
  `email` VARCHAR(100) NULL,
  `specialization` VARCHAR(100) NULL,
  PRIMARY KEY (`dentistId`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ADS`.`address` (
  `addressId` INT NOT NULL,
  `street` VARCHAR(100) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zipcode` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`addressId`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ADS`.`patient` (
  `patientId` INT NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(10) NOT NULL,
  `email` VARCHAR(100) NULL,
  `dob` DATE NULL,
  `addressId` INT NULL,
  PRIMARY KEY (`patientId`),
  FOREIGN KEY (`addressId`) REFERENCES `ADS`.`address` (`addressId`)
  )
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ADS`.`surgery` (
  `surgeryId` INT NOT NULL,
  `surgeryName` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(10) NOT NULL,
  `addressId` INT NOT NULL,
  PRIMARY KEY (`surgeryId`),
  FOREIGN KEY (`addressId`) REFERENCES `ADS`.`address` (`addressId`)
    )
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ADS`.`appointment` (
  `appointmentId` INT NOT NULL,
  `dentistId` INT NOT NULL,
  `patientId` INT NOT NULL,
  `surgeryId` INT NOT NULL,
  `appointmentDate` DATE NOT NULL,
  `appointmentTime` TIME NOT NULL,
  PRIMARY KEY (`appointmentId`),
  FOREIGN KEY (`surgeryId`) REFERENCES `ADS`.`surgery` (`surgeryId`),
  FOREIGN KEY (`dentistId`) REFERENCES `ADS`.`dentist` (`dentistId`),
  FOREIGN KEY (`patientId`) REFERENCES `ADS`.`patient` (`patientId`)
  )
ENGINE = InnoDB;


