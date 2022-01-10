import React, { useState } from 'react';
import './App.css';

function App() {
  const [file, setFile] = useState<any>(null);

  const onFileChange: React.ChangeEventHandler<HTMLInputElement> = (evt) => {
    if (!evt.target.files)
      return;
    setFile(evt.target.files[0]);
  }
  return (
    <div className="App">
      <input type="file" onChange={onFileChange}/>
      <button></button>
    </div>
  );
}

export default App;
