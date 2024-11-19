import React, { useState } from 'react';
import CampoTexto from './CampoTexto';
import ListaDesplegable from './ListaDesplegable';
import Boton from './Boton';

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

  const manejarCambio = (e) => {
    const { name, value } = e.target;
    setFormulario({ ...formulario, [name]: value });
  };

  const manejarEnvio = (e) => {
    e.preventDefault();
    if (formulario.contrasena !== formulario.confirmacionContrasena) {
      alert('Las contraseñas no coinciden');
      return;
    }
    alert('Registro exitoso');
    console.log(formulario);
  };

  return (
    <form onSubmit={manejarEnvio}>
      <CampoTexto 
        label="Código del Estudiante" 
        name="codigoEstudiante" 
        value={formulario.codigoEstudiante} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Nombre del Estudiante" 
        name="nombreEstudiante" 
        value={formulario.nombreEstudiante} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Número de Documento del Estudiante" 
        name="numeroDocumentoEstudiante" 
        value={formulario.numeroDocumentoEstudiante} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Tipo de Documento" 
        name="tipoDocumentoEstudiante" 
        value={formulario.tipoDocumentoEstudiante} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Nombre del Responsable Económico" 
        name="nombreResponsable" 
        value={formulario.nombreResponsable} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Documento del Responsable Económico" 
        name="documentoResponsable" 
        value={formulario.documentoResponsable} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Lugar de Expedición" 
        name="lugarExpedicionResponsable" 
        value={formulario.lugarExpedicionResponsable} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Teléfono del Responsable Económico" 
        name="telefonoResponsable" 
        value={formulario.telefonoResponsable} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Correo del Responsable Económico" 
        name="correoResponsable" 
        value={formulario.correoResponsable} 
        onChange={manejarCambio} 
      />
      <ListaDesplegable 
        label="Curso" 
        name="curso" 
        opciones={['Jardín', 'Transición', '101', '201', '1101']} 
        value={formulario.curso} 
        onChange={manejarCambio} 
      />
      <ListaDesplegable 
        label="Grado" 
        name="grado" 
        opciones={['Jardín', '1', '2', '11']} 
        value={formulario.grado} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Contraseña" 
        name="contrasena" 
        type="password" 
        value={formulario.contrasena} 
        onChange={manejarCambio} 
      />
      <CampoTexto 
        label="Confirmación de Contraseña" 
        name="confirmacionContrasena" 
        type="password" 
        value={formulario.confirmacionContrasena} 
        onChange={manejarCambio} 
      />
      <Boton texto="Registrar" />
    </form>
  );
};

export default FormularioRegistro;
