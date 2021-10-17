import TextField from "@material-ui/core/TextField";
import { useState } from "react";
import { useHistory } from "react-router";
import '../../button.css'

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    let history = useHistory();

    const clickSignin = () => {
      console.log({'username': username, 'password': password})
      history.push('/dashboard')
    }

    return (
      <div className="App">
        <div class = "signin-header">
          <h1>Professor and Course Rating</h1>
          <br></br>
          <h3>Welcome Back!</h3>
          <a href="/signup">
          Don't have account, Sign up!
          </a>
        </div>
        <div>
          <TextField
            name="username"
            label="username"
            id="outlined-basic"
            variant='outlined'
            margin="normal"
            onChange={e => setUsername(e.target.value)}
          />
        </div> 
        <div>
          <TextField
            name="password"
            label="Password"
            type="password"
            id="outlined-basic"
            variant='outlined'
            margin="normal"
            onChange={e => setPassword(e.target.value)}
          />
        </div>
        <button className="small green button" onClick={clickSignin}>
          Log in
        </button>
      </div>
    );
  }
  
  export default Login;