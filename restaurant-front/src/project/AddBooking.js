import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createBooking } from "../action/projectActions";

class AddBooking extends Component {
  constructor() {
    super();

    this.state = {
      guestId: "",
      tableId: "",
      time: ""
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newBooking = {
      guestId: this.state.guestId,
      tableId: this.state.tableId,
      time: this.state.time
    };

    this.props.createBooking(newBooking, this.props.history);
  }

  render() {
    return (
      <div className="booking">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Create Booking</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Guest ID"
                    name="guestId"
                    value={this.state.guestId}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Table Number"
                    name="tableId"
                    value={this.state.tableId}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Time"
                    name="time"
                    value={this.state.time}
                    onChange={this.onChange}
                  />
                </div>

                <input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                />
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddBooking.propTypes = {
  createBooking: PropTypes.func.isRequired
};

export default connect(
  null,
  { createBooking }
)(AddBooking);
