INSERT INTO categoria (id, descricao, nome) VALUES (nextval('seq_categoria'), 'Cinêma, Praia, Passeios e Diversão em geral...',  'Lazer');
INSERT INTO categoria (id, descricao, nome) VALUES (nextval('seq_categoria'), 'Passagens de Ônibus, Recarga do VEM, Uber, etc...', 'Transporte');
INSERT INTO categoria (id, descricao, nome) VALUES (nextval('seq_categoria'), 'Faturas do cartão de créditos...' , 'Cartão de Crédito');

INSERT INTO status (id, nome) VALUES (nextval('seq_status'), 'Pago');
INSERT INTO status (id, nome) VALUES (nextval('seq_status'), 'Recebido');
INSERT INTO status (id, nome) VALUES (nextval('seq_status'), 'Parcelando');
INSERT INTO status (id, nome) VALUES (nextval('seq_status'), 'Futuro');


INSERT INTO lancamento (id, descricao, nome, valor, data, parcelado, despesa, categoria_id, status_id ) 
VALUES (nextval('seq_lancamento'), 'Viagem de uber da sefaz para casa', 'Uber', 23.50, '25/04/2019', false, false, 1, 2);

INSERT INTO lancamento (id, descricao, nome, valor, data, parcelado, despesa, categoria_id, status_id, quantidade_parcelas, valor_parcelas) 
VALUES (nextval('seq_lancamento'), 'Viagem de uber da sefaz para casa', 'Uber', 23.50, '25/04/2019', true, true, 1, 1, 3, 10.30);

INSERT INTO lancamento (id, descricao, nome, valor, data, parcelado, despesa, categoria_id, status_id) 
VALUES (nextval('seq_lancamento'), 'Viagem de uber da sefaz para casa', 'Uber', 23.50, '25/04/2019', false, true, 1 , 1);
