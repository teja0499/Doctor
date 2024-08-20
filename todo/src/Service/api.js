import axios from 'axios';



export const test = async () => {
    const response = await axios.get('http://192.168.1.35:8081/', {
      
    });
    // console.log(response.data);
    console.log("working");
    

   
};
export const doctor_login = async (data) => {
    console.log(data);
    
        const response = await axios.post('http://192.168.1.35:8081/doctor/login',{},{
            headers: {
                'Content-Type': 'application/json',
                "email":data.email,
                "password":data.password
            },
        });
        return response.data;
};

export const doctor_Ragister = async (data,profile) => {
    console.log(data);
    const formData = new FormData();
    formData.append('file', profile);

    formData.append('data', JSON.stringify(data));
        const response = await axios.post('http://192.168.1.35:8081/doctor/sign_up',formData,{
            headers: {
                'Content-Type': 'multipart/form-data',
            },
        });
        return response.data;
};

export const getAllDoctor = async () => {
    // console.log(data);
    
        const response = await axios.get('http://192.168.1.35:8081/get_all_doctor');
        console.log(response.data);
        
        return response.data;
};

export const patient_Ragister = async (data,profile) => {
  
    const formData = new FormData();
    formData.append('file', profile);

    formData.append('data', JSON.stringify(data));
    
        const response = await axios.post('http://192.168.1.35:8081/patient/sign_up',formData, {
            headers: {
                'Content-Type': 'multipart/form-data',
            },
        });
        return response.data;
};


export const patient_login = async (data) => {
 ;
    
    console.log(data);
    
        const response = await axios.post('http://192.168.1.35:8081/patient/login',{},{
            headers: {
                'Content-Type': 'application/json',
                "email":data.email,
                "password":data.password
            },
        });
        console.log(response.data);

        
        return response.data;
};

export const saveConsultation = async (data) => {
    console.log(data);
    
        const response = await axios.post('http://192.168.1.35:8081/save-consultation',data);
        return response.data;
};


export const getConsulatationHistory = async (did) => {
    // console.log(data);
    
        const response = await axios.get(`http://192.168.1.35:8081/doctor/consultation_history/${did}`);
        console.log(response.data);
        
        return response.data;
};

export const getConsulatationReq = async (did) => {
    // console.log(data);
    
        const response = await axios.get(`http://192.168.1.35:8081/doctor/consultation_req/${did}`);
        console.log(response.data);
        
        return response.data;
};

export const completeConsulatationReq = async (data) => {
   
        console.log(data);
            const response = await axios.put('http://192.168.1.35:8081/update-consultation',data);
            return response.data;
    };

    export const userConsulationHistory = async (id) => {
        console.log(id);
        
            const response = await axios.get(`http://192.168.1.35:8081/get-consultation/${id}`);
            return response.data;
    };

    export const admin_login = async (data) => {
        console.log(data);
        
            const response = await axios.post('http://192.168.1.35:8081/admin/login',{},{
                headers: {
                    'Content-Type': 'application/json',
                    "email":data.email,
                    "password":data.password
                },
            });
            return response.data;
    };

    export const admin_Ragister = async (data) => {
        console.log(data);
        
            const response = await axios.post('http://192.168.1.35:8081/admin/sign_up',data);
            return response.data;
    };

    export const get_new_doctor = async () => {
      
            const response = await axios.get('http://192.168.1.35:8081/admin/get_new_doctor');
            return response.data;
    };

    export const approved_doctor = async (data) => {
      
        const response = await axios.put(`http://192.168.1.35:8081/admin/approved_doctor`,data);
        return response.data;
};

export const getAllUser = async () => {
    // console.log(data);
    console.log("all users");
    
    
        const response = await axios.get('http://192.168.1.35:8081/admin/get_users');
        console.log(response.data);
        
        return response.data;
};

export const getAllprescription = async () => {
    // console.log(data);
    console.log("all users");
    
    
        const response = await axios.get('http://192.168.1.35:8081/admin/get_all_prescription');
        console.log(response.data);
        
        return response.data;
};

