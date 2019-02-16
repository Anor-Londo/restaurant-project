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

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <Route exact path="/dashboard" component={Dashboard} />
            <Route exact path="/tableDashboard" component={TableDashboard} />
            <Route exact path="/addGuest" component={AddGuest} />
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
