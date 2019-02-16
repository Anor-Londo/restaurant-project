import React, { Component } from "react";
import GuestItem from "./guestItem";
import CreateGuestBottun from "./createGuestButton";
import { connect } from "react-redux";
import { getGuests } from "../action/projectActions";
import PropTypes from "prop-types";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getGuests();
  }

  render() {
    const { guests } = this.props.guest;

    return (
      <div className="guests">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Guests</h1>
              <br />
              <CreateGuestBottun />
              <br />
              <hr />
              {guests.map(guest => (
                <GuestItem key={guest.id} guest={guest} />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Dashboard.propTypes = {
  guest: PropTypes.object.isRequired,
  getGuests: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  guest: state.guest
});

export default connect(
  mapStateToProps,
  { getGuests }
)(Dashboard);
