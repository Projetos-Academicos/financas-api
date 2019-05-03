INSERT INTO categoria (id, descricao, nome) VALUES (nextval('seq_categoria'), 'Cinêma, Praia, Passeios e Diversão em geral...',  'Lazer');
INSERT INTO categoria (id, descricao, nome) VALUES (nextval('seq_categoria'), 'Passagens de Ônibus, Recarga do VEM, Uber, etc...', 'Transporte');
INSERT INTO categoria (id, descricao, nome) VALUES (nextval('seq_categoria'), 'Faturas do cartão de créditos...' , 'Cartão de Crédito');

INSERT INTO status (id, nome) VALUES (nextval('seq_status'), 'Pago');
INSERT INTO status (id, nome) VALUES (nextval('seq_status'), 'Recebido');
INSERT INTO status (id, nome) VALUES (nextval('seq_status'), 'Em Parcelamento');
INSERT INTO status (id, nome) VALUES (nextval('seq_status'), 'A Pagar');
INSERT INTO status (id, nome) VALUES (nextval('seq_status'), 'A Receber');
