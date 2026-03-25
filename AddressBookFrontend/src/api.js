const BASE_URL = "http://localhost:8080/contacts";

export const getContacts = async () => {
  const res = await fetch(BASE_URL);
  return res.json();
};

export const addContact = async (contact) => {
  await fetch(BASE_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(contact)
  });
};

export const deleteContact = async (name) => {
  await fetch(`${BASE_URL}/${name}`, {
    method: "DELETE"
  });
};

export const sortByCity = async () => {
  const res = await fetch(`${BASE_URL}/sort/city`);
  return res.json();
};

export const sortByZip = async () => {
  const res = await fetch(`${BASE_URL}/sort/zip`);
  return res.json();
};
