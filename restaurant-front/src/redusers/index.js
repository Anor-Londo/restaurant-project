import { combineReducers } from "redux";
import errorReduser from "./errorReduser";
import guestReducer from "./guestReducer";
import tableReducer from "./tableReducer";

export default combineReducers({
  errors: errorReduser,
  guest: guestReducer,
  table: tableReducer
});
