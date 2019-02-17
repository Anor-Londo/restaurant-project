import React from "react";
import { Link } from "react-router-dom";

const CreateBookingBottun = () => {
  return (
    <React.Fragment>
      <Link to="/addBooking" className="btn btn-lg btn-info">
        Create a Booking
      </Link>
    </React.Fragment>
  );
};
export default CreateBookingBottun;
