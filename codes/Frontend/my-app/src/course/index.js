import { useState } from "react";
import { useHistory } from "react-router";
import Card from '../course_card'
import './index.css'

function Choice() {
    let history = useHistory();
    const [professors, setProfessor] = useState([])
    return (
        <div className="professorContainer">
            <div className="professorNav">
                <span className="logOut" onClick={()=>history.push("/")}>
                    Log out
                </span>
                <span className="returnDashboard" onClick={()=>history.push("/dashboard")}>
                    Dashboard
                </span>
                <span className="createProfComment" onClick={()=>history.push('/courserate')}>
                    Create new rate and comment
                </span>
            </div>
            <h2 className="title">The comments on different courses</h2>
            <div className="profCommentArea">
                <Card course="CI_6206" name="Danny Heap" score="4.5" comment="He is so nice"/>
            </div>
        </div>
    );
  }
  
  export default Choice;