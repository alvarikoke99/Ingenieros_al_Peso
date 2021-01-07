-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Web
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Web
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Web` ;
USE `Web` ;

-- -----------------------------------------------------
-- Table `Web`.`trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Web`.`trabajador` (
  `id_trabajador` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `dni` VARCHAR(45) NULL,
  PRIMARY KEY (`id_trabajador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Web`.`solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Web`.`solicitud` (
  `id_solicitud` INT NOT NULL,
  `tipo` VARCHAR(45) NULL,
  `fecha_ini` DATE NULL,
  `fecha_final` DATE NULL,
  `observacion` VARCHAR(45) NULL,
  `tramitada` TINYINT NULL,
  `trabajador_id_trabajador` INT NOT NULL,
  PRIMARY KEY (`id_solicitud`),
  INDEX `fk_solicitud_trabajador1_idx` (`trabajador_id_trabajador` ASC) VISIBLE,
  CONSTRAINT `fk_solicitud_trabajador1`
    FOREIGN KEY (`trabajador_id_trabajador`)
    REFERENCES `Web`.`trabajador` (`id_trabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Web`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Web`.`empresa` (
  `id_empresa` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id_empresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Web`.`relacion_empresa_trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Web`.`relacion_empresa_trabajador` (
  `trabajador_id_trabajador` INT NOT NULL,
  `empresa_id_empresa` INT NOT NULL,
  `departamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`trabajador_id_trabajador`, `empresa_id_empresa`),
  INDEX `fk_trabajador_has_empresa_empresa1_idx` (`empresa_id_empresa` ASC) VISIBLE,
  INDEX `fk_trabajador_has_empresa_trabajador1_idx` (`trabajador_id_trabajador` ASC) VISIBLE,
  CONSTRAINT `fk_trabajador_has_empresa_trabajador1`
    FOREIGN KEY (`trabajador_id_trabajador`)
    REFERENCES `Web`.`trabajador` (`id_trabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trabajador_has_empresa_empresa1`
    FOREIGN KEY (`empresa_id_empresa`)
    REFERENCES `Web`.`empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Web`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Web`.`proyecto` (
  `id_proyecto` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `informacion` VARCHAR(45) NULL,
  `empresa_id_empresa` INT NOT NULL,
  PRIMARY KEY (`id_proyecto`),
  INDEX `fk_proyecto_empresa1_idx` (`empresa_id_empresa` ASC) VISIBLE,
  CONSTRAINT `fk_proyecto_empresa1`
    FOREIGN KEY (`empresa_id_empresa`)
    REFERENCES `Web`.`empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Web`.`relacion_proyecto_trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Web`.`relacion_proyecto_trabajador` (
  `proyecto_id_proyecto` INT NOT NULL,
  `trabajador_id_trabajador` INT NOT NULL,
  PRIMARY KEY (`proyecto_id_proyecto`, `trabajador_id_trabajador`),
  INDEX `fk_proyecto_has_trabajador_trabajador1_idx` (`trabajador_id_trabajador` ASC) VISIBLE,
  INDEX `fk_proyecto_has_trabajador_proyecto1_idx` (`proyecto_id_proyecto` ASC) VISIBLE,
  CONSTRAINT `fk_proyecto_has_trabajador_proyecto1`
    FOREIGN KEY (`proyecto_id_proyecto`)
    REFERENCES `Web`.`proyecto` (`id_proyecto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proyecto_has_trabajador_trabajador1`
    FOREIGN KEY (`trabajador_id_trabajador`)
    REFERENCES `Web`.`trabajador` (`id_trabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Web`.`horas_jornada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Web`.`horas_jornada` (
  `horas` INT NULL,
  `fecha` DATETIME NULL,
  `proyecto_id_proyecto` INT NOT NULL,
  `trabajador_id_trabajador` INT NOT NULL,
  INDEX `fk_horas_jornada_proyecto1_idx` (`proyecto_id_proyecto` ASC) VISIBLE,
  INDEX `fk_horas_jornada_trabajador1_idx` (`trabajador_id_trabajador` ASC) VISIBLE,
  CONSTRAINT `fk_horas_jornada_proyecto1`
    FOREIGN KEY (`proyecto_id_proyecto`)
    REFERENCES `Web`.`proyecto` (`id_proyecto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_horas_jornada_trabajador1`
    FOREIGN KEY (`trabajador_id_trabajador`)
    REFERENCES `Web`.`trabajador` (`id_trabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
