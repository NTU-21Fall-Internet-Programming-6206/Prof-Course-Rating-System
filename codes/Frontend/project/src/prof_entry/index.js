import { useState } from "react";
import { useHistory } from "react-router";
import TextField from "@material-ui/core/TextField";
import './index.css'

function ProfEntry() {
    let history = useHistory();
    const [professorName, setProfessorName] = useState([])
    const [professorTitle, setProfessorTitle] = useState([])
    const [professorEmail, setProfessorEmail] = useState([])

    const clickEntry = () => {
        console.log({'professorname': professorName,'professortitle': professorTitle, 'professoremail':professorEmail})
        history.push('/dashboard')
    }

    return (
        <div className="profEntry">
            <h2>Create a new Professor Entry</h2>
            <a href="/dashboard">Go back to dashboard </a>
            <div>
                <TextField
                    name="professorname"
                    label="Professor Name"
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setProfessorName(e.target.value)}
                />
            </div> 
            <div>
                <TextField
                    name="title"
                    label="Prefessor Title"
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setProfessorTitle(e.target.value)}
                />
            </div>
            <div>
                <TextField
                    name="email"
                    label="Professor Email"
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setProfessorEmail(e.target.value)}
                />
            </div>
            <button className="small green button" onClick={clickEntry}>
                Complete
            </button>
        </div>
    );
  }
  
  export default ProfEntry;