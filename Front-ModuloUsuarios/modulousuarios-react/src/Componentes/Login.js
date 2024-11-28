import React, { useState } from 'react';
import './style.css';
import ReCAPTCHA from 'react-google-recaptcha';
import Boton from './Boton';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [captchaValido, setCaptchaValido] = useState(false);

  const manejarCaptcha = (value) => {
    if (value) {
      setCaptchaValido(true);
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (captchaValido) {
      try {
        const response = await fetch('http://localhost:8081/usuario/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            nombreUsuario: username,
            contrasena: password,
          }),
        });

        if (response.ok) {
          const data = await response.json();
          // Guardar datos en localStorage
          localStorage.setItem('user', JSON.stringify({
            nombreUsuario: data.nombreUsuario,
            rol: data.rol,
            token: data.token,
          }));
          alert('Inicio de sesión exitoso');
        } else {
          alert('Error en el inicio de sesión' + response.status);
        }
      } catch (error) {
        console.error('Error:', error);
        alert('Error en el inicio de sesión' + error);
      }
    } else {
      alert('Por favor, complete el captcha');
    }
  };

  return (
      <div className="login-container">
        <h2>Iniciar Sesión</h2>
        <form onSubmit={handleSubmit} className="login-form">
          <label>
            Usuario:
            <input
                type="text"
                name="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required
            />
          </label>
          <label>
            Contraseña:
            <input
                type="password"
                name="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
            />
          </label>
          <div className="captcha-container">
            <ReCAPTCHA
                sitekey="6LcD-YQqAAAAAKmisLvpnV7EHvNoN7w-ZDUYpJsA"
                onChange={manejarCaptcha}
            />
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
