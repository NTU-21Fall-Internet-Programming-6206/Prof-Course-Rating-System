import TextField from "@material-ui/core/TextField";
import { useState } from "react";
import { useHistory } from "react-router";
import '../../button.css'

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    let history = useHistory();

    const clickSignin = () => {
      if (username.length > 0 && password.length > 0) {
      const user_signin = {'username': username, 'password': password}
      const request = new Request('http://34.126.85.190:8080/student/login', {
        method: "POST",
        body: JSON.stringify(user_signin),
        headers: {
          "Origin": "http://34.126.85.190:80",
          "Accept": "application/json, text/plain, */*",
          "Content-Type": "application/json"
        }
      });
      fetch(request)
        .then(res => {
          let temp = res.json()
          return temp
        })
        .then(json => {
          if (json.info === 'Success') {
            alert('Log in success!')
            localStorage.setItem("Token", json.token)
            localStorage.setItem("userName", json.username)
            window.dispatchEvent(new Event('storage'))
            history.push('/dashboard')
          } else {
            alert('Your username or password is wrong')
          }
          console.log(json)
          console.log(localStorage.getItem('Token'))
        })
        .catch(error => {
          console.log(error);
        });
      } else {
        alert('Please input username or password')
      }
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
            label="Username"
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