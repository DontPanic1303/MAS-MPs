import {useNavigate, useParams} from "react-router-dom";

const NoLessons = () => {
    const { idS } = useParams();
    const { idT } = useParams();
    const { startDay } = useParams();
    const navigate = useNavigate();

    const goBack = () => {
        navigate(`/singUp/${idS}/${idT}/${startDay}`)
    }

    return (
        <div className="conflict-message">
            <button className="back-button" onClick={goBack}>Powrót</button>
            <h1>W wybranym terminie jesteś już zapisany na inne korepetycje</h1>
        </div>
    )
}

export default NoLessons;