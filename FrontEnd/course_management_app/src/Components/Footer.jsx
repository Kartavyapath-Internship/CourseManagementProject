export default function Footer() {
  return (
    <footer className="bg-gray-200 text-center p-4 shadow-inner">
      <p className="text-sm text-gray-600">
        © {new Date().getFullYear()} Course Management System. All rights
        reserved.
      </p>
    </footer>
  );
}
