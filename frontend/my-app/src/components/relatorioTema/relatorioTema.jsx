import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";

const headerProps = {
    icon: 'relatorioTema',
    title: 'Relatorio Tema',
    subtitle: 'Relatorio Tema'
}

const baseUrl = 'http://localhost:3001/compratema/relatorio/findTotal/'
const initialState = {
    relatorioTema: { dataInicio: '', dataFim: '', resultado: ''},
    list: []
}

export default class relatorioTemaCrud extends Component {

    state = { ...initialState }

    componentWillMount() {
        axios(baseUrl).then(resp => {
            this.setState({ list: resp.data })
        })
    }

    clear() {
        this.setState({ relatorioTema: initialState.relatorioTema })
    }

    updateField(event) {
        const relatorioTema = { ...this.state.relatorioTema }
        relatorioTema[event.target.relatorioTema] = event.target.value
        this.setState({ relatorioTema })
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
                                value={this.state.relatorioTema.dataInicio}
                                onChange={e => this.updateField(e)}
                                 />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Data Fim</label>
                            <input type="date" className="form-control"
                                name="dataFim"
                                value={this.state.relatorioTema.dataFim}
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
                                value={this.state.relatorioTema.resultado}
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