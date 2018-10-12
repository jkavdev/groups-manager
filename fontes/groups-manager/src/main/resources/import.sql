INSERT INTO igreja(id, nome) VALUES(1, 'Paróquia Cristo Redentor');

INSERT INTO status_grupo(id, nome, descricao) VALUES (1, 'Pastoral', 'Pastoral, é serviço, ação, trabalho desenvolvido pela Igreja. Ação organizada e dirigida pela Diocese e Paróquia para “atender” determinada situação em uma realidade específica.');
INSERT INTO status_grupo(id, nome, descricao) VALUES (2, 'Movimento', 'Movimento, são grupos específico com organização específica muitas vezes independente, não diretamente ligados a uma paróquia. Os movimentos nascem e se formam num contexto externo à igreja local, mas atuam dentro da Paróquia.');
INSERT INTO status_grupo(id, nome, descricao) VALUES (3, 'Grupo', 'Grupo, é formados por fiéis, que se reúnem de forma espontânea, porém sempre com a licença e orientação do pároco ou vigário paroquial e tendo como base a oração e a escuta da Palavra.');

INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id) VALUES('Pastoral da Criança',  1, 'Para que todas as crianças tenham vida em abundância', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id) VALUES('Pastoral da Saúde',  1, 'Evangelizar com renovado ardor missionário o mundo da saúde, à luz da opção preferencial pelos pobres e enfermos, participando da construção de uma sociedade justa e solidária a serviço da vida', 1);

INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id) VALUES('ECC (Encontro de Casais com Cristo)',  1, 'Discemina ensinamentos e trabalhos religiosos voltado a casais e à instituição do matrimônio. Tradicionalmente ocorre em um final de semana, iniciando na sexta-feira à noite, incluindo-se todo o dia do sábado e encerrando no domingo à noite', 2);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id) VALUES('Terço dos Homens',  1, 'é a oração do terço realizada pelos homens. A missão deste terço é resgatar para o seio da Igreja de Cristo homens de todas as idades, pois a presença masculina na Igreja é imprescindível para a formação da família e de uma sociedade cristã', 2);

INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id) VALUES('GAM (Grupo de Animação Missionária)',  1, 'Responsável por animar a dinâmica missionária da Arquidiocese, congregando os organismos afins a esta tarefa.', 3);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id) VALUES('EJOC (Encontro de Jovens com Cristo)',  1, 'O EJOC realiza reuniões e dias de formação espiritual, momentos de louvor e adoração a Deus, vigílias, promove campanhas de arrecadação de alimentos e brinquedos, visita a creches e asilos e conta com um grupo de canto, o Coral do EJOC', 3);

insert into integrante(nome, celular, email, sexo, data_nascimento, cpf, cadastro_efetivado) values ('Jhonatan', '12345678', 'jhonatan@gmail.com', 'MASCULINO', date_add('1990/05/09', interval 3030 day), '76732380982', 1);

insert into integrante(nome, celular, email, sexo, data_nascimento, cpf, cadastro_efetivado) values ('Caic', '12345678', 'caic@gmail.com', 'MASCULINO', date_add('1990/05/09', interval 2000 day), '86568613100', 1);

insert into integrante(nome, celular, email, sexo, data_nascimento, cpf, cadastro_efetivado) values ('Lucas', '12345678', 'lucas@gmail.com', 'MASCULINO', date_add('1990/05/09', interval 1030 day), '84106522420', 1);

insert into integrante(nome, celular, email, sexo, data_nascimento, cpf, cadastro_efetivado) values ('Marcia Souza', '12345678', 'marcia@gmail.com', 'FEMININO', date_add('1990/05/09', interval 830 day), '73130338349', 0);

insert into integrante(nome, celular, email, sexo, data_nascimento, cpf, cadastro_efetivado) values ('Bruna Carla', '12345678', 'marcia@gmail.com', 'FEMININO', date_add('1990/05/09', interval 830 day), '36965297026', 0);

insert into integrante(nome, celular, email, sexo, data_nascimento, cpf, cadastro_efetivado) values ('Gabriela Mendes', '12345678', 'gabriela@gmail.com', 'FEMININO', date_add('1990/05/09', interval 930 day), '76955721798', 1);

insert into integrante(nome, celular, email, sexo, data_nascimento, cpf, cadastro_efetivado) values ('Paula Santos', '12345678', 'gabriela@gmail.com', 'FEMININO', date_add('1990/05/09', interval 830 day), '94727374803', 1);

