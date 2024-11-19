import React from 'react';
import Boton from './Boton';
import { useNavigate } from 'react-router-dom';
import './style.css';

function Navbar() {
  const navigate = useNavigate();

  const handleLogin = () => {
    navigate('/login');
  };

  const handleRegister = () => {
    navigate('/FormularioRegistro');
  };

  return (
    <nav className="navbar">
      <div className="navbar-center">
        <img src="logoColegio.png" alt="Logo" className="navbar-logo" />
        <div className="navbar-search">
          <input type="text" placeholder="Buscar..." />
          <Boton>🔍</Boton>
        </div>
      </div>
      <div className="navbar-buttons">
        <Boton
          label="Log in"
          onClick={handleLogin}
          style={{
            backgroundColor: '#007BFF',
            color: '#FFF',
            padding: '5px 10px',
            border: 'none',
            borderRadius: '5px',
            marginRight: '5px',
          }}
        />
        <Boton
          label="Registrarse"
          onClick={handleRegister}
          style={{
            backgroundColor: '#28A745',
            color: '#FFF',
            padding: '5px 10px',
            border: 'none',
            borderRadius: '5px',
          }}
        />
      </div>
    </nav>
  );
}

export default Navbar;
