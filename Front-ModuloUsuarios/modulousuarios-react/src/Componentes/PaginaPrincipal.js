import React from 'react';
import Boton from './Boton';

function PaginaPrincipal() {
  const handleLogin = () => {
    alert("Log in");
  };

  const handleRegister = () => {
    alert("Registrarse");
  };

  return (
    <div style={{ display: 'flex', gap: '10px' }}>
      <Boton label="Log in" onClick={handleLogin} style={{ backgroundColor: '#007BFF', color: '#FFF', padding: '10px 20px', border: 'none', borderRadius: '5px' }} />
      <Boton label="Registrarse" onClick={handleRegister} style={{ backgroundColor: '#28A745', color: '#FFF', padding: '10px 20px', border: 'none', borderRadius: '5px' }} />
    </div>
  );
}

export default PaginaPrincipal;
