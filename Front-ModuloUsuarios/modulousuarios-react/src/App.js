import React from 'react';
import BarraNavegacion from './Componentes/BarraNavegacion';
import Encabezado from './Componentes/Encabezado';
import Contenido from './Componentes/Contenido';
import './Componentes/style.css';

function App() {
  return (
    <div className="App">
      <BarraNavegacion />
      <Encabezado />
      <Contenido />
    </div>
  );
}

export default App;
