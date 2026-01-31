import axios from "axios";

const axiosClient = axios.create({
    baseURL: "https://coffie-ai-coach.onrender.com/api",
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
