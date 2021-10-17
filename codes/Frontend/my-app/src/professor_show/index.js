import { useState } from "react";
import { useHistory } from "react-router";
import ProfEntryCard from "./prof_entrycard";

function ProfList() {
    let history = useHistory()
    const [profList, setProfList] = useState([{'name': 'aton'}, {'name': 'Danny'}])

    return (
      <div className="profShow">
          <div className="professorNav">
              <span className="logOut" onClick={()=>history.push("/")}>
                Log out
              </span>
              <span className="returnDashboard" onClick={()=>history.push("/dashboard")}>
                Dashboard
              </span>
          </div>
          <ul className="profList">
            { profList.map((prof) => { return <ProfEntryCard profName={ prof.name } /> }) }
          </ul>
      </div>
    );
  }
  
  export default ProfList;