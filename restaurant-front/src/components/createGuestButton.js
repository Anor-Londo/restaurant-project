import React from "react";
import { Link } from "react-router-dom";

const CreateGuestBottun = () => {
  return (
    <React.Fragment>
      <Link to="/addGuest" className="btn btn-lg btn-info">
        Create a Guest
      </Link>
    </React.Fragment>
  );
};
export default CreateGuestBottun;
