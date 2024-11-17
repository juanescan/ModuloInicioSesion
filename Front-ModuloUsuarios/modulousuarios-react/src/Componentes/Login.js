import React, { useState } from 'react';
import './style.css';

function Login() {
  const [captchaQuestion, setCaptchaQuestion] = useState('');
  const [captchaAnswer, setCaptchaAnswer] = useState('');
  const [userAnswer, setUserAnswer] = useState('');
  const [isCaptchaValid, setIsCaptchaValid] = useState(false);

  // Generar una nueva pregunta CAPTCHA
  const generateCaptcha = () => {
    const num1 = Math.floor(Math.random() * 10) + 1;
    const num2 = Math.floor(Math.random() * 10) + 1;
    setCaptchaQuestion(`${num1} + ${num2}`);
    setCaptchaAnswer((num1 + num2).toString());
    setUserAnswer('');
    setIsCaptchaValid(false);
  };

  // Validar respuesta del usuario
  const handleCaptchaInput = (e) => {
    const value = e.target.value;
    setUserAnswer(value);
    setIsCaptchaValid(value === captchaAnswer);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if (!isCaptchaValid) {
      alert('Por favor resuelve correctamente el CAPTCHA');
      return;
    }
    alert('Inicio de sesión exitoso');
  };

  // Generar CAPTCHA al cargar el componente
  React.useEffect(() => {
    generateCaptcha();
  }, []);

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
          <label>
            Resuelve: {captchaQuestion}
            <input
              type="text"
              value={userAnswer}
              onChange={handleCaptchaInput}
              required
            />
          </label>
        </div>
        <button type="submit" disabled={!isCaptchaValid}>
          Ingresar
        </button>
      </form>
    </div>
  );
}

export default Login;
