import {Link, useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";

const Tutors = () => {
    const { idS } = useParams();
    const [tutors, setTutors] = useState([]);
    const navigate = useNavigate();

    const fetchTutors = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/tutor/subject/${idS}`);
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const tutorsData = await response.json();
            return tutorsData;
        } catch (error) {
            console.error('Błąd pobierania danych użytkowników:', error);
            return [];
        }
    };

    const generateTutorListHTML = async () => {
        try {
            const tutorsData = await fetchTutors();
            setTutors(tutorsData);
        } catch (error) {
            console.error('Błąd generowania listy użytkowników:', error);
        }
    };

    useEffect(() => {
        generateTutorListHTML();
    }, []);

    const getDay = () => {
        const currentDate = new Date();
        currentDate.setDate(currentDate.getDate() + 1);
        return currentDate.toISOString().split('T')[0];
    }

    const goBack = () => {
        navigate('/singUp')
    }


    return (
        <div className="tutor-selection">
            <button onClick={goBack}>Powrót</button>
            <h1>Wybierz korepetytora</h1>
            <div className="tutors-table">
                {tutors.map((tutor) => (
                    <div className="tutor-row" key={tutor.id}>
                        <div className="tutor-cell">Imię: {tutor.name}</div>
                        <div className="tutor-cell">Nazwisko: {tutor.surname}</div>
                        <div className="tutor-cell">Cena: {tutor.hourlySalary} zł</div>
                        <div className="tutor-cell">
                            <Link to={`/singUp/${idS}/${tutor.id}/${getDay()}`}>
                                <button>Wybierz</button>
                            </Link>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Tutors