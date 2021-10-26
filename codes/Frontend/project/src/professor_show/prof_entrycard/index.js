import { Link } from "react-router-dom";

function ProfEntryCard(props) {
    return (
        <li id="job">
            <Link to={{
            pathname: `/professor`,
            state: {profName:props.profName}
            }}>
                <div>
                    <h3>Professor Name: { props.profName }</h3>
                    <p> Title: {props.profTitle} </p>
                    <p> Email Address: {props.profEmail} </p>
                </div>
            </Link>
        </li>
    );
  }
  
  export default ProfEntryCard;