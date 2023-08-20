CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;
INSERT INTO Cliente(id, nome) values (nextval('hibernate_sequence'), 'Camila');
INSERT INTO Cliente(id, nome) values (nextval('hibernate_sequence'), 'Outra pessoa');
INSERT INTO Cliente(id, nome) values (nextval('hibernate_sequence'), 'Mais outra pessoa');
INSERT INTO Cliente(id, nome) values (nextval('hibernate_sequence'), 'A última pessoa');