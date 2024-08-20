import React, { useState, useEffect } from 'react';
import { userConsulationHistory } from '../Service/api';
import ConsultCard from './consult_card';
import jsPDF from 'jspdf';

export default function UserConsultationHistory() {
    const [history, setHistory] = useState([]);
    const [loading, setLoading] = useState(false);

    const getHistory = async () => {
        try {
            setLoading(true);
            const id = localStorage.getItem("pid");
            const data = await userConsulationHistory(id);
            setHistory(data);
            setLoading(false);
        } catch (error) {
            console.log(error);
            setLoading(false);
        }
    };

    const generatePDF = (consult) => {
        const doc = new jsPDF();
        doc.setFontSize(12);
        doc.text(`Doctor Name: ${consult.doctorName}`, 10, 10);
        doc.text(`Patient Name: ${consult.patientName}`, 10, 20);
        doc.text(`Date: ${consult.date}`, 10, 30);
        doc.text(`Care to be taken:`, 10, 40);
        doc.text(consult.careToBeTaken, 10, 50);
        doc.text(`Medicine:`, 10, 70);
        doc.text(consult.medicine, 10, 80);
        doc.text(`Doctor Signature: ____________________`, 10, 100);
        doc.save(`Consultation_${consult.patientName}_${consult.date}.pdf`);
    };

    useEffect(() => {
        getHistory();
    }, []);

    return (
        <div className='container mt-4'>
          { history.length!==0? <div className='row'>
                {history.map((consult, index) => (
                    <div key={index} className="col-md-4 mb-4">
                        <ConsultCard consult={consult} generatePDF={generatePDF} />
                    </div>
                ))}
            </div>
            :
            <h4 style={{textAlign:'center'}}><p>No consultation found</p></h4>
            }
        </div>
    );
}
