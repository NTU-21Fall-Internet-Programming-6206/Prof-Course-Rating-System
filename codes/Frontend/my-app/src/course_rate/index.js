import { useState } from "react";
import { useHistory } from "react-router";
import TextField from "@material-ui/core/TextField";
import {RangeStepInput} from 'react-range-step-input';
import './index.css'

function CourseRate() {
    let history = useHistory();
    const [courseId, setcourseId] = useState('')
    const [courseRate, setcourseRate] = useState('')
    const [courseComment, setcourseComment] = useState('')

    const clickEntry = () => {
        console.log(courseId+courseRate+courseComment)
        // history.push('/dashboard')
    }

    return (
        <div className="courseRateForm">
            <h2>Create a new comment and rate for a course</h2>
            <a href="/dashboard">Go back to course comments page </a>
            <div>
                <TextField
                    name="courseId"
                    label="Course Id"
                    id="outlined-basic"
                    variant='outlined'
                    margin="normal"
                    onChange={e => setcourseId(e.target.value)}
                />
            </div> 
            <div>
                <RangeStepInput min={0} max={5} value={courseRate} step={0.5} onChange={(e)=>setcourseRate(e.target.value)}/>
            </div>
            <div>
                <p>Comments</p>
                <textarea id="courseComments" name="courseComments" maxLength="100"
                onChange={(e)=>setcourseComment(e.target.value)}>

                </textarea>
            </div>
            <button className="small green button" onClick={clickEntry}>
                Complete
            </button>
        </div>
    );
  }
  
  export default CourseRate;