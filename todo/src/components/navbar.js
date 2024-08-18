import React from 'react'
import { Link,useLocation,useNavigate } from 'react-router-dom'
import PatientLogin from './patient_login'

export default function Navbar() {
    const location = useLocation();
  const { pathname } = location;
  const navigate = useNavigate();
    const onclick=(x)=>{
        console.log(x);   
    }

    const handleLogOut=()=>{
      localStorage.clear();
      navigate('/')

    }

  return (
    <div className='container'>
        <nav className="navbar navbar-expand-lg bg-body-tertiary">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">
      Navbar
    </a>
    <button
      className="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span className="navbar-toggler-icon" />
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      {localStorage.length===0 && <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/'?'active fw-bold':""}`} aria-current="page" to="/">
           User
          </Link>
        </li>
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/doctor_login'?'active fw-bold':""}`} to="/doctor_login">
            Doctor
          </Link>
        </li>
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/admin_login'?'active fw-bold':""}`} to="/admin_login">
           Admin
          </Link>
        </li>
      </ul>}

      {localStorage.getItem("userType")==="doctor" && <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/'?'active fw-bold':""}`} aria-current="page" to="/consultation_req">
          New Consultations 
          </Link>
        </li>
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/doctor_login'?'active fw-bold':""}`} to="/consultation_history">
           History
          </Link>
        </li>
      </ul>}

      {localStorage.getItem("userType")==="user" && <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/'?'active fw-bold':""}`} aria-current="page" to="/all_doctor">
          Doctors
          </Link>
        </li>
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/doctor_login'?'active fw-bold':""}`} to="/user_consultation_history">
           Consultation History
          </Link>
        </li>
      </ul>}

      {localStorage.getItem("userType")==="admin" && <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/'?'active fw-bold':""}`} aria-current="page" to="/new_doctor">
          New Doctor request
          </Link>
        </li>
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/doctor_login'?'active fw-bold':""}`} to="/consultation_history">
           Users
          </Link>
        </li>
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/doctor_login'?'active fw-bold':""}`} to="/all_doctor">
           Doctors
          </Link>
        </li>
        <li className="nav-item">
          <Link className={`nav-link ${pathname==='/doctor_login'?'active fw-bold':""}`} to="/consultation_history">
          Consultation
          </Link>
        </li>
      </ul>}

      
     
    </div>
   {localStorage.length!==0 && <button type="button" className="btn btn-danger"onClick={handleLogOut}>Logout</button>}
  </div>
</nav>
{/* <PatientLogin/> */}
    </div>
  )
}
