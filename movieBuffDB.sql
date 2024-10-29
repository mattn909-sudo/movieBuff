-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema movieBuff
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema movieBuff
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movieBuff` ;
USE `movieBuff` ;

-- -----------------------------------------------------
-- Table `movieBuff`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieBuff`.`user` (
  `user_id` INT NOT NULL,
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
DEFAULT CHARACTER SET = binary;


-- -----------------------------------------------------
-- Table `movieBuff`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieBuff`.`movies` (
  `movies_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`movies_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movieBuff`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieBuff`.`review` (
  `id` INT NOT NULL,
  `stars` INT NOT NULL,
  `userreview` VARCHAR(1000) NULL,
  `movies_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `movies_id`, `user_id`),
  INDEX `fk_review_movies1_idx` (`movies_id` ASC) VISIBLE,
  INDEX `fk_review_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_movies1`
    FOREIGN KEY (`movies_id`)
    REFERENCES `movieBuff`.`movies` (`movies_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `movieBuff`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movieBuff`.`director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieBuff`.`director` (
  `director_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`director_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movieBuff`.`movies_has_director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieBuff`.`movies_has_director` (
  `movies_id` INT NOT NULL,
  `director_id` INT NOT NULL,
  PRIMARY KEY (`movies_id`, `director_id`),
  INDEX `fk_movies_has_director_director1_idx` (`director_id` ASC) VISIBLE,
  INDEX `fk_movies_has_director_movies1_idx` (`movies_id` ASC) VISIBLE,
  CONSTRAINT `fk_movies_has_director_movies1`
    FOREIGN KEY (`movies_id`)
    REFERENCES `movieBuff`.`movies` (`movies_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movies_has_director_director1`
    FOREIGN KEY (`director_id`)
    REFERENCES `movieBuff`.`director` (`director_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movieBuff`.`user_movie_favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieBuff`.`user_movie_favorites` (
  `user_id` INT NOT NULL,
  `movies_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `movies_id`),
  INDEX `fk_user_has_movies_movies1_idx` (`movies_id` ASC) VISIBLE,
  INDEX `fk_user_has_movies_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_movies_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `movieBuff`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_movies_movies1`
    FOREIGN KEY (`movies_id`)
    REFERENCES `movieBuff`.`movies` (`movies_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
DEFAULT CHARACTER SET = binary;


-- -----------------------------------------------------
-- Table `movieBuff`.`user_has_watchlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieBuff`.`user_has_watchlist` (
  `user_id` INT NOT NULL,
  `movies_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `movies_id`),
  INDEX `fk_user_has_movies1_movies1_idx` (`movies_id` ASC) VISIBLE,
  INDEX `fk_user_has_movies1_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_movies1_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `movieBuff`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_movies1_movies1`
    FOREIGN KEY (`movies_id`)
    REFERENCES `movieBuff`.`movies` (`movies_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
DEFAULT CHARACTER SET = binary;


-- -----------------------------------------------------
-- Table `movieBuff`.`actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieBuff`.`actor` (
  `actor_id` INT NOT NULL,
  `Name` VARCHAR(60) NULL,
  PRIMARY KEY (`actor_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movieBuff`.`movies_has_actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieBuff`.`movies_has_actor` (
  `movies_id` INT NOT NULL,
  `actor_id` INT NOT NULL,
  PRIMARY KEY (`movies_id`, `actor_id`),
  INDEX `fk_movies_has_actor_actor1_idx` (`actor_id` ASC) VISIBLE,
  INDEX `fk_movies_has_actor_movies1_idx` (`movies_id` ASC) VISIBLE,
  CONSTRAINT `fk_movies_has_actor_movies1`
    FOREIGN KEY (`movies_id`)
    REFERENCES `movieBuff`.`movies` (`movies_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movies_has_actor_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `movieBuff`.`actor` (`actor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
