import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'postagemAnuncio',
    title: 'Cadastro de postagem de anuncio',
    subtitle: 'Incluir postagem de anuncio'
}

const baseUrl = 'http://localhost:3001/postagem-anuncios'
const initialState = {
    postagemAnuncio: { dataInicio: '', dataFim: '', Anuncio: '', areaAnuncio: ''},
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
        this.setState({ postagemAnuncio: initialState.postagemAnuncio })
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
        const postagemAnuncio = { ...this.state.postagemAnuncio }
        postagemAnuncio[event.target.name] = event.target.value
        this.setState({ postagemAnuncio })
    }

    renderForm() {
        return (
            <div className="form">
                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Data Inicio</label>
                            <input type="date" className="form-control"
                                name="dataInicio"
                                value={this.state.postagemAnuncio.dataInicio}
                                onChange={e => this.updateField(e)}
                                 />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Data Fim</label>
                            <input type="date" className="form-control"
                                name="dataFim"
                                value={this.state.postagemAnuncio.dataFim}
                                onChange={e => this.updateField(e)}
                                 />
                        </div>
                    </div>
                </div>

                <br />

                <div className="row">
                    <div className="col-12 col-md-12">
                        <div className="form-group">
                            <label>Temas</label>
                            <select className="form-control"
                                name="nome" value={this.state.postagemAnuncio.Anuncio}
                                onChange={e => this.updateField(e)}>
                                <option>Anuncio1</option>
                                <option>Anuncio2</option>
                                <option>Anuncio3</option>
                            </select>
                        </div>
                    </div>

                    <div className="col-12 col-md-12">
                        <div className="form-group">
                            <label>Temas</label>
                            <select className="form-control"
                                name="nome" value={this.state.postagemAnuncio.areaAnuncio}
                                onChange={e => this.updateField(e)}>
                                <option>Area Anuncio 1</option>
                                <option>Area Anuncio 2</option>
                                <option>Area Anuncio 3</option>
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