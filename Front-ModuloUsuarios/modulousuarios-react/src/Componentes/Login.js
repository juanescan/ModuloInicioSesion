import React from 'react';
import './style.css';

function Login() {
  const handleSubmit = (event) => {
    event.preventDefault();
    alert('Inicio de sesión exitoso');
  };

  return (
    <div className="login-container">
      <h2>Iniciar Sesión</h2>
      <form onSubmit={handleSubmit} className="login-form">
        <label>
          Usuario:
          <input type="text" name="username" required />
        </label>
        <label>
          Contraseña:
          <input type="password" name="password" required />
        </label>
        <button type="submit">Ingresar</button>
      </form>
    </div>
  );
}

export default Login;
