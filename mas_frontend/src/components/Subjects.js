import {useEffect, useState} from "react";
import {Link, useNavigate} from "react-router-dom";

const Subjects = () => {
    const [subjects, setSubjects] = useState([]);
    const navigate = useNavigate();

    const fetchSubjects = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/subject');
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const subjectsData = await response.json();
            if (subjectsData.length === 0)
                navigate('/singUp/noSubject');
            return subjectsData;
        } catch (error) {
            console.error('Błąd pobierania danych użytkowników:', error);
            return [];
        }
    };

    const generateSubjectListHTML = async () => {
        try {
            const subjectsData = await fetchSubjects();
            setSubjects(subjectsData);
        } catch (error) {
            console.error('Błąd generowania listy użytkowników:', error);
        }
    };

    useEffect(() => {
        generateSubjectListHTML();
    }, []);


    return (
        <div className="subject-selection">
            <h1>Wybierz przedmiot na który chcesz się zapisać.</h1>
            <div className="subjects-table">
                {subjects.map((subject) => (
                    <div className="subject-row" key={subject.id}>
                        <div className="subject-cell">Przedmiot: {subject.name}</div>
                        <div className="subject-cell">Poziom: {subject.level}</div>
                        <div className="subject-cell">
                            <Link to={`/singUp/${subject.id}`}>
                                <button>Wybierz</button>
                            </Link>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );

}

export default Subjects;