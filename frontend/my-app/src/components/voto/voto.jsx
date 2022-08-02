import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'user',
    title: 'Cadastrar Voto',
    subtitle: 'Adicionar um novo voto'
}

const baseUrl = 'http://localhost:3001/users'
const initialState = {
    voto: { dataVoto: '', enquete: '', op1: '', op2: '', op3: '', op4: '' },
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
        this.setState({ user: initialState.voto })
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
        const voto = { ...this.state.voto }
        voto[event.target.voto] = event.target.value
        this.setState({ voto })
    }

    renderForm() {
        return (
            <div className="form">
                <div className="row">
                <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Data do voto</label>
                            <input type="date" className="form-control"
                                name="dataInicio"
                                value={this.state.voto.dataVoto}
                                onChange={e => this.updateField(e)}
                                disabled />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Enquete</label>
                            <select className="form-control"
                                name="estado" value={this.state.voto.enquete}
                                onChange={e => this.updateField(e)}>
                                <option>Qual o melhor time do Rio?</option>
                            </select>
                        </div>
                    </div>
                </div>

                <br />

                <div className="row">
                    <div className="col-12 col-md-6">
                        <label>Qual o melhor time do Rio?</label>
                        <div className="form-check">                            
                            <input type="radio" className="form-check-input"
                                name="op1"
                                id="op1"
                                value={this.state.voto.op1}
                                onChange={e => this.updateField(e)} />
                            <label className="form-check-label" for="op1">Flamengo</label>
                        </div>

                        <div className="form-check">
                            <input type="radio" className="form-check-input"
                                name="op2"
                                id="op2"
                                value={this.state.voto.op2}
                                onChange={e => this.updateField(e)} />
                            <label className="form-check-label" for="op2">Fluminense</label>
                        </div>

                        <div className="form-check">
                            <input type="radio" className="form-check-input"
                                name="op3"
                                id="op3"
                                value={this.state.voto.op3}
                                onChange={e => this.updateField(e)} />
                            <label className="form-check-label" for="op3">Vasco</label>
                        </div>

                        <div className="form-check">
                            <input type="radio" className="form-check-input"
                                name="op4"
                                id="op4"
                                value={this.state.voto.op4}
                                onChange={e => this.updateField(e)} />
                            <label className="form-check-label" for="op4">Botafogo</label>
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