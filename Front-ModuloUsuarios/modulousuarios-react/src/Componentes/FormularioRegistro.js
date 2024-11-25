import React, { useState, useEffect } from 'react';
import CampoTexto from './CampoTexto';
import ListaDesplegable from './ListaDesplegable';
import ReCAPTCHA from 'react-google-recaptcha';
import Boton from './Boton';
import { useNavigate } from 'react-router-dom';
import './style.css';

const FormularioRegistro = () => {
  const [formulario, setFormulario] = useState({
    codigoEstudiante: '',
    nombreEstudiante: '',
    numeroDocumentoEstudiante: '',
    tipoDocumentoEstudiante: '',
    nombreResponsable: '',
    documentoResponsable: '',
    lugarExpedicionResponsable: '',
    telefonoResponsable: '',
    correoResponsable: '',
    curso: '',
    grado: '',
    contrasena: '',
    confirmacionContrasena: '',
  });
  const [opcionesCurso, setOpcionesCurso] = useState([]);
  const [errores, setErrores] = useState({
    correoResponsable: '',
  });
  const [captchaValido, setCaptchaValido] = useState(false);

  const cursosPorPrefijo = {
    Prejardín:['Pre-jardín'],
    Jardín: ['Jardín'],
    Transición: ['Transición'],
    Primero: ['101'],
    Segundo: ['201', '202'],
    Tercero: ['301'],
    Cuarto: ['401', '402'],
    Quinto: ['501', '502'],
    Sexto:  ['601'],
    Séptimo: ['701', '702'],
    Octavo: ['801', '802'],
    Noveno: ['901', '902', '903'],
    Décimo: ['1001', '1002', '1003'],
    Once: ['1101', '1102', '1103'],
  };

  useEffect(() => {
    const gradoSeleccionado = formulario.grado;
    setOpcionesCurso(cursosPorPrefijo[gradoSeleccionado] || []);
  }, [formulario.grado]);

  const manejarCambio = (e) => {
    const { name, value } = e.target;
    setFormulario({ ...formulario, [name]: value });

    if (name === 'correoResponsable') {
      validarCorreo(value);
    }
  };

  const manejarEnvio = (e) => {
    e.preventDefault();

    if (!captchaValido) {
      alert('Por favor, completa el CAPTCHA');
      return;
    }

    if (formulario.contrasena !== formulario.confirmacionContrasena) {
      alert('Las contraseñas no coinciden');
      return;
    }

    if (!validarCorreo(formulario.correoResponsable)) {
      alert('El correo electrónico no es válido. Por favor, ingresa un correo válido.');
      return;
    }

    alert('Formulario enviado correctamente');
    console.log(formulario);
  };

  const todosCamposLlenos = () => {
    return Object.values(formulario).every((campo) => campo !== '');
  };
  function NavBar(){
    const navigate = useNavigate();
  const handlePrincipal = () => {
    navigate('/PaginaPrincipal');
  };
  }
  const validarCorreo = (correo) => {
    const regexCorreo = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!regexCorreo.test(correo)) {
      setErrores((prevErrores) => ({
        ...prevErrores,
        correoResponsable: 'El correo electrónico no es válido',
      }));
      return false;
    } else {
      setErrores((prevErrores) => ({
        ...prevErrores,
        correoResponsable: '',
      }));
      return true;
    }
  };

  const manejarCaptcha = (value) => {
    if (value) {
      setCaptchaValido(true);
    }
  };

  return (
    <form className="form-container" onSubmit={manejarEnvio}>
      <div className="titulo-contenedor">
        <img
          src="logoColegio.png"
          alt="Imagen izquierda"
          className="titulo-imagen"
        />
        <h2 className="titulo-texto">Registro de Estudiante</h2>
        <img
          src="logoColegio.png"
          alt="Imagen derecha"
          className="titulo-imagen"
        />
      </div>
      <CampoTexto
        label="Código del Estudiante"
        name="codigoEstudiante"
        value={formulario.codigoEstudiante}
        onChange={manejarCambio}
        required
      />
      <CampoTexto
        label="Nombre del Estudiante"
        name="nombreEstudiante"
        value={formulario.nombreEstudiante}
        onChange={manejarCambio}
        required
      />
      <CampoTexto
        label="Número de Documento del Estudiante"
        name="numeroDocumentoEstudiante"
        value={formulario.numeroDocumentoEstudiante}
        onChange={manejarCambio}
        required
      />
      <ListaDesplegable
        label="Tipo de Documento"
        name="tipoDocumentoEstudiante"
        opciones={[ 'REGISTRO CIVIL', 'TI', 'CÉDULA'
        ]}
        value={formulario.tipoDocumentoEstudiante}
        onChange={manejarCambio}
        required
      />
      <CampoTexto
        label="Nombre del Responsable Económico"
        name="nombreResponsable"
        value={formulario.nombreResponsable}
        onChange={manejarCambio}
        required
      />
      <CampoTexto
        label="Documento del Responsable Económico"
        name="documentoResponsable"
        value={formulario.documentoResponsable}
        onChange={manejarCambio}
        required
      />
      <CampoTexto
        label="Lugar de Expedición"
        name="lugarExpedicionResponsable"
        value={formulario.lugarExpedicionResponsable}
        onChange={manejarCambio}
        required
      />
      <CampoTexto
        label="Teléfono del Responsable Económico"
        name="telefonoResponsable"
        value={formulario.telefonoResponsable}
        onChange={manejarCambio}
        required
      />
      <CampoTexto
        label="Correo del Responsable Económico"
        name="correoResponsable"
        value={formulario.correoResponsable}
        onChange={manejarCambio}
        required
        type="email"
      />
      {errores.correoResponsable && (
        <div className="advertencia-correo">{errores.correoResponsable}</div>
      )}
      <ListaDesplegable
        label="Grado"
        name="grado"
        opciones={[ 'Prejardín', 'Jardín', 'Transición',
          'Primero', 'Segundo', 'Tercero', 'Cuarto', 'Quinto',
          'Sexto', 'Séptimo', 'Octavo', 'Noveno', 'Décimo', 'Once',
        ]}
        value={formulario.grado}
        onChange={manejarCambio}
        required
      />
      {opcionesCurso.length > 0 && (
        <ListaDesplegable
          label="Curso"
          name="curso"
          opciones={opcionesCurso}
          value={formulario.curso}
          onChange={manejarCambio}
          required
        />
      )}
      <CampoTexto
        label="Contraseña"
        name="contrasena"
        type="password"
        value={formulario.contrasena}
        onChange={manejarCambio}
        required
      />
      <CampoTexto
        label="Confirmación de Contraseña"
        name="confirmacionContrasena"
        type="password"
        value={formulario.confirmacionContrasena}
        onChange={manejarCambio}
        required
      />
      {/* Agregar el componente de reCAPTCHA */}
      <div className="captcha-container">
        <ReCAPTCHA
          sitekey="6LcD-YQqAAAAAKmisLvpnV7EHvNoN7w-ZDUYpJsA"
          onChange={manejarCaptcha}
        />
      </div>
      <div className="form-buttons">
      <Boton 
          label="Registrar" 
          onClick={handlePrincipal}
          disabled={!todosCamposLlenos() || !captchaValido}
          style={{
            backgroundColor: 'blue',
            color: 'white',
            padding: '10px 20px',
            border: 'none',
            borderRadius: '5px',
            cursor: todosCamposLlenos() && captchaValido ? 'pointer' : 'not-allowed',
          }}
        />
      </div>
    </form>
  );
};

export default FormularioRegistro;