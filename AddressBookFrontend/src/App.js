import React, { useEffect, useState } from "react";
import AddContact from "./components/AddContact";
import ContactList from "./components/ContactList";
import { getContacts, deleteContact, sortByCity, sortByZip} from "./api";

function App() {

  const [contacts, setContacts] = useState([]);

  const fetchData = async () => {
    const data = await getContacts();
    setContacts(data);
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleDelete = async (name) => {
    await deleteContact(name);
    fetchData();
  };

  const handleSortCity = async () => {
    const data = await sortByCity();
    setContacts(data);
  };

  const handleSortZip = async () => {
    const data = await sortByZip();
    setContacts(data);
  };

  return (
    <div style={{ textAlign: "center" }}>

      <h1>Address Book</h1>

      <AddContact refresh={fetchData} />

      <button onClick={handleSortCity}>
        Sort by City
      </button>

      <button onClick={handleSortZip}>
        Sort by zip
      </button>

      <ContactList contacts={contacts} onDelete={handleDelete} />

    </div>
  );
}

export default App;

