CREATE TABLE IF NOT EXISTS `user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` TEXT NOT NULL,
    `password_encoder_type` VARCHAR(45) NOT NULL,
    `authorities` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `client_detail` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `client_Id` VARCHAR(20) NOT NULL,
      `client_secret` VARCHAR(20) NOT NULL,
      `resource_ids` VARCHAR(40) NOT NULL,
      `authorized_grant_types` VARCHAR(255) NOT NULL,
      `web_server_redirect_uris` VARCHAR(40) NOT NULL,
      `authorities` VARCHAR(40) NOT NULL,
      `auto_approve` VARCHAR(40),
      `scope` VARCHAR(40) NOT NULL,
      `access_token_validity` INT NOT NULL default 300 ,
      `refresh_token_validity` INT NOT NULL default 600 ,
    PRIMARY KEY (`id`));

