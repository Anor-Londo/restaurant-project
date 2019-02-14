import { combineReducers } from "redux";
import errorReduser from "./errorReduser";

export default combineReducers({
  errors: errorReduser
});
