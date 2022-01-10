import axios from 'axios';
import React, { useState } from 'react';
import './App.css';

const baseURL = "http://localhost:8080"

function App() {
  const [file, setFile] = useState<any>(null);

  const onFileChange: React.ChangeEventHandler<HTMLInputElement> = (evt) => {
    if (!evt.target.files)
      return;
    setFile(evt.target.files[0]);
  }

  const onFileSubmit: React.FormEventHandler<HTMLFormElement> = async (evt) => {
    evt.preventDefault();
    const formData = new FormData();
    if (file === null) {
      console.log("file is Empty!");
      return;
    }
    formData.append("file", file);
    try {
      const response = await axios({
        method: "POST",
        url: `${baseURL}/api/v1/upload/file`,
        data: formData,
        headers: {"Content-Type": "multipart/form-data"}
      });
      console.log(response);
    } catch (err) {
      console.log(err);
    }
  }
  return (
    <div className="App">
      <form onSubmit={onFileSubmit}>
        <input type="file" onChange={onFileChange}/>
        <input type="submit" value="업로드"></input>
      </form>
    </div>
  );
}

export default App;
