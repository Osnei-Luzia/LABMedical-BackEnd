INSERT INTO enderecos (id, bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia) VALUES (default, 'Residencial Anaville', '75102-075', 'Anápolis', 'Esquina com Rua 1001', 'GO', 'Rua AV 12', 920, 'Esquina');
INSERT INTO enderecos (id, bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia) VALUES (default, 'Alto de São Manoel', '59625-198', 'Mossoró', '', 'RN', '4ª Travessa Filgueira Filho', 641, 'Segundo Andar');
INSERT INTO enderecos (id, bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia) VALUES (default, 'Camping Clube', '72914-051', 'Águas Lindas de Goiás', 'Apartamento 101', 'GO', 'Quadra Quadra 38', 784, 'Prédio Amarelo');
INSERT INTO enderecos (id, bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia) VALUES (default, 'Areias', '58801-570', 'Sousa', 'Casa 02', 'PB', 'Rua Sady Fernandes Aragão', 209, 'Casa Verde');

INSERT INTO pessoas (id, cpf, data_nascimento, email, estado_civil, genero, naturalidade, nome_completo, rg, telefone) VALUES (default, '133.680.737-70','02/03/2001','augusto_melo@foar.unesp.br',0,'Masculino','Brasileiro','Augusto Francisco Melo','36.680.958-1','(62) 2537-3090');
INSERT INTO usuarios (crm, especializacao, senha, id) VALUES ('13124/SP', 2, '31dadw132cc', 1);
INSERT INTO pessoas (id, cpf, data_nascimento, email, estado_civil, genero, naturalidade, nome_completo, rg, telefone) VALUES (default, '166.100.222-67','25/02/1959','alicia.isabella.souza@doublesp.com.br',1,'Feminino','Brasileiro','Alícia Isabella de Souza','25.462.720-1','(84) 99584-5895');
INSERT INTO usuarios (crm, especializacao, senha, id) VALUES ('23130/SC', 0, 'dj1972ty5v', 2);

INSERT INTO pessoas (id, cpf, data_nascimento, email, estado_civil, genero, naturalidade, nome_completo, rg, telefone) VALUES (default, '413.796.492-00', '21/02/1978', 'maite_rocha@picolotoengenharia.com.br', 3, 'Feminino', 'Brasileiro', 'Maitê Malu Rocha', '27.594.616-2', '(61) 98222-9417');
INSERT INTO pacientes (contato_emergencia, convenio, endereco_id, numero_carteira, validade, id) VALUES ('(61) 3850-9502', 'Unimed', 1, '2543', '20/12/2033', 3);
INSERT INTO paciente_lista_alergias (paciente_id, lista_alergias) VALUES (3, 'Cuidado 1', 'Cuidado 2', 'Cuidado 3');
INSERT INTO paciente_lista_cuidados (paciente_id, lista_cuidados) VALUES (3, 'Alergia 2', 'Alergia 1');
INSERT INTO pessoas (id, cpf, data_nascimento, email, estado_civil, genero, naturalidade, nome_completo, rg, telefone) VALUES (default, '200.174.344-08', '09/03/1986', 'marcio_renato@saa.com.br', 3, 'Masculino', 'Brasileiro', 'Márcio Ryan Renato', '22.258.923-1', '(61) 98222-9417');
INSERT INTO pacientes (contato_emergencia, convenio, endereco_id, numero_carteira, validade, id) VALUES ('(83) 2970-7661', 'Unimed', 3, '2312', '20/06/2033', 4);
INSERT INTO paciente_lista_cuidados (paciente_id, lista_cuidados) VALUES (4, 'Alergia 2', 'Alergia 4');

INSERT INTO consultas (id, data_hora, descricao, dosagens, medicacao, motivo, paciente_id_id, usuario_id_id) VALUES (default, '27/04/23 16:22:28,841000000', 'Descrição da consulta', 'Dosagens', 'Medicações', 'Motivo da Consulta', 3, 1);
INSERT INTO consultas (id, data_hora, descricao, dosagens, medicacao, motivo, paciente_id_id, usuario_id_id) VALUES (default, '02/06/23 17:21:44,322000000', 'Descrição da consulta', 'Dosagens', 'Medicações', 'Motivo da Consulta', 4, 2);
INSERT INTO consultas (id, data_hora, descricao, dosagens, medicacao, motivo, paciente_id_id, usuario_id_id) VALUES (default, '22/05/23 22:12:54,432000000', 'Descrição da consulta', 'Dosagens', 'Medicações', 'Motivo da Consulta', 4, 2);
INSERT INTO consultas (id, data_hora, descricao, dosagens, medicacao, motivo, paciente_id_id, usuario_id_id) VALUES (default, '10/04/23 18:42:33,765000000', 'Descrição da consulta', 'Dosagens', 'Medicações', 'Motivo da Consulta', 3, 1);

INSERT INTO exames (id, arquivo, data_hora, laboratorio, nome, paciente_id_id, resultado, tipo, usuario_id_id) VALUES (default, 'url/arquivo.pdf', '12/04/23 12:11:44,753000000', 'Laboratório 1', 'Nome do Exame', 4, 'Resultados de exame', 'Tipo de Exame', 2);
INSERT INTO exames (id, arquivo, data_hora, laboratorio, nome, paciente_id_id, resultado, tipo, usuario_id_id) VALUES (default, 'url/arquivo.pdf', '20/02/23 15:32:32,123000000', 'Laboratório 2', 'Nome do Exame', 3, 'Resultados de exame', 'Tipo de Exame', 1);
INSERT INTO exames (id, arquivo, data_hora, laboratorio, nome, paciente_id_id, resultado, tipo, usuario_id_id) VALUES (default, 'url/arquivo.pdf', '22/12/23 14:55:23,642000000', 'Laboratório 4', 'Nome do Exame', 4, 'Resultados de exame', 'Tipo de Exame', 2);
INSERT INTO exames (id, arquivo, data_hora, laboratorio, nome, paciente_id_id, resultado, tipo, usuario_id_id) VALUES (default, 'url/arquivo.pdf', '01/04/23 12:44:11,142000000', 'Laboratório 2', 'Nome do Exame', 3, 'Resultados de exame', 'Tipo de Exame', 1);
