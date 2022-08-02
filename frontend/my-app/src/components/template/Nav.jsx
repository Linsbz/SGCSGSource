import './Nav.css'
import React from 'react'
import { Link } from 'react-router-dom'

function Nav(props) {
    return (
        <aside className="menu-area">
            <nav className="menu">
                <span>Requisitos Funcionais</span>
                <Link to="/">
                    <i className="fa fa-user"></i> Home
                </Link>
                <Link to="/tema">
                    <i className="fa fa-flag"></i> Tema
                </Link>
                <Link to="/enquete">
                    <i className="fa fa-group"></i> Cadastrar Enquete
                </Link>
                <Link to="/opcaoVoto">
                    <i className="fa fa-group"></i> Cadastrar Opção de Voto
                </Link>
                <Link to="/formulario">
                    <i className="fa fa-key"></i> Cadastrar Formulario
                </Link>
                <Link to="/Anuncio">
                    <i className="fa fa-user"></i> Cadastrar Anuncio
                </Link>
                <Link to="/crudNoticia">
                    <i className="fa fa-question"></i> Cadastrar Noticia
                </Link>
                <span>Processos de Negócio</span>
                <Link to="/postagemAnuncio">
                    <i className="fa fa-lock"></i> Postagem Anuncio
                </Link>
                <Link to="/areaAnuncio">
                    <i className="fa fa-lock"></i> Postagem Anuncio
                </Link>
                <Link to="/compraTema">
                    <i className="fa fa-wifi"></i> Compra Tema
                </Link>
                <Link to="/Noticia">
                    <i className="fa fa-share"></i> Postagem Noticia
                </Link>
                <Link to="/export">
                    <i className="fa fa-share"></i> Postagem Formulario
                </Link>
                <Link to="/voto">
                    <i className="fa fa-group"></i> Voto
                </Link>
                <span>Relatórios</span>
                <Link to="/relatorioAnuncio">
                    <i className="fa fa-home"></i> Anuncio
                </Link>
                <Link to="/relatorioTema">
                    <i className="fa fa-home"></i> Tema
                </Link>
                <Link to="/relatorioNoticia">
                    <i className="fa fa-home"></i> Noticia
                </Link>
                <Link to="/relatorioVotos">
                    <i className="fa fa-group"></i> Total de votos por enquete
                </Link>
                <Link to="/relatorioFormulario">
                    <i className="fa fa-home"></i> Formulario
                </Link>
            </nav>
        </aside>
    )
}

export default Nav;
