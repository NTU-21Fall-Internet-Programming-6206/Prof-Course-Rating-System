import { useState } from "react";
import { useEffect } from "react";
import { useHistory } from "react-router";
import ProfEntryCard from "./prof_entrycard";

function ProfList() {
    let history = useHistory()
    let token = localStorage.getItem('Token')
    const [profList, setProfList] = useState([])

    useEffect(() => {
        const url = "http://34.126.85.190:8080/professor";
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
              setProfList(json.professor_list) 
              console.log(profList)
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
      <div className="profShow">
          <div className="professorNav">
              <span className="logOut" onClick={logOut}>
                Log out
              </span>
              <span className="returnDashboard" onClick={()=>history.push("/dashboard")}>
                Dashboard
              </span>
          </div>
          <ul className="profList">
            { profList.map((prof) => { return <ProfEntryCard profName={prof.professorName} profTitle={prof.title} profEmail={prof.emailAddress} /> }) }
          </ul>
      </div>
    );
  }
  
  export default ProfList;