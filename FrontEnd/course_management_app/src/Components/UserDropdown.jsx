export default function UserDropdown({ onClose }) {
  return (
    <div className="absolute right-0 mt-2 w-40 bg-white text-gray-800 shadow-lg rounded-md">
      <button
        className="block w-full text-left px-4 py-2 hover:bg-gray-100"
        onClick={onClose}
      >
        Profile
      </button>
      <button
        className="block w-full text-left px-4 py-2 hover:bg-gray-100"
        onClick={onClose}
      >
        Settings
      </button>
      <button
        className="block w-full text-left px-4 py-2 hover:bg-gray-100"
        onClick={onClose}
      >
        Logout
      </button>
    </div>
  );
}
