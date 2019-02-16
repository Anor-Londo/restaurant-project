import React, { Component } from "react";

class GuestItem extends Component {
  render() {
    const { guest } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <h3>{guest.name}</h3>
            </div>
            <div className="col-lg-2 col-md-4 col-8">
              <h4>{guest.phone}</h4>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default GuestItem;
