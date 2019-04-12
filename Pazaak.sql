-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ID222177_g38
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ID222177_g38
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ID222177_g38` DEFAULT CHARACTER SET latin1 ;
USE `ID222177_g38` ;

-- -----------------------------------------------------
-- Table `ID222177_g38`.`speler`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ID222177_g38`.`speler` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `naam` VARCHAR(45) NOT NULL,
  `geboortedatum` VARCHAR(45) NOT NULL,
  `krediet` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ID222177_g38`.`kaart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ID222177_g38`.`kaart` (
  `type` VARCHAR(45) NOT NULL,
  `waarde` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `spelerid` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `kaart_ibfk_1_idx` (`spelerid` ASC),
  CONSTRAINT `kaart_ibfk_1`
    FOREIGN KEY (`spelerid`)
    REFERENCES `ID222177_g38`.`speler` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ID222177_g38`.`spel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ID222177_g38`.`spel` (
  `idspel` VARCHAR(45) NOT NULL,
  `kaartA1` INT(11) NULL DEFAULT NULL,
  `kaartA2` INT(11) NULL DEFAULT NULL,
  `kaartA3` INT(11) NULL DEFAULT NULL,
  `kaartA4` INT(11) NULL DEFAULT NULL,
  `kaartB1` INT(11) NULL DEFAULT NULL,
  `kaartB2` INT(11) NULL DEFAULT NULL,
  `kaartB3` INT(11) NULL DEFAULT NULL,
  `kaartB4` INT(11) NULL DEFAULT NULL,
  `spelerid1` INT(11) NULL DEFAULT NULL,
  `spelerid2` INT(11) NULL DEFAULT NULL,
  `gewonnenset1` INT(11) NULL DEFAULT NULL,
  `gewonnenset2` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idspel`),
  INDEX `kaartA1_idx` (`kaartA1` ASC),
  INDEX `kaartA2_idx` (`kaartA2` ASC),
  INDEX `kaartA3_idx` (`kaartA3` ASC),
  INDEX `kaartA4_idx` (`kaartA4` ASC),
  INDEX `kaartB1_idx` (`kaartB1` ASC),
  INDEX `kaartB2_idx` (`kaartB2` ASC),
  INDEX `kaartB3_idx` (`kaartB3` ASC),
  INDEX `kaartB4_idx` (`kaartB4` ASC),
  INDEX `speler2_idx` (`spelerid2` ASC),
  INDEX `speler1_idx` (`spelerid1` ASC),
  CONSTRAINT `kaartA1`
    FOREIGN KEY (`kaartA1`)
    REFERENCES `ID222177_g38`.`kaart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `kaartA2`
    FOREIGN KEY (`kaartA2`)
    REFERENCES `ID222177_g38`.`kaart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `kaartA3`
    FOREIGN KEY (`kaartA3`)
    REFERENCES `ID222177_g38`.`kaart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `kaartA4`
    FOREIGN KEY (`kaartA4`)
    REFERENCES `ID222177_g38`.`kaart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `kaartB1`
    FOREIGN KEY (`kaartB1`)
    REFERENCES `ID222177_g38`.`kaart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `kaartB2`
    FOREIGN KEY (`kaartB2`)
    REFERENCES `ID222177_g38`.`kaart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `kaartB3`
    FOREIGN KEY (`kaartB3`)
    REFERENCES `ID222177_g38`.`kaart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `kaartB4`
    FOREIGN KEY (`kaartB4`)
    REFERENCES `ID222177_g38`.`kaart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `speler1`
    FOREIGN KEY (`spelerid1`)
    REFERENCES `ID222177_g38`.`speler` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `speler2`
    FOREIGN KEY (`spelerid2`)
    REFERENCES `ID222177_g38`.`speler` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
