import React from "react";
import { Switch, Route, Redirect } from 'react-router';

import Tema from "../components/tema/tema"
import compraTema from "../components/compraTema/compraTema"
import relatorioTema from "../components/relatorioTema/relatorioTema"
import Anuncio from "../components/anuncio/anuncio"
import areaAnuncio from "../components/areaAnuncio/areaAnuncio"
import postagemAnuncio from "../components/postagemAnuncio/postagemAnuncio"
import relatorioAnuncio from "../components/relatorioAnuncio/relatorioAnuncio"
import enquete from "../components/enquete/enquete"
import opcaoVoto from "../components/opcaoVoto/opcaoVoto"
import voto from "../components/voto/voto"
import relatorioVotos from "../components/relatorioVotos/relatorioVotos"
import formulario from "../components/Formulario/Formulario"
import relatorioFormulario from "../components/relatorioFormulario/relatorioFormulario"
import crudNoticia from "../components/noticia/noticia"
import Noticia from "../components/postagemNoticia/postagemNoticia"
import relatorioNoticia from "../components/relatorioNoticia/relatorioNoticia"




function Routes (props) {
    return (
        <Switch>
        <Route exact path='/'/>
        <Route path='/Tema' component={Tema} /> 
        <Route path='/compraTema' component={compraTema} /> 
        <Route path='/relatorioTema' component={relatorioTema} /> 
        <Route path='/Anuncio' component={Anuncio} /> 
        <Route path='/postagemAnuncio' component={postagemAnuncio} /> 
        <Route path='/areaAnuncio' component={areaAnuncio} /> 
        <Route path='/relatorioAnuncio' component={relatorioAnuncio} /> 
        <Route path='/enquete' component={enquete} /> 
        <Route path='/opcaoVoto' component={opcaoVoto} /> 
        <Route path='/voto' component={voto} /> 
        <Route path='/relatorioVotos' component={relatorioVotos} /> 
        <Route path='/formulario' component={formulario} /> 
        <Route path='/relatorioFormulario' component={relatorioFormulario} /> 
        <Route path='/crudNoticia' component={crudNoticia} /> 
        <Route path='/Noticia' component={Noticia} /> 
        <Route path='/relatorioNoticia' component={relatorioNoticia} /> 

        </Switch>
    )
}

export default Routes;
