import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'relatorioFormulario',
    title: 'Relatorio Formulario',
    subtitle: 'Relatorio Formulario'
}

const baseUrl = 'http://localhost:3001/formularios/'
const initialState = {
    relatorioFormulario: { dataInicio: '', dataFim: '', resultado: ''},
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
        this.setState({ user: initialState.relatorioFormulario })
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
        const relatorioFormulario = { ...this.state.relatorioFormulario }
        relatorioFormulario[event.target.relatorioFormulario] = event.target.value
        this.setState({ relatorioFormulario })
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
                                value={this.state.relatorioFormulario.dataInicio}
                                onChange={e => this.updateField(e)}
                                 />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Data Fim</label>
                            <input type="date" className="form-control"
                                name="dataFim"
                                value={this.state.relatorioFormulario.dataFim}
                                onChange={e => this.updateField(e)}
                                 />
                        </div>
                    </div>
                </div>

                <br />

                <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Resultado</label>
                            <input type="number" className="form-control"
                                name="resultado"
                                value={this.state.relatorioFormulario.resultado}
                                onChange={e => this.updateField(e)}
                                 />
                        </div>
                    </div>

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