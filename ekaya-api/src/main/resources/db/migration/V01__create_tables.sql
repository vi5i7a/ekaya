SET SQL_MODE= 'ALLOW_INVALID_DATES';

CREATE TABLE document_type
(
   id BIGINT (38) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   code VARCHAR (10) NOT NULL,
   name VARCHAR (50) NOT NULL,
   created_date TIMESTAMP,
   UNIQUE KEY uq_document_type_code (code),
   UNIQUE KEY uq_document_type_name (name)
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE TABLE party
(
   id BIGINT (38) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   type VARCHAR (10) NOT NULL,
   description VARCHAR (50),
   created_date TIMESTAMP,
   modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   state BIGINT (1) NOT NULL,
   active CHAR (1) NOT NULL
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE TABLE citizen
(
   id BIGINT (38) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   first_name VARCHAR (50) NOT NULL,
   last_name VARCHAR (50) NOT NULL,
   middle_name VARCHAR (50),
   suffix VARCHAR (10),
   personal_title VARCHAR (10),
   gender VARCHAR (10),
   birth_date DATE,
   marital_status VARCHAR (10),
   party_id BIGINT (38) NOT NULL,
   created_date TIMESTAMP,
   modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   state BIGINT (1) NOT NULL,
   active CHAR (1) NOT NULL,
   CONSTRAINT fk_citizen_party_id FOREIGN KEY (party_id) REFERENCES party(id),
   UNIQUE KEY uq_citizen_party_id (party_id)
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE TABLE geo
(
   id BIGINT (38) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   parent_id BIGINT (38),
   name VARCHAR (20) NOT NULL,
   code VARCHAR (30),
   created_date TIMESTAMP,
   modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   state BIGINT (1) NOT NULL,
   active CHAR (1) NOT NULL,
   CONSTRAINT fk_geo_parent_id FOREIGN KEY (parent_id) REFERENCES geo(id)
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE TABLE residence
(
   id BIGINT (38) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   parent_id BIGINT (38),
   type VARCHAR (20) NOT NULL,
   value VARCHAR (20) NOT NULL,
   geo_id BIGINT (38),
   party_id BIGINT (38) NOT NULL,
   created_date TIMESTAMP,
   modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   state BIGINT (1) NOT NULL,
   active CHAR (1) NOT NULL,
   CONSTRAINT fk_residence_parent_id FOREIGN KEY (parent_id) REFERENCES residence(id),
   CONSTRAINT fk_residence_party_id FOREIGN KEY (party_id) REFERENCES party(id),
   UNIQUE KEY uq_residence_party_id (party_id)
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE TABLE document_code (
	id BIGINT(38) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	document_type_id BIGINT(38) NOT NULL,
	party_id BIGINT(38) NOT NULL,
	CONSTRAINT fk_document_type_id FOREIGN KEY (document_type_id) REFERENCES document_type(id),
	CONSTRAINT fk_party_id FOREIGN KEY (party_id) REFERENCES party(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;