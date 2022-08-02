import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'compraTema',
    title: 'Compra de Tema',
    subtitle: 'Compra Tema'
}

const baseUrl = 'http://localhost:3001/compratema'
const initialState = {
    compraTema: { tema: '', cartao:'', seguranca:''},
    list: []
}

export default class CompraTemaCrud extends Component {

    state = { ...initialState }

    componentWillMount() {
        axios(baseUrl).then(resp => {
            this.setState({ list: resp.data })
        })
    }

    clear() {
        this.setState({ user: initialState.user })
    }

    updateField(event) {
        const compraTema = { ...this.state.compraTema }
        compraTema[event.target.name] = event.target.value
        this.setState({ compraTema })
    }

    renderForm() {
        return (
            <div className="form">
                <div className="row">
                    <div className="col-12 col-md-12">
                        <div className="form-group">
                            <label>Temas</label>
                            <select className="form-control"
                                name="nome" value={this.state.compraTema.tema}
                                onChange={e => this.updateField(e)}>
                                <option>tema4</option>
                                <option>tema5</option>
                                <option>tema6</option>
                            </select>
                        </div>
                    </div>

                </div>

                <br />

                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Numero do cartão</label>
                            <input type="number" className="form-control"
                                name="imagem"
                                value={this.state.compraTema.cartao}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o numero..." />
                        </div>
                    </div>
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Numero de segurança</label>
                            <input type="number" className="form-control"
                                name="imagem"
                                value={this.state.compraTema.seguranca}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o numero..." />
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