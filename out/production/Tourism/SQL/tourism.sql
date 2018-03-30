DROP SCHEMA IF EXISTS `tourism` ;
CREATE SCHEMA IF NOT EXISTS `tourism`;
CREATE TABLE IF NOT EXISTS `tourism`.`client` (
  `idClient` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `cnp` VARCHAR(45) NULL DEFAULT NULL,
  `card` VARCHAR(45) NULL DEFAULT NULL,
  `adress` VARCHAR(45) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idClient`));
  
CREATE TABLE IF NOT EXISTS `tourism`.`person` (
  `idPerson` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `cnp` VARCHAR(45) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idPerson`));
  
CREATE TABLE IF NOT EXISTS `tourism`.`reservation` (
  `idReservation` INT(11) NOT NULL AUTO_INCREMENT,
  `destination` VARCHAR(45) NULL DEFAULT NULL,
  `hotel` VARCHAR(45) NULL DEFAULT NULL,
  `personNumber` INT(11) NULL DEFAULT NULL,
  `price` INT(11) NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `partialPayment` INT(11) NULL DEFAULT NULL,
  `idClient` INT(11) NULL DEFAULT NULL,
  `paid` BOOLEAN NULL DEFAULT NULL,
  PRIMARY KEY (`idReservation`),
  FOREIGN KEY (`idClient`) REFERENCES client(`idClient`));
  
CREATE TABLE IF NOT EXISTS `tourism`.`ReservationPersons` (
  `idReservationPerson` INT(11) NOT NULL AUTO_INCREMENT,
  `idReservation` INT(11) NULL DEFAULT NULL,
  `idPerson` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idReservationPerson`),
  FOREIGN KEY (`idReservation`) REFERENCES reservation(`idReservation`),
  FOREIGN KEY (`idPerson`) REFERENCES person(`idPerson`));  
    
CREATE TABLE IF NOT EXISTS `tourism`.`payments` (
  `idpayment` INT(11) NOT NULL AUTO_INCREMENT,
  `idReservation` INT(11) NULL DEFAULT NULL,
  `idClient` INT(11) NULL DEFAULT NULL,
  `payment` INT(11) NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idpayment`),
  FOREIGN KEY (`idReservation`) REFERENCES reservation(`idReservation`),
  FOREIGN KEY (`idClient`) REFERENCES client(`idClient`));  

CREATE TABLE IF NOT EXISTS`tourism`.`userinfo` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));
  
CREATE TABLE IF NOT EXISTS`tourism`.`agentinfo` (
  `idagent` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `info` VARCHAR(200) NULL,
  `date` DATE,
  PRIMARY KEY (`idagent`),
  FOREIGN KEY (`username`) REFERENCES userinfo(`username`));  
  
  