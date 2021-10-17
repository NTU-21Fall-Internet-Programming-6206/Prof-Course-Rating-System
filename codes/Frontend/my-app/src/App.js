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


function App() {
    return (
    <Router>
      <Route exact path='/' component={Home}/>
      <Route exact path='/signin' component={Signin}/>
      <Route exact path='/signup' component={Signup}/>
      <Route exact path='/dashboard' component={Dashboard}/>
      <Route exact path='/profentry' component={ProfEntry}/>
      <Route exact path='/courseentry' component={CourseEntry}/>
      <Route exact path='/profshow' component={ProfessorShow}/>
      <Route exact path='/courseshow' component={CourseShow}/>
      <Route exact path='/professor' component={Professor}/>
      <Route exact path='/course' component={Course}/>
      <Route exact path='/profrate' component={ProfRate}/>
      <Route exact path='/courserate' component={CourseRate}/>
    </Router>
  );
}

export default App;
