import React, { Component } from "react";
import axios from "axios";
import Main from "../template/Main";
import Select from 'react-select';


const headerProps = {
    icon: 'formulario',
    title: 'Cadastro de Formulario',
    subtitle: 'Incluir Formulario'
}

const baseUrl = 'http://localhost:3001/formulario'
const initialState = {
    formulario: { titulo: '', tipo: '', options: '', obr: ''},
}

export default class FormularioCrud extends Component {

    state = { ...initialState }

    componentWillMount() {
        axios(baseUrl).then(resp => {
            this.setState({ list: resp.data })
        })
    }

    clear() {
        this.setState({ formulario: initialState.formulario })
    }

    updateField(event) {
        const formulario = { ...this.state.formulario }
        formulario[event.target.name] = event.target.value
        this.setState({ formulario })
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
                                value={this.state.formulario.titulo}
                                onChange={e => this.updateField(e)}
                                placeholder="Digite o titulo..." />
                        </div>
                    </div>

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Tipo</label>
                            <select className="form-control"
                                name="tipo" value={this.state.formulario.tipo}
                                onChange={e => this.updateField(e)}>
                                <option>Radio</option>
                                <option>Select</option>
                            </select>
                        </div>
                    </div>
                </div>

                <br />

                <div className="row">

                    <div className="col-12 col-md-6">
                        <div className="form-group">
                            <label>Options</label>
                            <Select
                                defaultValue={["Lula", "Bolsonaro"]}
                                isMulti
                                name="options"
                                value = {this.state.formulario.options}
                                options={Options}
                                className="basic-multi-select"
                                classNamePrefix="select"
                            />
                        </div>

                        <div className="form-group">
                            <input type="radio" value={this.state.formulario.obr} name="gender" /> Campo Obrigatorio
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