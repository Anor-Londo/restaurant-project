import React, { Component } from "react";

class TableItem extends Component {
  render() {
    const { table } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <h3>Number: {table.tableNumber}</h3>
            </div>
            <div className="col-2">
              <h3>Capacity: {table.capacity}</h3>
            </div>
            <div className="col-lg-2 col-md-4 col-8">
              <h4>Cost: {table.cost}</h4>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default TableItem;
