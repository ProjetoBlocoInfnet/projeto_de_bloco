--Criação dos perfis
insert into tbl_perfil (descricao, nomePerfil) values ('Administrador', 'Administrador');
insert into tbl_perfil (descricao, nomePerfil) values ('Aluno', 'Aluno');
insert into tbl_perfil (descricao, nomePerfil) values ('Professor', 'Professor');

--Criação do ADM
insert into tbl_usuario (login, senha, perfil_id) values ('adm','adm','1');
insert into tbl_pessoa (cep, email, endereco, nome, status, usuario_id) values('20756070','elomwaizman@gmail.com','isso e teste 1', 'Adm','ATIVO','1');
insert into tbl_administrador values(1);
commit;

