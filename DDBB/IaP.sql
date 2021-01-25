-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema web
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema web
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `web` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema web
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema web
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `web` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `web` ;
USE `web` ;

-- -----------------------------------------------------
-- Table `web`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web`.`empresa` (
  `id_empresa` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_empresa`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `web`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web`.`proyecto` (
  `id_proyecto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `informacion` VARCHAR(45) NULL DEFAULT NULL,
  `id_empresa` INT NOT NULL,
  PRIMARY KEY (`id_proyecto`),
  INDEX `fk_proyecto_empresa1_idx` (`id_empresa` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `web`.`trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web`.`trabajador` (
  `id_trabajador` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `dni` VARCHAR(45) NULL DEFAULT NULL,
  `ultima_jornada` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id_trabajador`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `web`.`horas_jornada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web`.`horas_jornada` (
  `horas` INT NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `id_proyecto` INT NOT NULL,
  `id_trabajador` INT NOT NULL,
  INDEX `fk_horas_jornada_proyecto1_idx` (`id_proyecto` ASC) VISIBLE,
  INDEX `fk_horas_jornada_trabajador1_idx` (`id_trabajador` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `web`.`registro_jornada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web`.`registro_jornada` (
  `fecha_entrada` DATETIME NOT NULL,
  `fecha_salida` DATETIME NOT NULL,
  `id_trabajador` INT NOT NULL,
  `id_proyecto` INT NOT NULL,
  INDEX `fk_registro_jornada_trabajador1_idx` (`id_trabajador` ASC) VISIBLE,
  INDEX `fk_registro_jornada_proyecto1_idx` (`id_proyecto` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `web`.`relacion_empresa_trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web`.`relacion_empresa_trabajador` (
  `id_trabajador` INT NOT NULL,
  `id_empresa` INT NOT NULL,
  `departamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_trabajador`, `id_empresa`),
  INDEX `fk_trabajador_has_empresa_empresa1_idx` (`id_empresa` ASC) VISIBLE,
  INDEX `fk_trabajador_has_empresa_trabajador1_idx` (`id_trabajador` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `web`.`relacion_proyecto_trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web`.`relacion_proyecto_trabajador` (
  `id_proyecto` INT NOT NULL,
  `id_trabajador` INT NOT NULL,
  PRIMARY KEY (`id_proyecto`, `id_trabajador`),
  INDEX `fk_proyecto_has_trabajador_trabajador1_idx` (`id_trabajador` ASC) VISIBLE,
  INDEX `fk_proyecto_has_trabajador_proyecto1_idx` (`id_proyecto` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `web`.`solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `web`.`solicitud` (
  `id_solicitud` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_ini` DATE NULL DEFAULT NULL,
  `fecha_final` DATE NULL DEFAULT NULL,
  `observacion` VARCHAR(45) NULL DEFAULT NULL,
  `tramitada` TINYINT NULL DEFAULT NULL,
  `id_trabajador` INT NOT NULL,
  PRIMARY KEY (`id_solicitud`),
  INDEX `fk_solicitud_trabajador1_idx` (`id_trabajador` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
