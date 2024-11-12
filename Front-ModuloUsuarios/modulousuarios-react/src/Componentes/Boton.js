import React from 'react';

function Boton({ label, onClick, style }) {
  return (
    <Boton onClick={onClick} style={style}>
      {label}
    </Boton>
  );
}

export default Boton;