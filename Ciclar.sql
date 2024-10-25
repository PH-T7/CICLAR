CREATE DATABASE Ciclar;
USE Ciclar;

CREATE TABLE Coletores (
    coletor_id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    area_atuacao VARCHAR(100) 
);

CREATE TABLE Produtores (
    produtor_id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200),
    tipo_material VARCHAR(50), 
    quantidade_disponivel INT 
);
CREATE TABLE Materiais (
    material_id INT PRIMARY KEY,
    nome_material VARCHAR(50) NOT NULL,
    descricao VARCHAR(200) 
);

CREATE TABLE PontosDeColeta (
    ponto_id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200),
    horario_funcionamento VARCHAR(100)
);

CREATE TABLE Coletas (
    coleta_id INT PRIMARY KEY,
    coletor_id INT,
    produtor_id INT,
    material_id INT,
    data_coleta DATE,
    quantidade INT,
    FOREIGN KEY (coletor_id) REFERENCES Coletores(coletor_id),
    FOREIGN KEY (produtor_id) REFERENCES Produtores(produtor_id),
    FOREIGN KEY (material_id) REFERENCES Materiais(material_id)
);

CREATE TABLE DestinosReciclagem (
    destino_id INT PRIMARY KEY,
    material_id INT,
    ponto_id INT,
    quantidade_recebida INT,
    data_recebimento DATE,
    FOREIGN KEY (material_id) REFERENCES Materiais(material_id),
    FOREIGN KEY (ponto_id) REFERENCES PontosDeColeta(ponto_id)
);

INSERT INTO Coletores (coletor_id, nome, telefone, area_atuacao)
VALUES 
    (1, 'João Silva', '99999-1234', 'Centro'),
    (2, 'Maria Oliveira', '99999-5678', 'Zona Norte'),
    (3, 'Carlos Souza', '99999-9012', 'Zona Sul'),
    (4, 'Ana Santos', '99999-3456', 'Centro'),
    (5, 'Roberto Lima', '99999-7890', 'Zona Oeste');
    
INSERT INTO Produtores (produtor_id, nome, endereco, tipo_material, quantidade_disponivel)
VALUES 
    (1, 'Supermercado Central', 'Rua A, 123 - Centro', 'Papelão', 150),
    (2, 'Escola Municipal ABC', 'Rua B, 456 - Zona Norte', 'Plástico', 80),
    (3, 'Hospital Vida', 'Avenida C, 789 - Zona Sul', 'Papel', 200),
    (4, 'Restaurante Bom Sabor', 'Rua D, 101 - Zona Oeste', 'Vidro', 120),
    (5, 'Empresa de Tecnologia X', 'Avenida E, 202 - Centro', 'Metal', 300);



