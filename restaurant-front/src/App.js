import React, { Component } from "react";
import "./App.css";
import AddGuest from "./project/AddGuest";
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Provider } from "react-redux";
import store from "./store";
import Dashboard from "./components/dashboard";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./components/header";
import TableDashboard from "./components/tableDashboard";
import TableItem from "./components/tableItem";
import BookingDashboard from "./components/bookingDashboard";
import AddBooking from "./project/AddBooking";
import Landing from "./components/Landing";
import Register from "./components/UserManagement/Register";
import Login from "./components/UserManagement/Login";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            {
              //Public Routes
            }

            <Route exact path="/" component={Landing} />
            <Route exact path="/register" component={Register} />
            <Route exact path="/login" component={Login} />
            {
              //Private Routes
            }
            <Route exact path="/dashboard" component={Dashboard} />
            <Route exact path="/tableDashboard" component={TableDashboard} />
            <Route
              exact
              path="/bookingDashboard"
              component={BookingDashboard}
            />
            <Route exact path="/addGuest" component={AddGuest} />
            <Route exact path="/addBooking" component={AddBooking} />
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
