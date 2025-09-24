import axios from "axios";

const BASE_URL = "http://localhost:9090";

export const getAllStudents = () => axios.get(`${BASE_URL}/students`);
export const deleteStudent = (id) => axios.delete(`${BASE_URL}/students/${id}`);
export const addStudent = (data) => axios.post(`${BASE_URL}/students`, data);
export const updateStudent = (id, data) =>
  axios.put(`${BASE_URL}/students/${id}`, data);

// dropdowns
export const getCourses = () => axios.get(`${BASE_URL}/api/courses`);
export const getBatches = () => axios.get(`${BASE_URL}/batchcycle/getall`);
export const getGroups = () => axios.get(`${BASE_URL}/coursegroup`);
