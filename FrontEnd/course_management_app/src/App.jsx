import { Route, Routes } from "react-router-dom";
import AdminLayout from "./Components/AdminLayout";
import CourseCoordinatorLayout from "./Components/CourseCoordinatorLayout";
import PageNotFound from "./Pages/PageNotFound";
import CourseType from "./Pages/CourseType";
import Infrastructure from "./Pages/Infrastructure";
import Sessions from "./Pages/Sessions";

function App() {
  return (
    <Routes>
      {/* Default Login */}

      {/* Admin Layout */}

      <Route element={<AdminLayout />}>
        <Route path="/course-type" element={<CourseType />} />
        <Route path="/infrastructure" element={<Infrastructure />} />
      </Route>

      {/* Coordinator Routes */}

      <Route element={<CourseCoordinatorLayout />}>
        <Route path="/sessions" element={<Sessions />} />
      </Route>

      {/* Fallback */}
      <Route path="*" element={<PageNotFound />} />
    </Routes>
  );
}

export default App;
