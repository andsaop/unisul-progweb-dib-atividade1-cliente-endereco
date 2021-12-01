import React, { Component } from 'react';
import './styles.css';
import SearchClient from '../seach';

class App extends Component<{}> {
   constructor() {
     super({});
     this.state = {
      className: 'hidden'
   }
 }

  render() {
    return(
      <div>
        <header className="home-header"> <h1>Lista de clientes por cidade</h1></header>
        <SearchClient />
      </div>
    )
  }
}
export default App
