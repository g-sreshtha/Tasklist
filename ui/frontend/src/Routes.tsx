// Routes.tsx
import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import App from "./Components/App";
import View from "./Components/View";
// import { Task } from "./Task";
const Routie: React.FC = () => {
  return (
    <Routes>
      <Route path="/home" element={<App />} />
      <Route path="/view" element={<View />} />
    </Routes>
  );
};

export default Routie;
