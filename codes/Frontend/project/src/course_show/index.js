import { useEffect } from "react";
import { useState } from "react";
import { useHistory } from "react-router";
import CourseEntryCard from "./course_entrycard";

function CourseList() {
    let history = useHistory();
    let token = localStorage.getItem('Token')
    const [courseList, setCourseList] = useState([]);

    useEffect(() => {
        const url = "http://34.126.85.190:8080/course";
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
              setCourseList(json.course_list) 
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
      <div className="courseShow">
          <div className="professorNav">
                <span className="logOut" onClick={logOut}>
                    Log out
                </span>
                <span className="returnDashboard" onClick={()=>history.push("/dashboard")}>
                    Dashboard
                </span>
            </div>
            <ul className="profList">
            { courseList.map((course) => { return <CourseEntryCard courseID={course.courseID} courseName={[course.courseName, course.professorName]} /> }) }
          </ul>
      </div>
    );
  }
  
  export default CourseList;