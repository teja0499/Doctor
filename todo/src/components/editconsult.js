import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { completeConsulatationReq } from '../Service/api';


export default function EditConsult() {
    const location = useLocation();
    const navigate = useNavigate();

 
    const { data } = location.state || {};

    const [medicine, setMedicine] = useState('');
    const [careToBeTaken, setCareToBeTaken] = useState('');

    useEffect(() => {
        if (data) {
            setMedicine(data.medicine || '');
            setCareToBeTaken(data.careToBeTaken|| '');
        }
    }, [data]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const finalData={...data,medicine,careToBeTaken}
          const updateData=  await completeConsulatationReq(finalData);
          if(updateData)
          {
            navigate(-1); 
          }
        } catch (error) {
            console.error("Error updating consultation:", error);
           
        }
    };

    return (
        <div className="container">
            <h2>Edit Consultation</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="medicine">Medicine</label>
                    <textarea
                        id="medicine"
                        className="form-control"
                        rows="3"
                        value={medicine}
                        onChange={(e) => setMedicine(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="careToBeTaken">Care to be Taken</label>
                    <textarea
                        id="careToBeTaken"
                        className="form-control"
                        rows="3"
                        value={careToBeTaken}
                        onChange={(e) => setCareToBeTaken(e.target.value)}
                    />
                </div>
                <button type="submit" className="btn btn-primary">Update</button>
            </form>
        </div>
    );
}
