function CourseEntryCard(props) {
    return (
        <li id="job">
            <div>
                <h3>CourseID: { props.courseID }</h3>
                <p>Course Name: { props.courseName }</p>
            </div>
        </li>
    );
  }
  
  export default CourseEntryCard;