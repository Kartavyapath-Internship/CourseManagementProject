import { useNavigate } from "react-router-dom";

export default function PageNotFound() {
  const navigate = useNavigate();

  const goBack = () => {
    navigate(-1); // 🔥 go back to previous page
  };

  return (
    <div className="flex flex-col items-center justify-center h-screen bg-gray-100">
      <h1 className="text-6xl font-bold text-violet-600 mb-4">404</h1>
      <p className="text-xl text-gray-700 mb-6">Oops! Page Not Found</p>

      <button
        onClick={goBack}
        className="mt-6 px-6 py-2 bg-violet-600 text-white rounded-lg shadow-md hover:bg-violet-700 transition"
      >
        Go Back
      </button>
    </div>
  );
}
