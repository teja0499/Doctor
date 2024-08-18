import React, { useState, useEffect } from 'react'
import { approved_doctor, get_new_doctor } from '../Service/api'

export default function NewDoctor() {
    const [doctorData, setDoctorData] = useState([])
    const [info, setInfo] = useState(false);
    const [doctor, setDoctor] = useState();
    const getDoctors = async () => {
        try {
            const data = await get_new_doctor()
            setDoctorData(data)
            console.log(data);

        } catch (error) {

        }
    }
    const showInfo = (data) => {
        console.log(data);

        setInfo(true);
        setDoctor(data);
    }

    const isApprove = (data, flag) => {
       
        try {
         const doctorData = {
             ...data,
             adminApprove: flag,
         }
         const newData=approved_doctor(doctorData)
         getDoctors()
        } catch (error) {
         
        }
 
     }

    useEffect(() => {
        getDoctors()
    }, [])
    return (
        <div className='container'>
            {
                doctorData.map((data, index) => {
                    return (
                        <NewDoctorCard key={index} doctor={data} isApprove={isApprove}/>
                    )
                })
            }
        </div>
    )
}


export const NewDoctorCard = (props) => {
    const { name, did, specialty, } = props.doctor;
    const { showInfo ,isApprove} = props

   
    return (
        <div>
            <div className="card" style={{ width: "18rem" }}>
                <img src="..." className="card-img-top" alt="..." />
                <div className="card-body">
                    <h5 className="card-title">Dr. {name}</h5>
                    <h6 className="card-title">{specialty}</h6>
                    <button className="btn btn-primary" onClick={() => showInfo(props.doctor)}>
                        Doctor Info
                    </button>
                    <button className="btn btn-primary" onClick={() => isApprove(props.doctor,true)}>
                        Approve
                    </button>
                    <button className="btn btn-primary" onClick={() => isApprove(props.doctor,false)}>
                        Reject
                    </button>
                </div>
            </div>

        </div>
    )
}

