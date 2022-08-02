import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'noticia',
    title: 'Cadastro de Notícia',
    subtitle: 'Incluir Notícia'
}

const baseUrl = 'http://localhost:3001/anuncios'
const initialState = {
    noticia: { titulo: '', subtitulo: '', imagem: '', conteudo: ''},
    list: []
}

export default class UserCrud extends Component {

    state = { ...initialState }

    componentWillMount() {
        axios(baseUrl).then(resp => {
            this.setState({ list: resp.data })
        })
    }

    clear() {
        this.setState({ noticia: initialState.noticia })
    }

    // save() {
    //     const user = this.state.user
    //     const method = user.id ? 'put' : 'post'
    //     const url = user.id ? `${baseUrl}/${user.id}` : baseUrl

    //     axios[method](url, user)
    //         .then(resp => {
    //             const list = this.getUpdatedList(resp.data)
    //             this.setState({ user: initialState.user, list })
    //         })
    // }

    updateField(event) {
        const noticia = { ...this.state.noticia }
        noticia[event.target.name] = event.target.value
        this.setState({ noticia })
    }

    renderForm() {
        return (
            <div className="form">
                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Titulo</label>
                            <input type="text" className="form-control"
                                name="titulo"
                                value={this.state.noticia.titulo}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o titulo..." />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>subtitulo</label>
                            <input type="text" className="form-control"
                                name="subtitulo"
                                value={this.state.noticia.subtitulo}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o subtitulo..." />
                        </div>
                    </div>
                </div>

                <br />

                <div className="row">
                <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>URL da imagem</label>
                            <input type="text" className="form-control"
                                name="imagem"
                                value={this.state.noticia.imagem}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite a url..." />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Conteúdo</label>
                            <input type="text" className="form-control"
                                name="imagem"
                                value={this.state.tema.conteudo}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite..." />
                        </div>
                    </div>
                </div>

                <br /><br />

                <div className="row">
                    <div className="col-12 d-flex justify-content-end">
                        <button className="btn btn-primary">
                            Confirmar
                        </button>

                        <button className="btn btn-secondary ms-2"
                            onClick={e => this.clear(e)}>
                            Cancelar
                        </button>
                    </div>
                </div>
            </div>
        )
    }

    render() {
        return (
            <Main {...headerProps}>
                {this.renderForm()}
            </Main>
        )
    }
}