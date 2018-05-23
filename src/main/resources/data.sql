insert into tipo_lance values (tipo_lance_id_seq.nextval, 'A qualquer momento é possível verificar o valor de todos os lances já gerados e qual o lance vencedor
no momento da consulta', 'Aberto');

insert into tipo_lance values (tipo_lance_id_seq.nextval,'Não é possível saber os lances já realizados. Apenas ao final do leilão os valores são tornados
públicos e o vencedor conhecido', 'Fechado');

insert into natureza_leilao values (natureza_leilao_id_seq.nextval, 'Usuários fazem lance de demanda para comprar um lote que um usuário pretende
disponibilizar pelo maior preço. Vence o participante que fez o maior lance de demanda primeiro entre todos
os lances, desde que seu lance seja maior do que o preço mínimo estabelecido pelo usuário responsável pelo
lote', 'Leilão de demanda');

insert into natureza_leilao values (natureza_leilao_id_seq.nextval, 'Usuário oferta um lote que outro usuário pretende adquirir pelo menor preço. Vence o
participante que fez o menor lance de oferta primeiro entre todos os lances, desde que seu valor seja inferior
ao preço máximo estabelecido pelo usuário responsável pelo lote', 'Leilão de oferta');

insert into categoria_item values (categoria_item_id_seq.nextval, 'Informática');

insert into categoria_item values (categoria_item_id_seq.nextval, 'Vestuário');

insert into categoria_item values (categoria_item_id_seq.nextval, 'Imóvel');

insert into categoria_item values (categoria_item_id_seq.nextval, 'Veículo');

insert into categoria_item values (categoria_item_id_seq.nextval, 'Mobiliário');

insert into item values (item_id_seq.nextval, 'Mouse gamer XYZ', 'Mouse', 1);

insert into item values (item_id_seq.nextval, 'Teclado gamer XYZ','Teclado', 1);

insert into item values (item_id_seq.nextval, 'Camaro 1979', 'Camaro', 4);

insert into item values (item_id_seq.nextval, 'Ford antigo','Ford Modelo T', 4);

insert into item values (item_id_seq.nextval, 'Motor V8 small block 5.4 de 250 cv brutos e, de 1965 em diante, um big block de 425 cv', 'Chevrolet Corvette', 4);

insert into item values (item_id_seq.nextval, 'SVT Cobra e seu V8 supercharged de 4,6 litros e 390 cv','Ford Mustang', 4);

insert into item values (item_id_seq.nextval, 'Cama de casal King size', 'Cama', 5);

insert into item values (item_id_seq.nextval, 'Fogão 6 bocas','Fogão', 5);

insert into item values (item_id_seq.nextval, 'Ventilador de teto', 'Ventilador', 5);

insert into item values (item_id_seq.nextval, 'Mesa de jantar 6 cadeiras','Mesa', 5);

insert into lote values (lote_id_seq.nextval, 'Lote de Itens e Informática');

insert into lote_item values (1, 1);

insert into lote_item values (1, 2);

insert into lote values (lote_id_seq.nextval, 'Lote de Carros Clássicos');

insert into lote_item values (2, 3);

insert into lote_item values (2, 4);

insert into lote_item values (2, 5);

insert into lote_item values (2, 6);

insert into lote values (lote_id_seq.nextval, 'Lote de Móveis usados');

insert into lote_item values (3, 7);

insert into lote_item values (3, 8);

insert into lote_item values (3, 9);

insert into lote_item values (3, 10);

insert into usuario values (usuario_id_seq.nextval, '01386283002', 'llara.juliano@gmail.com', 'Juliano', '1');

insert into leilao values (leilao_id_seq.nextval, sysdate + 10, sysdate, 90000, '900.00', 1, 1, 1, 1);

insert into leilao values (leilao_id_seq.nextval, sysdate + 10, sysdate,  1050, '10.50', 2, 2, 2, 1);

insert into leilao values (leilao_id_seq.nextval, sysdate - 8, sysdate - 11,  20000, '200.00', 3, 2, 2, 1);

insert into lance values (lance_id_seq.nextval, sysdate, 12345, '123.45', 1, 1);

insert into lance values (lance_id_seq.nextval, sysdate, 10045, '100.45', 1, 1);

insert into lance values (lance_id_seq.nextval, sysdate, 90045, '900.45', 1, 1);

insert into lance values (lance_id_seq.nextval, sysdate, 12345, '123.45', 2, 1);

insert into lance values (lance_id_seq.nextval, sysdate, 10045, '100.45', 2, 1);

insert into lance values (lance_id_seq.nextval, sysdate, 90045, '900.45', 2, 1);

insert into lance values (lance_id_seq.nextval, sysdate - 9, 12345, '123.45', 3, 1);

insert into lance values (lance_id_seq.nextval, sysdate - 9, 10045, '100.45', 3, 1);

insert into lance values (lance_id_seq.nextval, sysdate - 9, 90045, '900.45', 3, 1);