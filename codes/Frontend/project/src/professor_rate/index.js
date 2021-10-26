import { useState } from "react";
import { useHistory } from "react-router";
import TextField from "@material-ui/core/TextField";
import {RangeStepInput} from 'react-range-step-input';
import './index.css'

function ProfessorForm(props) {
    let history = useHistory();
    let token = localStorage.getItem('Token')
    let userName = localStorage.getItem('userName')
    let previousProf = props.location.state.prof;
    const [professorName, setProfName] = useState(previousProf)
    const [profRate, setProfRate] = useState('3')
    const [profComment, setProfComment] = useState('')

    const clickEntry = () => {
        const prof_rate = {'professor_name': professorName, 'username': userName, 'rate': parseInt(profRate), 'comment':profComment}
        const request = new Request('http://34.126.85.190:8080/professor-CR/add', {
            method: "POST",
            body: JSON.stringify(prof_rate),
            headers: {
                'Token': token,
                Accept: "application/json, text/plain, */*",
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
            alert('CR creation success')
            history.push('/dashboard')
          } else {
            alert('This professor CR failed to create')
          }
        })
        .catch(error => {
          console.log(error);
        });
    }

    return (
        <div className="courseRateForm">
            <h2>Create a new comment and rate for a Professor</h2>
            <a href="/dashboard">Go back to course comments page </a>
            <div>
                <TextField
                    name="profName"
                    label="Professor Name"
                    defaultValue={previousProf}
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setProfName(e.target.value)}
                />
            </div> 
            <div>
                <h4>Rate: {profRate}</h4>
                <RangeStepInput min={0} max={5} value={profRate} step={1} onChange={(e)=>setProfRate(e.target.value)}/>
            </div>
            <div>
                <p>Comments</p>
                <textarea id="courseComments" name="courseComments" maxLength="100"
                onChange={(e)=>setProfComment(e.target.value)}>
                </textarea>
            </div>
            <button className="small green button" onClick={clickEntry}>
                Complete
            </button>
        </div>
    );
  }
  
  export default ProfessorForm;