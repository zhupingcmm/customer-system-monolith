CREATE TABLE IF NOT EXISTS `user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` TEXT NOT NULL,
    `password_encoder_type` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `authority` (
   `id` INT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(45) NOT NULL,
    `user_id` INT,
    constraint fk_id foreign key (id) references user(id)on delete CASCADE ,
    constraint pk_id PRIMARY KEY (`id`));

