import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";

const Lessons = () => {
    const { idS } = useParams();
    const { idT } = useParams();
    const { startDay } = useParams();
    const [lessons, setLessons] = useState([]);
    const navigate = useNavigate();

    const fetchLessons = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/lesson/tutor/${idT}/${startDay}`);
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const lessonsData = await response.json();
            return lessonsData;
        } catch (error) {
            console.error('Błąd pobierania danych użytkowników:', error);
            return [];
        }
    };

    const generateLessonListHTML = async () => {
        try {
            const lessonsData = await fetchLessons();
            setLessons(lessonsData);
        } catch (error) {
            console.error('Błąd generowania listy użytkowników:', error);
        }
    };

    useEffect(() => {
        generateLessonListHTML();
    }, [idT, startDay]);

    function getNextDayISO(dateString) {
        const currentDate = new Date(dateString);
        currentDate.setDate(currentDate.getDate() + 1);
        return currentDate.toISOString().split('T')[0];
    }

    function getBeforeDayISO(dateString) {
        const currentDate = new Date(dateString);
        currentDate.setDate(currentDate.getDate() - 1);
        return currentDate.toISOString().split('T')[0];
    }
    const goToDayBefore = () => {
        navigate(`/singUp/${idS}/${idT}/${getBeforeDayISO(startDay)}`);
    }

    const goToDayNext = () => {
        navigate(`/singUp/${idS}/${idT}/${getNextDayISO(startDay)}`);
    }

    const goBack = () => {
        navigate(`/singUp/${idS}/`)
    }

    const singUp = async (lesson) => {
        try {
            const response = await fetch('http://localhost:8080/api/lesson/create', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    startDate: startDay,
                    startTime: lesson.startTime,
                    tutor: idT,
                    student: '1'
                }),
            });
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const isOk = await response.json();
            if (isOk.reserveable)
                navigate(`/singUp/${isOk.startTime}/payOrNotTuPay`)
            else
                navigate(`/singUp/${idS}/${idT}/${startDay}/noLesson`)
        } catch (error) {
            console.error('Błąd pobierania danych użytkowników:', error);
        }
    }


    return (
        <div className="lesson-selection">
            <button className="back-button" onClick={goBack}>Powrót</button>
            <h1>Wybierz termin</h1>
            {startDay >= getNextDayISO(new Date()) ? (
                <div className="date-navigation">
                    <button onClick={goToDayBefore}>{getBeforeDayISO(startDay)}</button>
                    <h3>{startDay}</h3>
                    <button onClick={goToDayNext}>{getNextDayISO(startDay)}</button>
                </div>
            ) : (
                <div className="date-navigation">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <h3>{startDay}</h3>
                    <button onClick={goToDayNext}>{getNextDayISO(startDay)}</button>
                </div>
            )}

            <div className="lessons-grid">
                {lessons.map((lesson, index) => (
                    lesson.reserveable ? (
                        <button key={index} className="lesson-button" onClick={() => singUp(lesson)}>
                            {lesson.startTime} - {lesson.startTime + 1}
                        </button>
                    ) : (
                        <div key={index} className="empty-slot"></div>
                    )
                ))}
            </div>
        </div>
    )
}

export default Lessons;