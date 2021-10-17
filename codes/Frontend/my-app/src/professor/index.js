import './index.css';
import Card from '../professorcard'
import Rate from '../professor_rate'
import { useHistory } from 'react-router';

function Home() {
    let history = useHistory();
    return (
        <div className="professorContainer">
            <div className="professorNav">
                <span className="logOut" onClick={()=>history.push("/")}>
                    Log out
                </span>
                <span className="returnDashboard" onClick={()=>history.push("/dashboard")}>
                    Dashboard
                </span>
                <span className="createProfComment">
                    Create new rate and comment
                </span>
            </div>
            <h2 className="title">The comments on different professors</h2>
            <div className="profCommentArea">
                <Card name="Danny Heap" score="4.5" comment="He is so nice"/>
            </div>
        </div>
    );
  }
  
  export default Home;