CREATE TABLE
    usuario (
        id INTEGER NOT NULL,
        nome VARCHAR(40) NOT NULL,
        email VARCHAR(40) NOT NULL,
        senha VARCHAR(20) NOT NULL,
        tipo INTEGER NOT NULL,
        CONSTRAINT pk_usuario PRIMARY KEY(ID),
        CONSTRAINT ck_tipo CHECK (tipo IN(1, 2, 3))
    );

CREATE TABLE
    areas_anuncio (
        id INTEGER NOT NULL,
        nome VARCHAR(30) NOT NULL,
        CONSTRAINT pk_area_anuncio PRIMARY KEY(id)
    );

CREATE TABLE
    anuncio(
        id INTEGER NOT NULL,
        titulo VARCHAR(40) NOT NULL,
        link VARCHAR(100),
        imagem_quadrada VARCHAR(30),
        imagem_horizontal VARCHAR(30),
        imagem_vertical VARCHAR(30),
        CONSTRAINT pk_anuncio PRIMARY KEY(id)
    );

CREATE TABLE
    postagem_anuncio(
        id INTEGER NOT NULL,
        data_inicio DATE NOT NULL,
        data_fim DATE NOT NULL,
        areas_anuncio_p INTEGER NOT NULL,
        anuncio_p INTEGER NOT NULL,
        CONSTRAINT pk_postagem_anuncio PRIMARY KEY(id),
        CONSTRAINT fk_postagem_area FOREIGN KEY (areas_anuncio_p) REFERENCES areas_anuncio(id),
        CONSTRAINT fk_postagem_anuncio FOREIGN KEY (anuncio_p) REFERENCES anuncio(id)
    );

CREATE TABLE
    noticia(
        id INTEGER NOT NULL,
        titulo VARCHAR(40) NOT NULL,
        subtitulo VARCHAR(100) NOT NULL,
        conteudo TEXT NOT NULL,
        imagem VARCHAR(30) NOT NULL,
        link VARCHAR(100) NOT NULL,
        usuario INTEGER NOT NULL,
        CONSTRAINT pk_noticia PRIMARY KEY(id),
        CONSTRAINT fk_noticia_usuario FOREIGN KEY(usuario) REFERENCES usuario(id)
    );

CREATE TABLE
    postagem_noticia(
        id INTEGER NOT NULL,
        data_inicio DATE NOT NULL,
        data_fim DATE NOT NULL,
        destaque BOOLEAN NOT NULL,
        noticia INTEGER NULL,
        usuario INTEGER NULL,
        CONSTRAINT pk_postagem_noticia PRIMARY KEY(id),
        CONSTRAINT fk_postagem_noticia FOREIGN KEY(noticia) REFERENCES noticia(id),
        CONSTRAINT fk_postagem_usuario FOREIGN KEY(usuario) REFERENCES usuario(id)
    );

CREATE TABLE
    tema(
        id INTEGER NOT NULL,
        nome VARCHAR(30) NOT NULL,
        valor FLOAT NOT NULL,
        imagem VARCHAR(30) NOT NULL,
        estado BOOLEAN NOT NULL,
        CONSTRAINT pk_tema PRIMARY KEY(id)
    );

CREATE TABLE
    compra_tema(
        id INTEGER NOT NULL,
        data_compra DATE NOT NULL,
        valor FLOAT NOT NULL,
        id_tema INTEGER NOT NULL,
        id_usuario INTEGER NOT NULL,
        CONSTRAINT pk_compra_tema PRIMARY KEY(id),
        CONSTRAINT fk_compra_tema_tema FOREIGN KEY (id_tema) REFERENCES tema(id),
        CONSTRAINT fk_compra_tema_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
    );

CREATE TABLE
    enquete(
        id INTEGER NOT NULL,
        nome VARCHAR(30) NOT NULL,
        estado BOOLEAN NOT NULL,
        resposta_unica BOOLEAN NOT NULL,
        CONSTRAINT pk_enquete PRIMARY KEY(id)
    );

CREATE TABLE
    opcao_voto(
        id INTEGER NOT NULL,
        valor VARCHAR(30) NOT NULL,
        enquete_ov INTEGER NOT NULL,
        CONSTRAINT pk_opcao_voto PRIMARY KEY(id),
        CONSTRAINT fk_opcao_voto_enquete FOREIGN KEY (enquete_ov) REFERENCES enquete(id)
    );

CREATE TABLE
    voto(
        id INTEGER NOT NULL,
        data_voto DATE NOT NULL,
        opcao_voto INTEGER NOT NULL,
        enquete_v INTEGER NOT NULL,
        usuario_v INTEGER NOT NULL,
        CONSTRAINT pk_voto PRIMARY KEY(id),
        CONSTRAINT fk_voto_enquete FOREIGN KEY (enquete_v) REFERENCES enquete(id),
        CONSTRAINT fk_votoopcao_voto FOREIGN KEY (opcao_voto) REFERENCES opcao_voto(id),
        CONSTRAINT fk_voto_usuario FOREIGN KEY (usuario_v) REFERENCES usuario(id)
    );

CREATE TABLE
    formulario(
        id INTEGER NOT NULL,
        nome VARCHAR(30) NOT NULL,
        estado BOOLEAN NOT NULL,
        resposta_unica BOOLEAN NOT NULL,
        CONSTRAINT pk_formulario PRIMARY KEY(id)
    );

CREATE TABLE
    resposta_formulario (
        id INTEGER NOT NULL,
        data_resposta DATE NOT NULL,
        formulario_id INTEGER NOT NULL,
        usuario_id INTEGER NOT NULL,
        CONSTRAINT pk_resposta_formulario PRIMARY KEY (id),
        CONSTRAINT fk_resposta_formulario_formulario FOREIGN KEY (formulario_id) REFERENCES formulario(id),
        CONSTRAINT fk_resposta_formulario_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
    );

CREATE TABLE
    campo_formulario(
        id INTEGER NOT NULL,
        nome VARCHAR(30) NOT NULL,
        tipo VARCHAR(30) NOT NULL,
        valor VARCHAR(30) NOT NULL,
        campo_obrigatorio BOOLEAN NOT NULL,
        formulario_id INTEGER NOT NULL,
        CONSTRAINT pk_campo_formulario PRIMARY KEY(id),
        CONSTRAINT fk_campo_formulario_formulario FOREIGN KEY (formulario_id) REFERENCES formulario(id)
    );

CREATE TABLE
    resposta_campo(
        id INTEGER NOT NULL,
        valor VARCHAR(30) NOT NULL,
        resposta_formulario_id INTEGER NOT NULL,
        campo_formulario_id INTEGER NOT NULL,
        CONSTRAINT pk_resposta_campo PRIMARY KEY(id),
        CONSTRAINT fk_resposta_campo_resposta_formulario FOREIGN KEY(resposta_formulario_id) REFERENCES resposta_formulario(id),
        CONSTRAINT fk_resposta_campo_campo FOREIGN KEY(campo_formulario_id) REFERENCES campo_formulario(id)
    );
