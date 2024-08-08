//Link Buttons

import React from "react";
import { Link } from "react-router-dom";

interface LinkButtonProps {
  title: string;
}

const LinkButton: React.FC<LinkButtonProps> = ({ title }) => {
  return (
    <>
      <Link to={`/${title.toLowerCase()}`}>{title.toUpperCase()}</Link>
    </>
  );
};

export default LinkButton;
