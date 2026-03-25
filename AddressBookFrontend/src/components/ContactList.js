import React from "react";

function ContactList({ contacts, onDelete }) {

  return (
    <div>
      <h2>Contact List</h2>

      {contacts.map((c, index) => (
        <div key={index} style={{ border: "1px solid gray", margin: "10px", padding: "10px" }}>
          <p>{c.firstName} {c.lastName}</p>
          <p>{c.city}, {c.state}</p>
          <p>{c.phoneNumber}</p>
          <p>{c.zip}</p>
          <p>{c.address}</p>
          <p>{c.email}</p>
          <button onClick={() => onDelete(c.firstName)}>
            Delete
          </button>
        </div>
      ))}

    </div>
  );
}

export default ContactList;
