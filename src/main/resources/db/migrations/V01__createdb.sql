CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- oldera.flyway_schema_history definition

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- oldera.produto definition

CREATE TABLE `produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- oldera.role_model definition

CREATE TABLE `role_model` (
  `roleid` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `UK_qh0gf17r2yjrnhqx4gldk75ru` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- oldera.url_permissao definition

CREATE TABLE `url_permissao` (
  `permissao_id` bigint NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`permissao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- oldera.user_model definition

CREATE TABLE `user_model` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_on8hgbn7akcme34i1cfm5pblb` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- oldera.vendedor definition

CREATE TABLE `vendedor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- oldera.pedido definition

CREATE TABLE `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `preco` double NOT NULL,
  `quantidade` int NOT NULL,
  `valor_total` double NOT NULL,
  `cliente` bigint DEFAULT NULL,
  `produto` bigint DEFAULT NULL,
  `vendedor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3n7g0gf9fttq3pr3rqa76gg54` (`cliente`),
  KEY `FKgkuie42sv8lj90bm793n483mx` (`produto`),
  KEY `FKne4mvfajgnxlg6xfk3743kvcg` (`vendedor`),
  CONSTRAINT `FK3n7g0gf9fttq3pr3rqa76gg54` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKgkuie42sv8lj90bm793n483mx` FOREIGN KEY (`produto`) REFERENCES `produto` (`id`),
  CONSTRAINT `FKne4mvfajgnxlg6xfk3743kvcg` FOREIGN KEY (`vendedor`) REFERENCES `vendedor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- oldera.url_permissao_roles definition

CREATE TABLE `url_permissao_roles` (
  `permissao_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKbbypacvxvbbte1lwr6kqgkl61` (`role_id`),
  KEY `FKndvp6i2odtrjuwb68cr5yp65n` (`permissao_id`),
  CONSTRAINT `FKbbypacvxvbbte1lwr6kqgkl61` FOREIGN KEY (`role_id`) REFERENCES `role_model` (`roleid`),
  CONSTRAINT `FKndvp6i2odtrjuwb68cr5yp65n` FOREIGN KEY (`permissao_id`) REFERENCES `url_permissao` (`permissao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- oldera.user_model_roles definition

CREATE TABLE `user_model_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKdnoxnj43r8xxnqg5rctelmitl` (`role_id`),
  KEY `FKfkr9py1i800t696ullk9fh705` (`user_id`),
  CONSTRAINT `FKdnoxnj43r8xxnqg5rctelmitl` FOREIGN KEY (`role_id`) REFERENCES `role_model` (`roleid`),
  CONSTRAINT `FKfkr9py1i800t696ullk9fh705` FOREIGN KEY (`user_id`) REFERENCES `user_model` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;