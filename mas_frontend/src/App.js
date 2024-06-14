import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import './App.css';
import {Suspense} from "react";
import Subjects from "./components/Subjects";
import Tutors from "./components/Tutors";
import {NotFound} from "./components/NotFound";
import NoSubjects from "./components/NoSubjects";
import NoLesson from "./components/NoLesson";
import Lessons from "./components/Lessons";
import PayOrNotToPay from "./components/PayOrNotToPay";

function App() {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<Subjects />} />
              <Route path="/singUp" element={<Subjects />} />
              <Route path="/singUp/:idS" element={<Tutors />} />
              <Route path="/singUp/noSubject" element={<NoSubjects />} />
              <Route path="/singUp/:idS/:idT/:startDay/noLesson" element={<NoLesson />} />
              <Route path="/singUp/:idS/:idT/:startDay" element={<Lessons />} />
              <Route path="/singUp/:idL/payOrNotTuPay" element={<PayOrNotToPay />} />
              <Route path="*" element={<NotFound />} />
          </Routes>
      </Router>
  );
}

export default App;
