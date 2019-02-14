import React, { Component } from "react";
import "./App.css";
import AddGuest from "./project/AddGuest";
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Provider } from "react-redux";
import store from "./store";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <div className="App">
          <Router>
            <div className="App">
              <h1>Hello!</h1>
              <Route exact path="/addGuest" component={AddGuest} />
            </div>
          </Router>
        </div>
      </Provider>
    );
  }
}

export default App;
