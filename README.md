# Sistema de Gerenciamento de Conteúdo para Sites Genéricos - SGCSG

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
![IDE](https://img.shields.io/badge/Visual_Studio_Code-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

![BUILD](http://ForTheBadge.com/images/badges/built-with-love.svg)
![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JAVA](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![REACT](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![SPRING](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![HIBERNATE](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
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

