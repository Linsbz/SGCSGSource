import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'tema',
    title: 'Cadastro de Tema',
    subtitle: 'Incluir Tema'
}

const baseUrl = 'http://localhost:3001/tema'
const initialState = {
    tema: { nome: '', valor: '', estado: '', imagem: ''},
}

export default class TemaCrud extends Component {

    state = { ...initialState }

    componentWillMount() {
        axios(baseUrl).then(resp => {
            this.setState({ list: resp.data })
        })
    }

    clear() {
        this.setState({ tema: initialState.tema })
    }

    updateField(event) {
        const tema = { ...this.state.tema }
        tema[event.target.name] = event.target.value
        this.setState({ tema })
    }

    renderForm() {
        return (
            <div className="form">
                <div className="row">
                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Nome</label>
                            <select className="form-control"
                                name="nome" value={this.state.tema.nome}
                                onChange={e => this.updateField(e)}>
                                <option>tema1</option>
                                <option>tema2</option>
                                <option>tema3</option>
                            </select>
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Estado</label>
                            <select className="form-control"
                                name="nome" value={this.state.tema.estado}
                                onChange={e => this.updateField(e)}>
                                <option>Ativado</option>
                                <option>Desativado</option>
                            </select>
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
                                value={this.state.tema.imagem}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite a url..." />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Valor</label>
                            <input type="number" className="form-control"
                                name="imagem"
                                value={this.state.tema.valor}
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