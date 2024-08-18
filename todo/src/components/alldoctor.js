import React, { useState, useEffect } from 'react';
import { getAllDoctor } from '../Service/api';
import { useNavigate } from 'react-router-dom';
import DoctorCard from './doctorcard';

export default function AllDoctor(props) {
    const [doctors, setDoctors] = useState([]);
    const [loading, setLoading] = useState(false);
    const [doctor, setDoctor] = useState();
    const [info, setInfo] = useState(false);
    const navigate = useNavigate();

    const handleConsult = (doctor) => {
        console.log(doctor);
        navigate("/consultation_form", { state: { doctor } });
    };

    const fetchDoctors = async () => {
        try {
            setLoading(true);
            const data = await getAllDoctor();
            console.log(data);
            setDoctors(data ?? []);
            setLoading(false);
        } catch (error) {
            setLoading(false);
            props.showAlert(error.response?.data || "An error occurred", "danger");
        }
    };

    const showInfo = (data) => {
        console.log(data);
        
        setInfo(true);
        setDoctor(data);
    }

    useEffect(() => {
        fetchDoctors();
    }, []);

    if (loading) {
        return <div className="container mt-4"><p>Loading...</p></div>;
    }

    return (
        <div className='container '>
           {!info && <div className='row'>
                {doctors.map((doctor) => (
                    <div className='col-md-4 mb-4' key={doctor.did}>
                        <DoctorCard doctor={doctor} showInfo={showInfo} handleConsult={handleConsult} />
                    </div>
                ))}
            </div>}

          {info &&  <div >
                <h2>Information Display</h2>
                <div style={{ marginBottom: '1rem' }}>
                    <div style={{ marginBottom: '0.5rem' }}>
                        <strong>Name:</strong> {doctor.name}
                    </div>
                    <div style={{ marginBottom: '0.5rem' }}>
                        <strong>Email:</strong> {doctor.email}
                    </div>
                    <div style={{ marginBottom: '0.5rem' }}>
                        <strong>Mobile Number:</strong> {doctor.mobile_number}
                    </div>
                    <div style={{ marginBottom: '0.5rem' }}>
                        <strong>Address:</strong> {doctor.address}
                    </div>
                    <div style={{ marginBottom: '0.5rem' }}>
                        <strong>Specialty:</strong> {doctor.specialty}
                    </div>
                    <div style={{ marginBottom: '0.5rem' }}>
                        <strong>Years of Experience:</strong> {doctor.yearsOfExperience}
                    </div>
                </div>
                <button className="btn btn-primary" onClick={() => setInfo(false)}>
                        Close
                    </button>
            </div>}

        </div>
    );
}
