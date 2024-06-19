drop database massarim;

CREATE DATABASE massarim;
USE massarim;

CREATE TABLE usuario(
idUsuario INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
senha VARCHAR(45),
email VARCHAR(100),
cpf CHAR(14),
telefone CHAR(15),
dataNascimento DATE,
admin INT NOT NULL DEFAULT 2
);

CREATE TABLE categorias(
    idCategorias INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(40)
);

CREATE TABLE tamanho(
	idTamanho INT AUTO_INCREMENT PRIMARY KEY,
    tamanho VARCHAR(40)
    );



CREATE TABLE produto(
    idProduto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    fkIdCategoria INT,
    fkIdTamanho INT,
    descricao TEXT,
    preco FLOAT,
    estoque INT,
    imagem VARCHAR(255),
    FOREIGN KEY (fkIdCategoria) REFERENCES categorias(idCategorias),
    FOREIGN KEY (fkIdTamanho) REFERENCES tamanho(idTamanho)
);




CREATE TABLE endereco(
	idEndereco INT AUTO_INCREMENT PRIMARY KEY,
    fkIdUsuario INT,
    cep CHAR(9),
    rua VARCHAR(100),
    numero INT,
    complemento VARCHAR(50),
    referencia VARCHAR(100),
    bairro VARCHAR(45),
    cidade VARCHAR(60),
    estado CHAR(2)
);


CREATE TABLE pedido(
    idPedido INT AUTO_INCREMENT PRIMARY KEY,
    rua varchar(100),
    numero INT,
    precoTotal FLOAT,
    dataPedido DATE,
    tipoPagamento VARCHAR(20),
    fkIdUsuario INT,
    FOREIGN KEY (fkIdUsuario) REFERENCES usuario(idUsuario)
);

-- CREATE TABLE pedidoProduto(
--    idPedidoProduto INT AUTO_INCREMENT PRIMARY KEY,
--    fkIdPedido INT,
--    fkIdProduto INT,
--    quantidade INT,
--    precoUnidade FLOAT,
 --   FOREIGN KEY (fkIdPedido) REFERENCES pedido(idPedido),
  --  FOREIGN KEY (fkIdProduto) REFERENCES produto(idProduto)
-- );

SELECT * FROM usuario;

INSERT INTO usuario (nome, senha, email, cpf, telefone, dataNascimento, admin) 
VALUES ('Luiz', '123', 'luiz@gmail.com', '123.456.789-00', '(11)98765-4321', '2007-05-04', 2),
('admin', 'admin', 'admin@gmail.com', '123.456.789-00', '(11)98765-4321', '2007-05-04', 1);



INSERT INTO categorias (nome) VALUES
('Vestidos'),
('Saias'),
('Calças'),
('Sapatos'),
('Camisas');

INSERT INTO produto (nome, fkIdCategoria,descricao,preco ,estoque ,imagem) VALUES
('SALTO PRETO', 4,'salto lindo, disponível na cor preta, clássico, chique e vesátil.',199.99,9,'assets/sapato.jpg');
