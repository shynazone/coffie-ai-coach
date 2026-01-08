import axios from "axios";

const axiosClient = axios.create({
    baseURL: "http://localhost:8080/api",
    headers: {
        "Content-Type": "application/json"
    }
});

// Optional: global response error handling
axiosClient.interceptors.response.use(
    (response) => response,
    (error) => {
        return Promise.reject(error.response?.data || error);
    }
);

export default axiosClient;
