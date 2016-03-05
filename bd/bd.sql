-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema WebGotinha
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema WebGotinha
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `WebGotinha` DEFAULT CHARACTER SET utf8 ;
USE `WebGotinha` ;

-- -----------------------------------------------------
-- Table `WebGotinha`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WebGotinha`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `dataNasc` DATE NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebGotinha`.`Vacina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WebGotinha`.`Vacina` (
  `idVacina` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `dose` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(155) NULL,
  PRIMARY KEY (`idVacina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebGotinha`.`Cartao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WebGotinha`.`Cartao` (
  `idCartao` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idCartao`, `idUsuario`),
  INDEX `fk_Cartao_Usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Cartao_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `WebGotinha`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebGotinha`.`VacinaCartao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WebGotinha`.`VacinaCartao` (
  `data` DATE NOT NULL,
  `id_Cartao` INT NOT NULL,
  `id_Usuario` INT NOT NULL,
  `id_Vacina` INT NOT NULL,
  PRIMARY KEY (`id_Cartao`, `id_Usuario`, `id_Vacina`),
  INDEX `fk_vacinaCartao_Vacina1_idx` (`id_Vacina` ASC),
  CONSTRAINT `fk_vacinaCartao_Cartao1`
    FOREIGN KEY (`id_Cartao` , `id_Usuario`)
    REFERENCES `WebGotinha`.`Cartao` (`idCartao` , `idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacinaCartao_Vacina1`
    FOREIGN KEY (`id_Vacina`)
    REFERENCES `WebGotinha`.`Vacina` (`idVacina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
