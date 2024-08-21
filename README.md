data base link: jdbc:mysql://doctor.czq28igskko6.eu-north-1.rds.amazonaws.com:3306/Doctor?createDatabaseIfNotExist=true
username=admin
password=Tejas$123

## Features
- Doctor, Patient, and Admin user roles
- Doctor registration with profile management
- Patient registration with medical history
- Doctor's multi-step consultation form
- Prescription generation and PDF export


here patient can ragister easily but doctor will not ragister till admin aprove 
when doctor register itself then one req go to admin and admin have to writes to its req have to approve or reject 

## Technology Stack
- **Frontend:** React.js, Bootstrap
- **Backend:** Spring Boot, MySQL
- **Database:** MySQL
- **PDF Generation:** [Library/Tool Used for PDF]

##front-end Routes Overview:
/
Component: PatientLogin
Description: The landing page for the application where patients can log in.

/doctor_login
Component: DoctorLogin
Description: Login page for doctors.

/doctor_register_form
Component: DoctorRegisterform
Description: Registration form for doctors to sign up.

/user_ragister_form
Component: PatientRagisterForm
Description: Registration form for patients to sign up.

/all_doctor
Component: AllDoctor
Description: Page displaying a list of all doctors in a grid of cards.

/doctor_card
Component: DoctorCard
Description: Displays individual doctor details on a card.

/prescription
Component: Prescription
Description: Prescription page for doctors to write and send prescriptions.

/consultation_form
Component: ConsultationForm
Description: Multi-step consultation form filled by patients.

/consultation_history
Component: ConsultationHisory
Description: Displays the consultation history for a doctor.

/consultation_req
Component: ConsultationReq
Description: Page showing requests for consultations.

/edit_consult
Component: EditConsult
Description: Page where doctors can edit consultation details.

/user_consultation_history
Component: UserConsultationHistory
Description: Displays the consultation history for a patient.

/consultation-details
Component: ConsultationDetailsPage
Description: Page to view detailed consultation information.

/admin_register_form
Component: AdminRegisterForm
Description: Registration form for the admin.

/admin_login
Component: AdminLoginForm
Description: Login page for the admin.

/new_doctor
Component: NewDoctor
Description: Page for admins to add a new doctor.

/all_patients
Component: AllPatients
Description: Page for admins to view and manage all patients.

/all_prescription
Component: GetAllprescription
Description: Page for doctors to view all prescriptions.

backend route  api Overview:

Endpoint: /
Method: GET
Description: A test endpoint that returns a simple "hello Tejas" message. Useful for verifying that the server is running.


end point : /admin/login
Method: POST
Description: This API route handles admin login by accepting the email and password as headers. It validates the credentials and returns the admin details if successful. If the credentials are incorrect, it returns an UNAUTHORIZED status.

end point : /admin/sign_up
Method: POST
Description: This API route allows for admin registration by accepting a new admin's details in the request body. It saves the new admin to the database and returns a CREATED status if successful. If there is an error, it returns an UNAUTHORIZED status.

Endpoint: /admin/get_users
Method: GET
Description: This API route allows an admin to retrieve a list of all registered patients. It returns the list of patients with a 200 OK status. If an error occurs, it returns an UNAUTHORIZED status.

Endpoint: /admin/get_new_doctor
Method: GET
Description: This API route retrieves a list of new doctors who have registered but have not yet been approved. It returns the list of new doctors with a 200 OK status. If an error occurs, it returns an UNAUTHORIZED status.

Endpoint: /admin/approved_doctor
Method: PUT
Description: This API route allows an admin to approve a doctor by updating their details. The doctor’s information is provided in the request body. If successful, it returns the updated doctor object with a 200 OK status. In case of an error, it returns an UNAUTHORIZED status.

Endpoint: /admin/get_all_prescription
Method: GET
Description: This API route retrieves all consultations (prescriptions) for admin purposes. It returns a list of all consultations with a 200 OK status. If there is an issue, it returns an UNAUTHORIZED status.


Endpoint: /patient/sign_up
Method: POST
Description: This API route allows for patient registration by accepting a multipart file (profile picture) and a JSON string (patient details) as request parameters. The JSON string is deserialized into a Patient object, which is then saved to the database. If successful, it returns the saved patient object with a 200 OK status. In case of an error, it returns an UNAUTHORIZED status.

Endpoint: /patient/login
Method: POST
Description: This API route handles patient login by accepting the email and password as headers. It validates the credentials and returns the patient details if successful. If the credentials are incorrect or there is an issue, it returns an UNAUTHORIZED status.


Endpoint: /doctor/sign_up
Method: POST
Description: This API route allows for doctor registration by accepting a multipart file (profile picture) and a JSON string (doctor details) as request parameters. The JSON string is deserialized into a Doctor object, which is then saved to the database. If successful, it returns the saved doctor object with a 201 CREATED status. In case of an error, it returns an UNAUTHORIZED status.

Endpoint: /doctor/login
Method: POST
Description: This API route handles doctor login by accepting the email and password as headers. It validates the credentials and returns the doctor details if successful. If the credentials are incorrect or there is an issue, it returns an UNAUTHORIZED status.

Endpoint: /get_all_doctor
Method: GET
Description: This API route retrieves a list of all registered doctors from the database. It returns the list of doctors with a 200 OK status. If an error occurs, it returns an UNAUTHORIZED status.


Endpoint: /save-consultation
Method: POST
Description: This API route saves a new consultation. The consultation details are provided in the request body. It returns the saved consultation with a 200 OK status. In case of an error, it returns an UNAUTHORIZED status.

Endpoint: /doctor/consultation_history/{did}
Method: GET
Description: This API route retrieves the consultation history for a doctor identified by did (doctor ID). It returns a list of consultations with a 200 OK status. If there is an issue, it returns an UNAUTHORIZED status.

Endpoint: /doctor/consultation_req/{did}
Method: GET
Description: This API route retrieves pending consultation requests for a doctor identified by did (doctor ID). It returns a list of pending consultations where doctorView is false. If there is an issue, it returns an UNAUTHORIZED status.

Endpoint: /update-consultation
Method: PUT
Description: This API route updates an existing consultation. The updated consultation details are provided in the request body. It returns the updated consultation with a 200 OK status. If there is an error, it returns an UNAUTHORIZED status.

Endpoint: /get-consultation/{pid}
Method: GET
Description: This API route retrieves consultations for a patient identified by pid (patient ID). It returns a list of consultations with a 200 OK status. If there is an issue, it returns an UNAUTHORIZED status.
