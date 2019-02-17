import React, { Component } from "react";
import GuestItem from "./guestItem";
import CreateBookingButton from "./createBookingButton";
import { connect } from "react-redux";
import { getGuests } from "../action/projectActions";
import PropTypes from "prop-types";

class BookingDashboard extends Component {
  render() {
    return (
      <div className="guests">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Bookings</h1>
              <br />
              <CreateBookingButton />
              <br />
              <hr />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default BookingDashboard;
