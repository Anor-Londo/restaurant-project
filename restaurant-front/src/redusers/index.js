import { combineReducers } from "redux";
import errorReduser from "./errorReduser";
import guestReducer from "./guestReducer";

export default combineReducers({
  errors: errorReduser,
  guest: guestReducer
});
