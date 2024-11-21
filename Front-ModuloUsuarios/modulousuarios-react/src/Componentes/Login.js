import React, { useState } from 'react';
import './style.css';
import ReCAPTCHA from 'react-google-recaptcha';
import Boton from './Boton';

function Login() {
  const [userAnswer, setUserAnswer] = useState('');
  const [captchaValido, setCaptchaValido] = useState(false);

  const manejarCaptcha = (value) => {
    if (value) {
      setCaptchaValido(true);
    }
  };

  // Validar respuesta del usuario
  const handleCaptchaInput = (e) => {
    const value = e.target.value;
    setUserAnswer(value);
  };

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
        <div className="captcha-container">
          <div className="captcha-container">
        <ReCAPTCHA
          sitekey="6LcD-YQqAAAAAKmisLvpnV7EHvNoN7w-ZDUYpJsA"
          onChange={manejarCaptcha}
        />
      </div>
        </div>
          <Boton 
          label="Ingresar" 
          type="submit"
          style={{
            backgroundColor: 'blue',
            color: 'white',
            padding: '10px 20px',
            border: 'none',
            borderRadius: '5px',
            cursor: captchaValido ? 'pointer' : 'not-allowed',
          }}
        />
      </form>
    </div>
  );
}

export default Login;