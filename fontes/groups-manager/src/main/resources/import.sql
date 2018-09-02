INSERT INTO igreja(nome) VALUES('Católica'), ('Pastoral'), ('Presbiteriana');

INSERT INTO status_grupo(nome) VALUES ('POM');
INSERT INTO status_grupo(nome) VALUES ('GAM');

INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da criança',  1, 'Grupo de crianças', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da saúde',  1, 'Grupo de saúde', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da educação',  1, 'Grupo de educação', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da juventude',  1, 'Grupo de juventude', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da comunicação',  1, 'Grupo de comunicação', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da sobriedade',  1, 'Grupo de sobriedade', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral do menor',  1, 'Grupo de menor', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da liturgia',  1, 'Grupo de liturgia', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da catequese',  1, 'Grupo de catequese', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da familiar',  1, 'Grupo familiar', 1);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Pastoral da carcerária',  1, 'Grupo de carcerária', 1);

INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Encontro de Casais com Cristo',  2, 'Grupo de Casais', 2);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Apostolado da Oração',  2, 'Grupo de Oração', 2);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Renovação Carismática Católica',  2, 'Grupo de Renovação', 2);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Mãe Rainha',  2, 'Grupo de Mães', 2);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Terço dos Homens',  2, 'Grupo de Homens', 2);

INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Comunidade Canção Nova',  3, 'Grupo de Canção', 2);
INSERT INTO grupo(nome, igreja_id, objetivo, status_grupo_id)  VALUES('Oração Paroquiais',  3, 'Grupo de Paroquiais', 2);

insert into integrante(nome, celular, email, senha, sexo, data_nascimento, cpf, cadastro_efetivado) values ('Jhonatan', '12345678', 'jhonatan@gmail.com', '123456', 'MASCULINO', now(), '54022418214', 1), ('Caic', '12345678', 'caic@gmail.com', '123456', 'MASCULINO', now(), '54022418214', 1), ('Lucas', '12345678', 'lucas@gmail.com', '123456', 'MASCULINO', now(), '54022418214', 1), ('Marcia', '12345678', 'marcia@gmail.com', '123456', 'FEMININO', now(), '54022418214', 0), ('Gabriela', '12345678', 'gabriela@gmail.com', '123456', 'FEMININO', now(), '54022418214', 1);
  
insert into grupo_integrante values (1, 1), (1, 2), (1, 3), (1, 4), (2, 1), (2, 2), (3, 1), (3, 3), (3, 4);

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

INSERT INTO endereco VALUES (1,'Itapuã I','73.754-012','Local de festas perto centro','Planaltina','Quadra QR 12','DF','Brasília');
INSERT INTO evento VALUES (2,'2018-03-16 01:13:29','Encontro Luz',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (3,'2018-03-16 01:13:29','Encontro Pego',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (4,'2018-03-16 01:13:29','Encontro Bom',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (5,'2018-03-16 01:13:29','Encontro Santo',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (6,'2018-03-16 01:13:29','Encontro Nego',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (7,'2018-03-16 01:13:29','Encontro Jesus',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (8,'2018-03-16 01:13:29','Encontro Maior',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (9,'2018-03-16 01:13:29','Encontro Centrado',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (10,'2018-03-16 01:13:29','Encontro Melo',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
INSERT INTO evento VALUES (11,'2018-03-16 01:13:29','Encontro Martugico',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
