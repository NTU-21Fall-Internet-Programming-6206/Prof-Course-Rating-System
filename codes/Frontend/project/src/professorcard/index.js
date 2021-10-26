import './index.css'

function Card(props) {
    return (
            <div className="cardContainer">
                <div className="profName">
                    Professor Name:<br></br>
                    {props.name}
                </div>
                <div className="score">
                    Score:<br></br>
                    {props.score}/5
                </div>
                <div className="comment">
                    Comment:<br></br>
                    {props.comment}
                </div>
            </div>
    );
  }
  
  export default Card;