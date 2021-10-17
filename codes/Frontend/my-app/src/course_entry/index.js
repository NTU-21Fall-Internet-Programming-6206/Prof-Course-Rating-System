import { useState } from "react";
import { useHistory } from "react-router";
import TextField from "@material-ui/core/TextField";
import './index.css'

function CourseEntry() {
    let history = useHistory();
    const [courseId, setcourseId] = useState('')
    const [professorName, setProfessorName] = useState('')
    const [courseName, setCourseName] = useState('')

    const clickEntry = () => {
        console.log({'courseID': courseId, 'professorname':professorName, 'coursename':courseName})
        history.push('/dashboard')
    }

    return (
        <div className="courseEntry">
            <h2>Create a new Course Entry</h2>
            <a href="/dashboard">Go back to dashboard </a>
            <div>
                <TextField
                    name="courseid"
                    label="Course ID"
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setcourseId(e.target.value)}
                />
            </div> 
            <div>
                <TextField
                    name="professorname"
                    label="Prefessor Name"
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setProfessorName(e.target.value)}
                />
            </div>
            <div>
                <TextField
                    name="coursename"
                    label="Course Name"
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setCourseName(e.target.value)}
                />
            </div>
            <button className="small green button" onClick={clickEntry}>
                Complete
            </button>
        </div>
    );
  }
  
  export default CourseEntry;