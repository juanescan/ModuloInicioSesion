import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import BarraNavegacion from './Componentes/BarraNavegacion';
import Encabezado from './Componentes/Encabezado';
import Contenido from './Componentes/Contenido';
import './Componentes/style.css';

function Estudiante() {
  const botonesEstudiante = [
    { label: 'Salir', link: '/App', color: '#28A745' },
  ];

  return (
    <Router>
      <div className="Estudiante">
        <Routes>
          <Route
            path="/"
            element={
              <>
                <BarraNavegacion titulo="ESTUDIANTE" botones={botonesEstudiante} />
                <Encabezado />"
                <Contenido />
              </>
            }
          />
          <Route path="/App" element={<App />} />
        </Routes>
      </div>
    </Router>
  );
}

export default Estudiante;
