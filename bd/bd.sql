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
-- Table `webGotinha`.`Vacina_has_Cartao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webGotinha`.`Vacina_has_Cartao` (
  `id_vacina` INT NOT NULL,
  `id_cartao` INT NOT NULL,
  PRIMARY KEY (`id_vacina`, `id_cartao`),
  INDEX `fk_Vacina_has_Cartao_Cartao1_idx` (`id_cartao` ASC),
  INDEX `fk_Vacina_has_Cartao_Vacina_idx` (`id_vacina` ASC),
  CONSTRAINT `fk_Vacina_has_Cartao_Vacina`
    FOREIGN KEY (`id_vacina`)
    REFERENCES `webGotinha`.`Vacina` (`idVacina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vacina_has_Cartao_Cartao1`
    FOREIGN KEY (`id_cartao`)
    REFERENCES `webGotinha`.`Cartao` (`idCartao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
