INSERT INTO document_type (code, name) values ('DT001','Boletim de Nascimento');
INSERT INTO document_type (code, name) values ('DT002','Cedula');
INSERT INTO document_type (code, name) values ('DT003','Bilhete de Identidade');
INSERT INTO document_type (code, name) values ('DT004','Passport');
INSERT INTO document_type (code, name) values ('DT005','Nuit');
INSERT INTO document_type (code, name) values ('DT006','Cartão de Eleitor');
INSERT INTO document_type (code, name) values ('DT007','Carta de Condução');
INSERT INTO document_type (code, name) values ('DT008','Nuib');

INSERT INTO party (type, description, state, active) 
values ('CITIZEN', 'Cidadão', 0, '1');
            
INSERT INTO citizen (first_name, last_name, middle_name, suffix, personal_title, gender, birth_date, marital_status, party_id, state, active ) 
values ('Ivo','Abdul','Alberto Aly', null, null, 'MASCULINO','1983-09-11', 'CASADO', 1, 0, '1');

INSERT INTO geo (name, state, active) 
values ('Municipio de Maputo', 0, '1');
INSERT INTO geo (parent_id, name, state, active) 
values (1,'Bairro Luis Cabral', 0, '1');
INSERT INTO geo (parent_id, name, state, active) 
values (2,'Quarteirão 19', 0, '1');
INSERT INTO geo (parent_id, name, code, state, active) 
values (3,'Casa 26', '-25.938333, 32.542453', 0, '1');

INSERT INTO geo (parent_id, name, state, active) 
values (1,'Bairro Luis Cabral', 0, '1');
INSERT INTO geo (parent_id, name, state, active) 
values (5,'Quarteirão 4', 0, '1');
INSERT INTO geo (parent_id, name, code, state, active) 
values (6,'Predio 1788', '-25.965580, 32.579244', 0, '1');

INSERT INTO party (type, description, state, active) 
values ('RESIDENCE', 'Residência', 0, '1');
INSERT INTO residence (type, value, party_id, geo_id, state, active ) 
values ('CASA','26', 2, 4, 0, '1');

INSERT INTO party (type, description, state, active) 
values ('RESIDENCE', 'Residência', 0, '1');
INSERT INTO residence (type, value, party_id, geo_id, state, active ) 
values ('PREDIO','1788', 3, 7, 0, '1');

INSERT INTO party (type, description, state, active) 
values ('RESIDENCE', 'Residência', 0, '1');
INSERT INTO residence (parent_id, type, value, party_id, state, active ) 
values (2,'CASA','2º Andar, Nº 5', 4, 0, '1');

INSERT INTO party (type, description, state, active) 
values ('RESIDENCE', 'Residência', 0, '1');
INSERT INTO residence (parent_id, type, value, party_id, state, active ) 
values (2,'CASA','2º Andar, Nº 6', 5, 0, '1');


