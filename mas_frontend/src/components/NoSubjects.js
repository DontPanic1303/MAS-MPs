import {Link} from "react-router-dom";

const NoSubjects = () => {

    return (
        <div className="no-availability-message">
            <h1>Brak dostępnych korepetycji w danym momencie, wróć później</h1>
            <p><Link to={"/"}><button className="ok-button">OK</button></Link></p>
        </div>
    )
}

export default NoSubjects