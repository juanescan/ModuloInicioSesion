import React from 'react';
import Boton from './Boton';
import { useNavigate } from 'react-router-dom';
import './style.css';

function BarraNavegacion({ titulo, botones }) {
  const navigate = useNavigate();

  return (
    <nav className="navbar">
      {/* Logo y buscador en la misma línea */}
      <div className="navbar-left">
        <img src="logoColegio.png" alt="Logo" className="navbar-logo" />
        <div className="navbar-search">
          <input type="text" placeholder="Buscar..." className="navbar-search-input" />
          <Boton
            label="🔍"
            onClick={() => console.log('Búsqueda realizada')}
            style={{
              backgroundColor: '#007BFF',
              color: '#FFF',
              padding: '5px',
              border: 'none',
              borderRadius: '5px',
              marginLeft: '5px',
            }}
          />
        </div>
      </div>

      {/* Título centrado */}
      <div className="navbar-title">
        <h1>{titulo}</h1>
      </div>

      {/* Botones a la derecha */}
      <div className="navbar-buttons">
        {botones.map((boton, index) => (
          <Boton
            key={index}
            label={boton.label}
            onClick={() => navigate(boton.link)}
            style={{
              backgroundColor: boton.color || '#007BFF',
              color: '#FFF',
              padding: '5px 10px',
              border: 'none',
              borderRadius: '5px',
              marginRight: '5px',
            }}
          />
        ))}
      </div>
    </nav>
  );
}

export default BarraNavegacion;
