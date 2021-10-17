import './index.css';
import { Link } from 'react-router-dom';

function Choice() {
    return (
        <div class = "App">
            <div className="hero-image">
                <div class="hero-text">
                    <h1>Choose what you are interested!</h1>
                    <br></br>
                    <p>If you want to read and make comments on professors. </p>
                    <Link to = {'./profshow'}>
                    <button>Professors</button>
                    </Link>
                    <p>If you want to read and make comments on courses. </p>
                    <Link to = {'./courseshow'}>
                    <button>Courses</button>
                    </Link>
                    <p>If you want to create a new professor entry. </p>
                    <Link to = {'./profentry'}>
                    <button>Create Professor Entry</button>
                    </Link>
                    <p>If you want to create a new course entry. </p>
                    <Link to = {'./courseentry'}>
                    <button>Create Course Entry</button>
                    </Link>
                </div>
            </div>
        </div>
    );
  }
  
  export default Choice;