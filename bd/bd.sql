-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema webGotinha
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema webGotinha
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `webGotinha` DEFAULT CHARACTER SET utf8 ;
USE `webGotinha` ;

-- -----------------------------------------------------
-- Table `webGotinha`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webGotinha`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `dataNasc` DATE NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webGotinha`.`Vacina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webGotinha`.`Vacina` (
  `idVacina` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `dose` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(155) NULL,
  PRIMARY KEY (`idVacina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webGotinha`.`Cartao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webGotinha`.`Cartao` (
  `idCartao` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idCartao`, `idUsuario`),
  INDEX `fk_Cartao_Usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Cartao_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `webGotinha`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webGotinha`.`VacinaCartao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webGotinha`.`VacinaCartao` (
  `data` DATE NOT NULL,
  `Cartao_idCartao` INT NOT NULL,
  `Cartao_idUsuario` INT NOT NULL,
  `Vacina_idVacina` INT NOT NULL,
  PRIMARY KEY (`Cartao_idCartao`, `Cartao_idUsuario`, `Vacina_idVacina`),
  INDEX `fk_vacinaCartao_Vacina1_idx` (`Vacina_idVacina` ASC),
  CONSTRAINT `fk_vacinaCartao_Cartao1`
    FOREIGN KEY (`Cartao_idCartao` , `Cartao_idUsuario`)
    REFERENCES `webGotinha`.`Cartao` (`idCartao` , `idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacinaCartao_Vacina1`
    FOREIGN KEY (`Vacina_idVacina`)
    REFERENCES `webGotinha`.`Vacina` (`idVacina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
