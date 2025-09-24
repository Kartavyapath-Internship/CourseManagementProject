import { Route, Routes } from "react-router-dom";
import AdminLayout from "./Components/AdminLayout";
import CourseCoordinatorLayout from "./Components/CourseCoordinatorLayout";
import PageNotFound from "./Pages/PageNotFound";
import CourseType from "./Pages/CourseType";
import Infrastructure from "./Pages/Infrastructure";
import Sessions from "./Pages/Sessions";
import CourseGroup from "./Pages/CourseGroup";
import CoursePage from "./Pages/CoursePage";
import SubjectPage from "./Pages/SubjectPage";
import SectionPage from "./Pages/SectionPage";
import TopicPage from "./Pages/TopicPage";
import SchedulePage from "./Pages/SchedulePage";
import RecordedVideo from "./Pages/RecordedVideo";
import StudentPage from "./Pages/StudentPage";

function App() {
  return (
    <Routes>
      {/* Default Login */}

      {/* Admin Layout */}

      <Route element={<AdminLayout />}>
        <Route path="/course-type" element={<CourseType />} />
        <Route path="/infrastructure" element={<Infrastructure />} />
        <Route path="/course" element={<CoursePage />} />
        <Route path="/subject" element={<SubjectPage />} />
        <Route path="/sections/:subjectId" element={<SectionPage />} />
        <Route path="/topics/:sectionId" element={<TopicPage />} />
        <Route path="/schedule" element={<SchedulePage />} />
        <Route path="/student" element={<StudentPage />} />
      </Route>

      {/* Coordinator Routes */}

      <Route element={<CourseCoordinatorLayout />}>
        <Route path="/sessions" element={<Sessions />} />
        <Route path="/course-group" element={<CourseGroup />} />
        <Route path="/schedule" element={<SchedulePage />} />
        <Route path="/recorded-video" element={<RecordedVideo />} />
      </Route>

      {/* Fallback */}
      <Route path="*" element={<PageNotFound />} />
    </Routes>
  );
}

export default App;
