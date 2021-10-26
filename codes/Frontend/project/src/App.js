import {BrowserRouter as Router, Switch, Route, Redirect} from "react-router-dom";
import Home from './home'
import Signin from './home/login'
import Signup from './home/signup'
import Dashboard from './home/dashboard'
import ProfEntry from "./prof_entry";
import CourseEntry from "./course_entry";
import ProfessorShow from './professor_show'
import CourseShow from './course_show'
import Professor from './professor'
import Course from './course'
import CourseRate from './course_rate'
import ProfRate from './professor_rate'
import { useState, useEffect, useCallback } from "react";


function App() {

    const [trigger, setTrigger] = useState('')

    const handleUserKeyPress = useCallback(event => {
      setTrigger(window.localStorage.getItem('Token'))
    }, []);

    useEffect(() => {
      window.addEventListener("storage", handleUserKeyPress);
      setTrigger(window.localStorage.getItem('Token'))
      return () => {
        window.removeEventListener("storage", handleUserKeyPress);
      };
    }, [handleUserKeyPress])


    return (
    <Router>
      {trigger.length === 0
      ?(<Switch>
        <Route exact path='/' component={Home}/>
        <Route exact path='/signin' component={Signin}/>
        <Route exact path='/signup' component={Signup}/>
        <Redirect to='/' />
      </Switch>):(<Switch>
          <Route exact path='/dashboard' component={Dashboard}/>
          <Route exact path='/profentry' component={ProfEntry}/>
          <Route exact path='/courseentry' component={CourseEntry}/>
          <Route exact path='/profshow' component={ProfessorShow}/>
          <Route exact path='/courseshow' component={CourseShow}/>
          <Route exact path='/professor' component={Professor}/>
          <Route exact path='/course' component={Course}/>
          <Route exact path='/profrate' component={ProfRate}/>
          <Route exact path='/courserate' component={CourseRate}/>
          <Redirect to='/dashboard' />
        </Switch>)}
    </Router>
  );
}

export default App;