insert into grupo_integrante(grupo_id, integrante_id) values (1,1);
insert into grupo_integrante(grupo_id, integrante_id) values (1,2);
insert into grupo_integrante(grupo_id, integrante_id) values (1,3);
insert into grupo_integrante(grupo_id, integrante_id) values (1,4);
insert into grupo_integrante(grupo_id, integrante_id) values (1,5);
insert into grupo_integrante(grupo_id, integrante_id) values (1,6);

insert into grupo_integrante(grupo_id, integrante_id) values (2,1);
insert into grupo_integrante(grupo_id, integrante_id) values (2,2);

insert into grupo_integrante(grupo_id, integrante_id) values (3,2);
insert into grupo_integrante(grupo_id, integrante_id) values (3,4);
insert into grupo_integrante(grupo_id, integrante_id) values (3,1);
insert into grupo_integrante(grupo_id, integrante_id) values (3,5);

insert into grupo_integrante(grupo_id, integrante_id) values (4,1);
insert into grupo_integrante(grupo_id, integrante_id) values (4,3);
insert into grupo_integrante(grupo_id, integrante_id) values (4,2);

insert into grupo_integrante(grupo_id, integrante_id) values (5,1);
insert into grupo_integrante(grupo_id, integrante_id) values (5,2);
insert into grupo_integrante(grupo_id, integrante_id) values (5,3);
insert into grupo_integrante(grupo_id, integrante_id) values (5,4);
insert into grupo_integrante(grupo_id, integrante_id) values (5,5);
insert into grupo_integrante(grupo_id, integrante_id) values (5,6);

INSERT INTO endereco VALUES (1,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');
INSERT INTO endereco VALUES (2,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');
INSERT INTO endereco VALUES (3,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');
INSERT INTO endereco VALUES (4,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');
INSERT INTO endereco VALUES (5,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');
INSERT INTO endereco VALUES (6,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');
INSERT INTO endereco VALUES (7,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');
INSERT INTO endereco VALUES (8,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');
INSERT INTO endereco VALUES (9,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');
INSERT INTO endereco VALUES (10,'Itapuã I','73754012','Local de festas perto centro','Planaltina','Quadra QR 12','GO','15');

INSERT INTO evento VALUES (2, date_add(now(), interval 10 day),'Encontro Luz',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (3,date_add(now(), interval 5 day),'Encontro Pego',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,2,2);
INSERT INTO evento VALUES (4, date_add(now(), interval 2 day),'Encontro Bom',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,3,2);

INSERT INTO evento VALUES (5, date_add(now(), interval 9 day),'Encontro Santo',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,4,3);
INSERT INTO evento VALUES (6, date_add(now(), interval 7 day),'Encontro Nego',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,5,3);
INSERT INTO evento VALUES (7, date_add(now(), interval 5 day),'Encontro Jesus',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,6,3);

INSERT INTO evento VALUES (8, date_add(now(), interval 6 day),'Encontro Maior',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,7,5);
INSERT INTO evento VALUES (9, date_add(now(), interval 7 day),'Encontro Centrado',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,8,5);
INSERT INTO evento VALUES (10, date_add(now(), interval 4 day),'Encontro Melo',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,9,5);

INSERT INTO evento VALUES (11, date_add(now(), interval 1 day),'Encontro Martugico',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,10,4);

INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (1,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Bom, tá funcionando',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (2,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Outra, véi esse negócio é bom mesmo',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (3,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Bom, tá funcionando',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (4,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Outra, véi esse negócio é bom mesmo',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (5,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Bom, tá funcionando',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (6,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Outra, véi esse negócio é bom mesmo',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (7,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Bom, tá funcionando',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (8,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Outra, véi esse negócio é bom mesmo',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (9,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Bom, tá funcionando',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (10,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Outra, véi esse negócio é bom mesmo',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (11,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Bom, tá funcionando',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (12,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Outra, véi esse negócio é bom mesmo',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (13,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Bom, tá funcionando',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (14,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Outra, véi esse negócio é bom mesmo',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (15,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Bom, tá funcionando',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (16,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Outra, véi esse negócio é bom mesmo',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (17,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Bom, tá funcionando',2);
INSERT INTO noticia(id, corpo, aberta_ao_publico, titulo, grupo_id) VALUES (18,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',0,'Outra, véi esse negócio é bom mesmo',2);

INSERT INTO topico_noticia VALUES (1,'ESPORTE'),(1,'CIENCIA_TECNOLOGIA'),(1,'MUNDO'),(2,'MUNDO'),(2,'NEGOCIOS'),(2,'CIENCIA_TECNOLOGIA'),(2,'ENTRETERIMENTO'),(2,'ESPORTE'),(2,'SAUDE'),(2,'OUTROS');