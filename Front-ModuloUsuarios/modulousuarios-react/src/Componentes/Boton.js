import React from 'react';
import './style.css';

function Boton({ label, onClick, style }) {
  return (
    <button onClick={onClick} style={style}>
      {label}
    </button>
  );
}

export default Boton;