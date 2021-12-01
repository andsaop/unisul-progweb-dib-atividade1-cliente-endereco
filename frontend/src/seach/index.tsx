import React, { Component } from 'react';
import './styles.css';
import Button from 'react-bootstrap/Button'
import Modal from 'react-bootstrap/Modal'
import Form from 'react-bootstrap/Form'
import axios from 'axios';

type Props = {
};

interface Cliente {
  nome: string
  id: number
}

type State = {
  city: string
  clients: Cliente[]
  showModal: any
}

class SearchClient extends Component<Props, State> {
   constructor(props: Props) {
     super(props);
     
     this.state = {
       city: '',
       clients: [],
       showModal: {active:false, message:''}
     }
 }

 handleSearchClients() {
  if (this.state.city === '') {
    this.setState({...this.state, showModal:{active:true, message:'Cidade é um campo obrigatório!'}})
    return
  }
  
  axios.defaults.baseURL = 'http://myurl';
  axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
  axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
  axios.get(`http://localhost:8080/unisul/enderecocl?cidade=${this.state.city}`)
  .then(res => {
    this.setState({...this.state, clients:res.data.clientes})
  })
  .catch((err) => {
    console.log(err)
    this.setState({...this.state, showModal:{active:true, message:`Nenhum cliente cadastro para a cidade ${this.state.city}`}, city: ''})
  })
 }

 handleNewSearch() {
  this.setState({...this.state, clients:[], city: ''})
 }

 handleChangeCity(value:string) {
  this.setState({...this.state, city:value})
 }

 handleClose() {
  this.setState({...this.state, showModal:{active:false, message:''}})
 }

  render() {
    return(
    <div className="formsearch">
      <div>
      { this.state.clients.length === 0 && (
        <Form id="form-city">
          <Form.Group controlId="formBasicName" bsPrefix="size-large">
            <Form.Label>Nome da cidade*:</Form.Label>
            <Form.Control type="text" value={this.state.city}  onChange={(e) => this.handleChangeCity(e.target.value)}/>
          </Form.Group>
          <div className="btn-search">
            <Button 
              variant="dark" 
              size="lg" 
              block
              onClick={() => this.handleSearchClients()}
            >
              Buscar
            </Button>
          </div>
        </Form>
      )}
      { this.state.clients.length > 0 && (
        <div>
          <div className="text-sign">
            <div className="city-name">{this.state.city}</div>
            <table className="table">
              <thead >
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Name</th>
                </tr>
              </thead>
              {this.state.clients.map((client) => (
                <tbody>
                  <tr>
                    <th scope="row">{client.id}</th>
                    <td>{client.nome}</td>
                  </tr>
                </tbody>
              ))}
            </table>
          </div>
          <div className="btn-clear">
            <Button 
              variant="dark" 
              size="lg" 
              block
              onClick={() => this.handleNewSearch()}
            >
              Voltar
            </Button>
          </div>
        </div>
      )}
      </div>
      <Modal show={this.state.showModal.active} onHide={() => this.handleClose()}>
          <Modal.Header closeButton />
          <Modal.Body>
            <p>{this.state.showModal.message}</p>
          </Modal.Body>
      </Modal>
    </div> 
    )
  }
}

export default SearchClient
