import { Outlet } from "react-router-dom";
import { useState, useEffect } from "react";
import Header from "./Header";
import Sidebar from "./Sidebar";
import Footer from "./Footer";

export default function CourseCoordinatorLayout() {
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  // Collapse sidebar on smaller desktop screens (<1200px)
  useEffect(() => {
    const handleResize = () => {
      if (window.innerWidth < 1200) setIsSidebarOpen(false);
      else setIsSidebarOpen(true);
    };

    window.addEventListener("resize", handleResize);
    handleResize(); // initial check
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  const toggleSidebar = () => setIsSidebarOpen(!isSidebarOpen);

  // Menu items for course coordinator (can be customized)
  const menuItems = [
    { to: "/assigned-courses", label: "Assigned Courses" },
    { to: "/modules", label: "Modules" },
    { to: "/course-group", label: "Course Group" },
    { to: "/sessions", label: "Sessions" },
    { to: "/students", label: "Students" },
    { to: "/schedule", label: "Reports" },
  ];

  return (
    <div className="flex flex-col w-screen h-screen">
      <Header
        title="Coordinator Dashboard"
        toggleSidebar={toggleSidebar}
        isSidebarOpen={isSidebarOpen}
      />

      <div className="flex flex-1 bg-slate-300 overflow-hidden">
        <Sidebar menuItems={menuItems} isSidebarOpen={isSidebarOpen} />

        <main className="flex-grow p-6 bg-white overflow-y-auto">
          <Outlet />
        </main>
      </div>

      <Footer />
    </div>
  );
}
