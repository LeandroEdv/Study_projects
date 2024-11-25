# Sistema de Controle de Estoque 📦
Este é um projeto de estudo desenvolvido para aprimorar minhas habilidades em Java puro, com foco na Programação Orientada a Objetos (POO). O sistema foi criado para gerenciar produtos em estoque, permitindo funcionalidades como adicionar, buscar, atualizar e gerar relatórios.

## 📋 Funcionalidades
Cadastro de Produtos: Adicionar novos produtos ao sistema.
Atualização de Produtos: Alterar informações existentes no estoque.
Busca de Produtos: Localizar produtos por critérios específicos.
Geração de Relatórios: Criar relatórios com informações resumidas ou detalhadas do estoque.

# 🛠️ Tecnologias e Conceitos
Linguagem: Java (versão mínima recomendada: 11)
Conceitos aplicados:
Programação Orientada a Objetos (POO): Polimorfismo, encapsulamento e boas práticas.
Organização do Projeto: Estrutura em pacotes (model, service, reportService) para melhor modularização e manutenção.
Implementação manual de funcionalidades: Sem dependências externas, utilizando apenas as bibliotecas padrão do Java.

## 🧩 Estrutura do Projeto
model: Contém as classes que representam as entidades do sistema, como Produto.
service: Contém a lógica de negócios, como operações de busca e manipulação de dados.
reportService: Gerencia a geração de relatórios básicos do sistema.

## 🚀 Como Executar o Projeto
Pré-requisitos:
Java 11 ou superior instalado na máquina.
IDE de sua preferência (IntelliJ IDEA, Eclipse, VSCode, etc.).
Passos:
Clone este repositório:
bash
Copiar código
git clone [link_do_repositorio]
Importe o projeto na sua IDE.
Compile e execute a classe principal (ex.: Main).

## 💡 Desafios Superados
Centralização da Lógica de Busca:
Evitei duplicação de código ao unificar a lógica de busca em uma única classe, melhorando a coesão.
Organização Modular:
A separação em pacotes permitiu um código mais limpo e organizado, facilitando futuras manutenções.

