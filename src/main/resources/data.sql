insert into empresa (id_empresa, nome, cnpj, nome_fantasia, endereco) 
values (empresa_id_seq.nextval, 'Dell Computadores do Brasil Ltda', '72.381.189/0001-10', 'Dell', 
'Av. Industrial Belgraf, 400 Bairro Medianeira Eldorado do Sul - RS CEP 92990-000');

insert into empresa (id_empresa, nome, cnpj, nome_fantasia, endereco) 
values (empresa_id_seq.nextval, 'Stefanini Consultoria e Assessoria Em Informatica S.A.', '58.069.360/0005-53', 'Stefanini', 
'Av Ipiranga, 6681, Pavlh 96D Sala 210, Azenha, Porto Alegre, RS, CEP 90610-001, Brasil');

insert into empresa (id_empresa, nome, cnpj, nome_fantasia, endereco) 
values (empresa_id_seq.nextval, 'Hewlett-packard Do Brasil Ltda', '61.797.924/0001-55', 'HP', 
'Av Ipiranga, 6681 Pd 91 Puc | Porto Alegre - , CEP: 90610-001');

insert into oportunidade (id_oportunidade, id_empresa, nome, descricao, valor_string, data_aprovacao, data_reprovacao)
values(oportunidade_id_seq.nextval, 1, 'Desenvolvedor Java', 'Desenvolver software sob pressão', '800,00', sysdate, null);


