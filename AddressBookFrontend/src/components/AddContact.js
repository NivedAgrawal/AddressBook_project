import React, { useState } from "react";
import { addContact } from "../api";

function AddContact({ refresh }) {

  const [contact, setContact] = useState({
    firstName: "",
    lastName: "",
    city: "",
    state: "",
    phoneNumber: "",
    zip: "",
    address: "",
    email: ""
  });

  const handleChange = (e) => {
    setContact({ ...contact, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await addContact(contact);
    refresh();
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="firstName" placeholder="First Name" onChange={handleChange} />
      <input name="lastName" placeholder="Last Name" onChange={handleChange} />
      <input name="city" placeholder="City" onChange={handleChange} />
      <input name="state" placeholder="State" onChange={handleChange} />
      <input name="phoneNumber" placeholder="Phone" onChange={handleChange} />
      <input name="zip" placeholder="Zip" onChange={handleChange} />
      <input name="address" placeholder="Address" onChange={handleChange} />
      <input name="email" placeholder="Email" onChange={handleChange} />
      <button type="submit">Add Contact</button>
    </form>
  );
}

export default AddContact;
