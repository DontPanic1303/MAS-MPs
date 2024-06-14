import {useNavigate, useParams} from "react-router-dom";

const PayOrNotToPay = () => {
    const { idL } = useParams();
    const navigate = useNavigate();

    const goToStart = () => {
        navigate('/')
    }

    const payNow = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/payment/change/${idL}`, {
                method: 'PUT',
            });
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            navigate(`/`)
        } catch (error) {
            console.error('Błąd pobierania danych użytkowników:', error);
        }
    }

    return (
        <div className="reservation-confirmation">
            <h1>Udało Ci się zarezerwować termin korepetycji!</h1>
            <h2>Czy chcesz zapłacić za nie teraz czy później?</h2>
            <div className="button-container">
                <button className="pay-now" onClick={payNow}>Teraz</button>
                <button className="pay-later" onClick={goToStart}>Później</button>
            </div>
        </div>
    )
}

export default PayOrNotToPay;