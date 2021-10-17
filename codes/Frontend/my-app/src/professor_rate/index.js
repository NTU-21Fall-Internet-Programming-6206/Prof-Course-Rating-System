import { useState } from 'react';
import './index.css'

function ProfessorForm(props) {
    const [professor, setProfessor] = useState()
    return (
        <div>
            <textarea id="comments" name="comments" maxLength="100">

            </textarea>
        </div>
    );
  }
  
  export default ProfessorForm;