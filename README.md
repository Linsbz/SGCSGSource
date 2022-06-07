# Sistema de Gerenciamento de Conteúdo para Sites Genéricos - SGCSG

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

## Cadastros:
```
- usuário (tipos: comum, redator, administrador)
- notícia
- anúncio
- área de anúncio
- enquete e opção de voto
- formulário e campo de formulário
- tema
```
## Processo de negócio:
```
- postagem de anúncio
- postagem de notícia
- voto
- resposta de formulário
- compra de tema
```

# Executando o projeto no VS Code

## Pré-requisitos
- Docker 
- Extensão do VS Code Remote Container

## Abrindo o projeto no container
- Ao abrir o projeto no seu VS Code, clique no botão Reopen in Container no alert que aparecerá na parte inferior direita da sua tela

ou

- Clique no icone do Explorador Remoto no menu lateral esquerdo, selecione o container SGCGSSource e clique em Open Folder In Container

## Executando o projeto

Utilizando a Extensão Spring Boot Dashboard, aguarde a construção do projeto e clique em Run no projeto sgcgs

# Requisições HTTP

[Postman](/requests/postman.json)

[Thunder Client](/requests/thunder-collection.json)

# Application

## Website

O modelo para a Client HOME será feito baseado no seguinte template:

![Template](/frontend/website/assets/img/SGCSGhome.png)

Paleta de cores:

- Menu: #5B0679
- Botões: 
    - Roxo: #5B0679
    - Laranja: #F67804
- Cor de fundo: 
    - Nav: #FFFBFB
    - Card notícia: #FCF1E7
    - Card enquete e formulário: #FFFBFB 

