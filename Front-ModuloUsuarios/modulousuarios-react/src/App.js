import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import BarraNavegacion from './Componentes/BarraNavegacion';
import Encabezado from './Componentes/Encabezado';
import Contenido from './Componentes/Contenido';
import Login from './Componentes/Login';
import Estudiante from './Estudiante';
import Bibliotecario from './Bibliotecario';
import './Componentes/style.css';

function App() {
  const botonesPaginaPrincipal = [
    { label: 'Log in', link: '/login', color: '#007BFF' },
    { label: 'Estudiante', link: '/estudiante', color: '#007BFF' },
    { label: 'Bibliotecario', link: '/bibliotecario', color: '#007BFF' },
  ];

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route
            path="/"
            element={
              <>
                <BarraNavegacion botones={botonesPaginaPrincipal} />
                <Encabezado />
                <Contenido />
              </>
            }
          />
          <Route path="/login" element={<Login />} />
          <Route path="/estudiante" element={<Estudiante />} />
          <Route path="/bibliotecario" element={<Bibliotecario />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
