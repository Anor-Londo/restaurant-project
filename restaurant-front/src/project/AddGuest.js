import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createGuest } from "../action/projectActions";

class AddGuest extends Component {
  constructor() {
    super();

    this.state = {
      name: "",
      phone: ""
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newGuest = {
      name: this.state.name,
      phone: this.state.phone
    };

    this.props.createGuest(newGuest, this.props.history);
  }

  render() {
    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Create Guest</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Guest Name"
                    name="name"
                    value={this.state.name}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Guest's phone"
                    name="phone"
                    value={this.state.phone}
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

AddGuest.propTypes = {
  createProject: PropTypes.func.isRequired
};

export default connect(
  null,
  { createGuest }
)(AddGuest);
