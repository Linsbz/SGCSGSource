import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'opcaoVoto',
    title: 'Cadastrar Opção de Voto',
    subtitle: 'Adicionar uma nova opção de voto'
}

const baseUrl = 'http://localhost:3001/opcaoVoto'
const initialState = {
    opcaoVoto: { valor: '', enquete_ov: ''},
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
        this.setState({ user: initialState.opcaoVoto })
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
        const opcaoVoto = { ...this.state.opcaoVoto }
        opcaoVoto[event.target.opcaoVoto] = event.target.value
        this.setState({ opcaoVoto })
    }

    renderForm() {
        return (
            <div className="form">
                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Valor</label>
                            <input type="text" className="form-control"
                                name="valor"
                                value={this.state.opcaoVoto.valor}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o valor do campo..." />
                        </div>
                    </div>
                </div>

                <br />

                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Enquete</label>
                            <select className="form-control"
                                name="estado" value={this.state.opcaoVoto.estado}
                                onChange={e => this.updateField(e)}>
                                <option>Qual o melhor time do Rio?</option> {/*alterar isso*/}
                                <option>Qual a sua área em TI?</option> {/*alterar isso*/}
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