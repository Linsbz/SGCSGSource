import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'anuncio',
    title: 'Cadastro de Anuncio',
    subtitle: 'Incluir Anuncio'
}

const baseUrl = 'http://localhost:3001/anuncios'
const initialState = {
    anuncio: { titulo: '', link: '', imagem: '', imagemPos: ''},
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
        this.setState({ anuncio: initialState.anuncio })
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
        const anuncio = { ...this.state.anuncio }
        anuncio[event.target.name] = event.target.value
        this.setState({ anuncio })
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
                                value={this.state.anuncio.titulo}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o titulo..." />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Link</label>
                            <input type="text" className="form-control"
                                name="link"
                                value={this.state.anuncio.link}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o link..." />
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
                                value={this.state.anuncio.imagem}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite a url..." />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Posicao Imagem</label>
                            <select className="form-control"
                                name="imagemPos" value={this.state.tema.imagemPos}
                                onChange={e => this.updateField(e)}>
                                <option>local1</option>
                                <option>local2</option>
                                <option>local3</option>
                            </select>
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