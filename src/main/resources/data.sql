insert into empresa (id_empresa, nome, cnpj, nome_fantasia, endereco) 
values (empresa_id_seq.nextval, 'Dell Computadores do Brasil Ltda', '72.381.189/0001-10', 'Dell', 
'Av. Industrial Belgraf, 400 Bairro Medianeira Eldorado do Sul - RS CEP 92990-000');

insert into empresa (id_empresa, nome, cnpj, nome_fantasia, endereco) 
values (empresa_id_seq.nextval, 'Stefanini Consultoria e Assessoria Em Informatica S.A.', '58.069.360/0005-53', 'Stefanini', 
'Av Ipiranga, 6681, Pavlh 96D Sala 210, Azenha, Porto Alegre, RS, CEP 90610-001, Brasil');

insert into empresa (id_empresa, nome, cnpj, nome_fantasia, endereco) 
values (empresa_id_seq.nextval, 'Hewlett-packard Do Brasil Ltda', '61.797.924/0001-55', 'HP', 
'Av Ipiranga, 6681 Pd 91 Puc | Porto Alegre - , CEP: 90610-001');

insert into empresa (id_empresa, nome, cnpj, nome_fantasia, endereco) 
values (empresa_id_seq.nextval, 'Ag�ncia qualquer', '54.484.444/0001-55', 'HP', 
'Av Borges de Medeiros, 6688 | Porto Alegre - , CEP: 90110-050');

insert into oportunidade (id_oportunidade, id_empresa, nome, descricao, valor_string, data_aprovacao, data_reprovacao)
values(oportunidade_id_seq.nextval, 1, 'Desenvolvedor Java', 'Desenvolver software sob press�o. A pre�o de banana.', '800,00', sysdate, null);

insert into oportunidade (id_oportunidade, id_empresa, nome, descricao, valor_string, data_aprovacao, data_reprovacao)
values(oportunidade_id_seq.nextval, 1, 'Desenvolvedor JavaScript', 'Desenvolver software sob press�o. Necess�rio beber cerveja e jogar video game,
pois faz parte do pagamento.', '500,00', null, null);

insert into oportunidade (id_oportunidade, id_empresa, nome, descricao, valor_string, data_aprovacao, data_reprovacao)
values(oportunidade_id_seq.nextval, 1, 'Desenvolvedor Java + JavaScript', 'Desenvolver software deve ser sua vida. 
Benef�cios: metas arrojadas, puff, ambiente descolado.', '300,00', sysdate, null);

insert into usuario (id_usuario, nome, cpf, senha, email, id_tipo_usuario)
values(usuario_id_seq.nextval, 'Aluno da Universidade', '000000000000', '1', '1', 1);

insert into usuario (id_usuario, nome, cpf, senha, email, id_tipo_usuario)
values(usuario_id_seq.nextval, 'Empresa Parceira', '000000000000', '2', '2', 2);

insert into usuario (id_usuario, nome, cpf, senha, email, id_tipo_usuario)
values(usuario_id_seq.nextval, 'Diretor da Universidade', '000000000000', '3', '3', 3);

insert into usuario (id_usuario, nome, cpf, senha, email, id_tipo_usuario)
values(usuario_id_seq.nextval, 'Secretaria da Universidade', '000000000000', '4', '4', 4);