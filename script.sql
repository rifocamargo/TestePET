-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema teste_pet
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `teste_pet` ;

-- -----------------------------------------------------
-- Schema teste_pet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `teste_pet` ;
USE `teste_pet` ;

-- -----------------------------------------------------
-- Table `teste_pet`.`perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_pet`.`perfil` ;

CREATE TABLE IF NOT EXISTS `teste_pet`.`perfil` (
  `id_perfil` INT NOT NULL AUTO_INCREMENT,
  `nome_perfil` VARCHAR(45) NOT NULL,
  `descricao_perfil` VARCHAR(255) NOT NULL,
  `pct_desconto_perfil` DECIMAL(4,2) NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teste_pet`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_pet`.`cliente` ;

CREATE TABLE IF NOT EXISTS `teste_pet`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nome_cliente` VARCHAR(255) NULL,
  `id_perfil` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_cliente_perfil1_idx` (`id_perfil` ASC),
  CONSTRAINT `fk_cliente_perfil1`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `teste_pet`.`perfil` (`id_perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teste_pet`.`pessoa_juridica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_pet`.`pessoa_juridica` ;

CREATE TABLE IF NOT EXISTS `teste_pet`.`pessoa_juridica` (
  `cnpj_pessoa_juridica` VARCHAR(19) NOT NULL,
  `id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_pessoa_juridica_cliente_idx` (`id_cliente` ASC),
  UNIQUE INDEX `cnpj_pessoa_juridica_UNIQUE` (`cnpj_pessoa_juridica` ASC),
  CONSTRAINT `fk_pessoa_juridica_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `teste_pet`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teste_pet`.`pessoa_fisica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_pet`.`pessoa_fisica` ;

CREATE TABLE IF NOT EXISTS `teste_pet`.`pessoa_fisica` (
  `pessoa_fisica_cpf` VARCHAR(14) NOT NULL,
  `id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_pessoa_fisica_cliente1_idx` (`id_cliente` ASC),
  UNIQUE INDEX `pessoa_fisica_cpf_UNIQUE` (`pessoa_fisica_cpf` ASC),
  CONSTRAINT `fk_pessoa_fisica_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `teste_pet`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teste_pet`.`servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_pet`.`servico` ;

CREATE TABLE IF NOT EXISTS `teste_pet`.`servico` (
  `id_servico` INT NOT NULL AUTO_INCREMENT,
  `nome_servico` VARCHAR(45) NOT NULL,
  `descricao_servico` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_servico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teste_pet`.`servico_pessoa_juridica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_pet`.`servico_pessoa_juridica` ;

CREATE TABLE IF NOT EXISTS `teste_pet`.`servico_pessoa_juridica` (
  `id_servico` INT NOT NULL,
  `id_cliente` INT NOT NULL,
  `data_inicio` DATETIME NOT NULL,
  `data_fim` DATETIME NOT NULL,
  `valor` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`id_servico`, `id_cliente`),
  INDEX `fk_servico_has_pessoa_juridica_pessoa_juridica1_idx` (`id_cliente` ASC),
  INDEX `fk_servico_has_pessoa_juridica_servico1_idx` (`id_servico` ASC),
  CONSTRAINT `fk_servico_has_pessoa_juridica_servico1`
    FOREIGN KEY (`id_servico`)
    REFERENCES `teste_pet`.`servico` (`id_servico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servico_has_pessoa_juridica_pessoa_juridica1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `teste_pet`.`pessoa_juridica` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `teste_pet`.`servico_pessoa_fisica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teste_pet`.`servico_pessoa_fisica` ;

CREATE TABLE IF NOT EXISTS `teste_pet`.`servico_pessoa_fisica` (
  `id_servico` INT NOT NULL,
  `id_cliente` INT NOT NULL,
  `data_inicio` DATETIME NOT NULL,
  `data_fim` DATETIME NOT NULL,
  `valor` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`id_servico`, `id_cliente`),
  INDEX `fk_servico_has_pessoa_fisica_pessoa_fisica1_idx` (`id_cliente` ASC),
  INDEX `fk_servico_has_pessoa_fisica_servico1_idx` (`id_servico` ASC),
  CONSTRAINT `fk_servico_has_pessoa_fisica_servico1`
    FOREIGN KEY (`id_servico`)
    REFERENCES `teste_pet`.`servico` (`id_servico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servico_has_pessoa_fisica_pessoa_fisica1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `teste_pet`.`pessoa_fisica` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



INSERT INTO `teste_pet`.`perfil` (`nome_perfil`, `descricao_perfil`, `pct_desconto_perfil`) VALUES ('Ouro', 'Ouro', '10');
INSERT INTO `teste_pet`.`perfil` (`nome_perfil`, `descricao_perfil`, `pct_desconto_perfil`) VALUES ('Prata', 'Prata', '5');

INSERT INTO `teste_pet`.`cliente` (`nome_cliente`, `id_perfil`) VALUES ('Cliente 1', '1');
INSERT INTO `teste_pet`.`cliente` (`nome_cliente`, `id_perfil`) VALUES ('Cliente 2', '2');
INSERT INTO `teste_pet`.`cliente` (`nome_cliente`, `id_perfil`) VALUES ('Cliente 3', '1');
INSERT INTO `teste_pet`.`cliente` (`nome_cliente`, `id_perfil`) VALUES ('Cliente 4', '2');

INSERT INTO `teste_pet`.`pessoa_fisica` (`pessoa_fisica_cpf`, `id_cliente`) VALUES ('123.456.789-12', '1');
INSERT INTO `teste_pet`.`pessoa_fisica` (`pessoa_fisica_cpf`, `id_cliente`) VALUES ('987.654.321-09', '3');

INSERT INTO `teste_pet`.`pessoa_juridica` (`cnpj_pessoa_juridica`, `id_cliente`) VALUES ('123.456.789/1234-12', '2');
INSERT INTO `teste_pet`.`pessoa_juridica` (`cnpj_pessoa_juridica`, `id_cliente`) VALUES ('987.654.321/4321-21', '4');

INSERT INTO `teste_pet`.`servico` (`nome_servico`, `descricao_servico`) VALUES ('Internet', 'Internet Banda Larga');
INSERT INTO `teste_pet`.`servico` (`nome_servico`, `descricao_servico`) VALUES ('E-mail', 'Serviço de e-mail');
INSERT INTO `teste_pet`.`servico` (`nome_servico`, `descricao_servico`) VALUES ('Database', 'Banco de dados');
INSERT INTO `teste_pet`.`servico` (`nome_servico`, `descricao_servico`) VALUES ('Desenvolvimento', 'Desenvolvimento de softwares');

INSERT INTO `teste_pet`.`servico_pessoa_fisica` (`id_servico`, `id_cliente`, `data_inicio`, `data_fim`, `valor`) VALUES ('1', '1', '2016-01-01 00:00:00', '2017-01-01 00:00:00', '1234');
INSERT INTO `teste_pet`.`servico_pessoa_fisica` (`id_servico`, `id_cliente`, `data_inicio`, `data_fim`, `valor`) VALUES ('2', '3', '2016-01-01 00:00:00', '2017-01-01 00:00:00', '4321');
INSERT INTO `teste_pet`.`servico_pessoa_juridica` (`id_servico`, `id_cliente`, `data_inicio`, `data_fim`, `valor`) VALUES ('3', '2', '2016-01-01 00:00:00', '2017-01-01 00:00:00', '1234');
INSERT INTO `teste_pet`.`servico_pessoa_juridica` (`id_servico`, `id_cliente`, `data_inicio`, `data_fim`, `valor`) VALUES ('4', '4', '2016-01-01 00:00:00', '2017-01-01 00:00:00', '4321');


