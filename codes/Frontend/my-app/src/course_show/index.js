import { useState } from "react";
import { useHistory } from "react-router";
import CourseEntryCard from "./course_entrycard";

function CourseList() {
    let history = useHistory();
    const [courseList, setCourseList] = useState([{'id':6206, 'name':'web programming'}]);

    return (
      <div className="courseShow">
          <div className="professorNav">
                <span className="logOut" onClick={()=>history.push("/")}>
                    Log out
                </span>
                <span className="returnDashboard" onClick={()=>history.push("/dashboard")}>
                    Dashboard
                </span>
            </div>
            <ul className="profList">
            { courseList.map((course) => { return <CourseEntryCard courseID={course.id} courseName={ course.name } /> }) }
          </ul>
      </div>
    );
  }
  
  export default CourseList;