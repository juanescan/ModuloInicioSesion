import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import BarraNavegacion from './Componentes/BarraNavegacion';
import Encabezado from './Componentes/Encabezado';
import Contenido from './Componentes/Contenido';
import FormularioRegistro from './Componentes/FormularioRegistro';
import './Componentes/style.css';

function Bibliotecario() {
  const botonesBibliotecario = [
    { label: 'Registrar Estudiante', link: '/registrarEstudiante', color: '#007BFF' },
    { label: 'Salir', link: '/', color: '#28A745' }
  ];

  return (
      <div className="Bibliotecario">
        <Routes>
          <Route
            path="/"
            element={
              <>
                <BarraNavegacion titulo= {"BIBLIOTECARIO"} botones={botonesBibliotecario} />
                <Encabezado />
                <Contenido />
              </>
            }
          />
          <Route path="/registrarEstudiante" element={<FormularioRegistro />} />
        </Routes>
      </div>
  );
}

export default Bibliotecario;
