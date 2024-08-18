import React from 'react'
import { Link } from 'react-router-dom'

export default function DoctorCard(props) {
    const {name,did,specialty,}=props.doctor;
    const {handleConsult,showInfo}=props
    const onClick=()=>{
        console.log(did,name,specialty);
        
    }
    return (
        <div>
            <div className="card" style={{ width: "18rem" }}>
                <img src="..." className="card-img-top" alt="..." />
                <div className="card-body">
                    <h5 className="card-title">Dr. {name}</h5>
                    <h6 className="card-title">{specialty}</h6>
                  {localStorage.getItem('userType')!=="admin" && <button className="btn btn-primary" onClick={() => handleConsult(props.doctor)}>
                        Consult
                    </button>}
                    <button className="btn btn-primary" onClick={() => showInfo(props.doctor)}>
                        Doctor Info
                    </button>
                </div>
            </div>

        </div>
    )
}
