import { useHistory } from "react-router";
import Card from '../course_card'
import './index.css'
import { useEffect, useState } from 'react';

function Choice(props) {
    let history = useHistory();
    let token = localStorage.getItem('Token');
    let previousCourseID = props.location.state.course.courseID;
    let previousCourseName = props.location.state.course.courseName[0]
    let previousProfName = props.location.state.course.courseName[1]
    
    const [courseCR, setCourseCR] = useState([])

    useEffect(() => {
        const url = `http://34.126.85.190:8080/course-CR?course_id=${previousCourseID}`;
        const request = new Request(url, {
              method: "get",
              body: null,
              headers:new Headers ({
              'Token': token,
              'Accept': "application/json, text/plain, */*",
              "Content-Type": "application/json"
              })
          })      
          fetch(request).then((res) => {
              return res.json()
          }).then(json => {
              setCourseCR(json.course_cr_list) 
          }).catch(error => {
              console.log(error);
          });
    }
  , [])

    const logOut = () => {
        localStorage.setItem('Token', '')
        localStorage.setItem('username', '')
        window.dispatchEvent(new Event('storage'))
        history.push("/")
    }

    return (
        <div className="professorContainer">
            <div className="professorNav">
                <span className="logOut" onClick={logOut}>
                    Log out
                </span>
                <span className="returnDashboard" onClick={()=>history.push("/dashboard")}>
                    Dashboard
                </span>
                <span className="createProfComment" onClick={()=>history.push({pathname:'/courserate', state:{'course':props.location.state.course}})}>
                    Create new rate and comment
                </span>
            </div>
            <h2 className="title">The comments on the course {previousCourseID} {previousCourseName}</h2>
            <div className="profCommentArea">
                { courseCR.map((course) => { return <Card courseID={course.courseID} name={course.professorName} score={course.rating} comment={course.comment} /> }) }  
            </div>
        </div>
    );
  }
  
  export default Choice;