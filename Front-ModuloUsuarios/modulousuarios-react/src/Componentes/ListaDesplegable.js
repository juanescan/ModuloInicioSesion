const ListaDesplegable = ({ label, name, opciones, value, onChange }) => (
    <div>
      <label>{label}</label>
      <select name={name} value={value} onChange={onChange} required>
        <option value="">Seleccione una opción</option>
        {opciones.map((opcion, index) => (
          <option key={index} value={opcion}>
            {opcion}
          </option>
        ))}
      </select>
    </div>
  );
  
  export default ListaDesplegable;
  