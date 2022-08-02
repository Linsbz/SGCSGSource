import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'postagemAnuncio',
    title: 'Cadastro de postagem de noticia',
    subtitle: 'Incluir postagem de noticia'
}

const baseUrl = 'http://localhost:3001/postagem-noticias'
const initialState = {
    postagemNoticia: { dataInicio: '', dataFim: '', destaque: ''},
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
        this.setState({ postagemNoticia: initialState.postagemNoticia })
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
        const postagemNoticia = { ...this.state.postagemNoticia }
        postagemNoticia[event.target.name] = event.target.value
        this.setState({ postagemNoticia })
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
                                value={this.state.postagemNoticia.dataInicio}
                                onChange={e => this.updateField(e)}
                                 />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Data Fim</label>
                            <input type="date" className="form-control"
                                name="dataFim"
                                value={this.state.postagemNoticia.dataFim}
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
                                name="nome" value={this.state.postagemNoticia.destaque}
                                onChange={e => this.updateField(e)}>
                                <option>No1</option>
                                <option>No2</option>
                                <option>No3</option>
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