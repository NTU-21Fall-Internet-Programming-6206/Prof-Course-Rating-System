import { useState } from "react";
import { useHistory } from "react-router";
import TextField from "@material-ui/core/TextField";
import {RangeStepInput} from 'react-range-step-input';
import './index.css'

function CourseRate(props) {
    let history = useHistory();
    let token = localStorage.getItem('Token');
    let userName = localStorage.getItem('userName');
    let previousCourse = props.location.state.course.courseID;
    let previouseProf = props.location.state.course.courseName[1]
    const [professorName, setProfName] = useState(previouseProf);
    const [courseID, setCourseID] = useState(previousCourse);
    const [profRate, setProfRate] = useState('3');
    const [profComment, setProfComment] = useState('');

    const clickEntry = () => {
        const prof_rate = {'professor_name': professorName, 'username': userName, 'course_id': courseID,'rate': parseInt(profRate), 'comment':profComment}
        const request = new Request('http://34.126.85.190:8080/course-CR/add', {
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
            <h2>Create a new comment and rate for a Course</h2>
            <a href="/dashboard">Go back to course comments page </a>
            <div>
                <TextField
                    name="profName"
                    label="Professor Name"
                    defaultValue={previouseProf}
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setProfName(e.target.value)}
                />
            </div>
            <div>
                <TextField
                    name="courseID"
                    label="Course ID"
                    defaultValue={previousCourse}
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setCourseID(e.target.value)}
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
  
  export default CourseRate;