const CampoTexto = ({ label, name, value, onChange, type = 'text' }) => (
    <div>
      <label>{label}</label>
      <input type={type} name={name} value={value} onChange={onChange} required />
    </div>
  );
  
  export default CampoTexto;
  