import React, { useEffect, useState } from "react";
import axiosClient from "./api/axiosClient";

function Journal() {
    const [entries, setEntries] = useState([]);
    const [title, setTitle] = useState("");
    const [reflection, setReflection] = useState("");
    const [error, setError] = useState("");

    // useEffect(() => {
    //     fetch("http://localhost:8080/api/journal")
    //         .then((res) => res.json())
    //         .then(setEntries)
    //         .catch(() => setError("Failed to load entries"));
    // }, []);

    useEffect(() => {
        axiosClient
            .get("/journal")
            .then((res) => setEntries(res.data))
            .catch((err) => setError(err.message || "Failed to load entries"));
    }, []);

    // const submitEntry = () => {
    //     fetch("http://localhost:8080/api/journal", {
    //         method: "POST",
    //         headers: {
    //             "Content-Type": "application/json"
    //         },
    //         body: JSON.stringify({ title, reflection })
    //     })
    //         .then(async (res) => {
    //             if (!res.ok) {
    //                 const data = await res.json();
    //                 throw new Error(data.message);
    //             }
    //             return res.json();
    //         })
    //         .then((data) => {
    //             setEntries([...entries, data]);
    //             setTitle("");
    //             setReflection("");
    //             setError("");
    //         })
    //         .catch((err) => setError(err.message));
    // };

    const submitEntry = () => {
        axiosClient
            .post("/journal", { title, reflection })
            .then((res) => {
                setEntries([...entries, res.data]);
                setTitle("");
                setReflection("");
                setError("");
            })
            .catch((err) => setError(err.message));
    };

    return (
        <div style={{ padding: "20px" }}>
            <h2>My Journal</h2>

            {error && <p style={{ color: "red" }}>{error}</p>}

            <input
                placeholder="Title"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
            />
            <br />

            <textarea
                placeholder="Reflection"
                value={reflection}
                onChange={(e) => setReflection(e.target.value)}
            />
            <br />

            <button onClick={submitEntry}>Add Entry</button>

            <hr />

            <ul>
                {entries.map((e, i) => (
                    <li key={i}>
                        <strong>{e.title}</strong>: {e.reflection}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Journal;
