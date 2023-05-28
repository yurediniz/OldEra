CREATE TABLE `cliente`
(
  `id`       bigint NOT NULL AUTO_INCREMENT,
  `email`    varchar(255) DEFAULT NULL,
  `nome`     varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- oldera.produto definition

CREATE TABLE `produto`
(
  `id`    bigint NOT NULL AUTO_INCREMENT,
  `nome`  varchar(255) DEFAULT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id`)
);

-- oldera.role_model definition

CREATE TABLE `role_model`
(
  `roleid`    bigint       NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY (`role_name`)
);

-- oldera.url_permissao definition

CREATE TABLE `url_permissao`
(
  `permissao_id` bigint       NOT NULL AUTO_INCREMENT,
  `url`          varchar(255) NOT NULL,
  PRIMARY KEY (`permissao_id`)
);

-- oldera.user_model definition

CREATE TABLE `user_model`
(
  `user_id`   bigint       NOT NULL AUTO_INCREMENT,
  `password`  varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY (`user_name`)
);

-- oldera.vendedor definition

CREATE TABLE `vendedor`
(
  `id`       bigint NOT NULL AUTO_INCREMENT,
  `email`    varchar(255) DEFAULT NULL,
  `nome`     varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- oldera.pedido definition

CREATE TABLE `pedido`
(
  `id`          bigint NOT NULL AUTO_INCREMENT,
  `preco`       double NOT NULL,
  `quantidade`  int    NOT NULL,
  `valor_total` double NOT NULL,
  `cliente`     bigint DEFAULT NULL,
  `produto`     bigint DEFAULT NULL,
  `vendedor`    bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT FOREIGN KEY (`produto`) REFERENCES `produto` (`id`),
  CONSTRAINT FOREIGN KEY (`vendedor`) REFERENCES `vendedor` (`id`)
);

-- oldera.url_permissao_roles definition

CREATE TABLE `url_permissao_roles` (
  `permissao_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  CONSTRAINT FOREIGN KEY (`role_id`) REFERENCES `role_model` (`roleid`),
  CONSTRAINT FOREIGN KEY (`permissao_id`) REFERENCES `url_permissao` (`permissao_id`)
);


-- oldera.user_model_roles definition

CREATE TABLE `user_model_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  CONSTRAINT FOREIGN KEY (`role_id`) REFERENCES `role_model` (`roleid`),
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user_model` (`user_id`)
);