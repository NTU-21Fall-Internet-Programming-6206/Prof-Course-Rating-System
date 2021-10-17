function ProfEntryCard(props) {
    return (
        <li id="job">
            <div>
                <h3>Professor: { props.profName }</h3>
            </div>
        </li>
    );
  }
  
  export default ProfEntryCard;