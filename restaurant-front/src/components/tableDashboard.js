import React, { Component } from "react";
import TableItem from "./tableItem";
import { connect } from "react-redux";
import { getTables } from "../action/projectActions";
import PropTypes from "prop-types";

class TableDashboard extends Component {
  componentDidMount() {
    this.props.getTables();
  }

  render() {
    const { tables } = this.props.table;

    return (
      <div className="tables">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Tables</h1>
              <hr />
              {tables.map(table => (
                <TableItem key={table.id} table={table} />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

TableDashboard.propTypes = {
  table: PropTypes.object.isRequired,
  getTables: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  table: state.table
});

export default connect(
  mapStateToProps,
  { getTables }
)(TableDashboard);
