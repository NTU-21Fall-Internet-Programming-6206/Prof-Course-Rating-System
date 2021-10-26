import './index.css';
import Card from '../professorcard'
import Rate from '../professor_rate'
import { useHistory } from 'react-router';
import { useEffect, useState } from 'react';

function Home(props) {
    let history = useHistory();
    let token = localStorage.getItem('Token')
    let previousProf = props.location.state.profName;

    const [profCR, setProfCR] = useState([])

    useEffect(() => {
        const url = `http://34.126.85.190:8080/professor-CR?professor_name=${previousProf}`;
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
              setProfCR(json.professor_cr_list) 
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

    console.log(profCR)
    return (
        <div className="professorContainer">
            <div className="professorNav">
                <span className="logOut" onClick={logOut}>
                    Log out
                </span>
                <span className="returnDashboard" onClick={()=>history.push("/dashboard")}>
                    Dashboard
                </span>
                <span className="createProfComment" onClick={()=>history.push({pathname:"/profrate", state:{'prof': previousProf}})}>
                    Create new rate and comment
                </span>
            </div>
            <h2 className="title">The comments on Professor: {previousProf}</h2>
            <div className="profCommentArea">
                { profCR.map((prof) => { return <Card name={prof.professorName} score={prof.rating} comment={prof.comment} /> }) }
                
            </div>
        </div>
    );
  }
  
  export default Home;