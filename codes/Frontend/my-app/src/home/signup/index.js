import TextField from "@material-ui/core/TextField";
import { useState } from "react";
import { useHistory } from "react-router";
import '../../button.css'

function Signup() {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [email, setEmail] = useState('')
    let history = useHistory();

    const clickSignup = () => {
      console.log({'username': username, 'password': password, 'email': email})
      history.push('/signin')
    }
    return (
      <div className="App">
        <div class = "signin-header">
          <h1>Professor and Course Rating</h1>
          <br></br>
          <h3>Create your account!</h3>
          <a href="/signin">
          Already have an account, Sign in!
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
        <div>
          <TextField
            name="email"
            label="email"
            type="email"
            id="outlined-basic"
            variant='outlined'
            margin="normal"
            onChange={e => setEmail(e.target.value)}
          />
        </div>
        <button className="small red button" onClick={clickSignup}>
          Sign up
        </button>
      </div>
    );
  }
  
  export default Signup;