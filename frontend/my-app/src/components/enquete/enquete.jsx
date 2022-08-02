import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'enquete',
    title: 'Cadastrar Enquete',
    subtitle: 'Adicionar uma nova enquete'
}

const baseUrl = 'http://localhost:3001/users'
const initialState = {
    enquete: { nome: '', estado: '', respostaUnica: ''},
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
        this.setState({ enquete: initialState.enquete })
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
        const enquete = { ...this.state.enquete }
        enquete[event.target.name] = event.target.value
        this.setState({ enquete })
    }

    renderForm() {
        return (
            <div className="form">
                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Nome</label>
                            <input type="text" className="form-control"
                                name="nome"
                                value={this.state.enquete.nome}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o nome da enquete..." />
                        </div>
                    </div>
                </div>

                <br />

                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Estado</label>
                            <select className="form-control"
                                name="estado" value={this.state.enquete.estado}
                                onChange={e => this.updateField(e)}>
                                <option>Aberta</option>
                                <option>Fechada</option>
                            </select>
                        </div>
                    </div>
                </div>

                <br />

                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Aceita resposta única?</label>
                            <select className="form-control"
                                name="respostaUnica" value={this.state.enquete.respostaUnica}
                                onChange={e => this.updateField(e)}>
                                <option>Sim</option>
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