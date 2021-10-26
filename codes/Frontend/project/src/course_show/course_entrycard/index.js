import { Link } from "react-router-dom";

function CourseEntryCard(props) {
    return (
        <li id="job">
            <div>
                <Link to={{
                pathname: `/course`,
                state: {course: props}
                }}>
                    <h3>CourseID: { props.courseID }</h3>
                    <p>Course Name: { props.courseName[0] }</p>
                    <p>Professor Name: {props.courseName[1]}</p>
                </Link>
            </div>
        </li>
    );
  }
  
  export default CourseEntryCard;