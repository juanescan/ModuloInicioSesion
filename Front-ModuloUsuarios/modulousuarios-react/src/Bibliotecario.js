import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import BarraNavegacion from './Componentes/BarraNavegacion';
import Encabezado from './Componentes/Encabezado';
import Contenido from './Componentes/Contenido';
import './Componentes/style.css';
import FormularioRegistro from './Componentes/FormularioRegistro';

function Bibliotecario() {
  const botonesBibliotecario = [
    { label: 'Registrar estudiante', link: '/FormularioRegistro', color: '#28A745' },
    { label: 'Salir', link: '/App', color: '#28A745' },
  ];

  return (
    <Router>
      <div className="Bibliotecario">
        <Routes>
          <Route
            path="/"
            element={
              <>
                <BarraNavegacion titulo="BIBLIOTECARIO" botones={botonesBibliotecario} />
                <Encabezado />"
                <Contenido />
              </>
            }
          />
          <Route path="/FormularioRegistro" element={<FormularioRegistro />} />
          <Route path="/App" element={<App />} />
        </Routes>
      </div>
    </Router>
  );
}

export default Bibliotecario;
