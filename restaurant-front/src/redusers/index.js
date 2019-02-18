import { combineReducers } from "redux";
import errorReduser from "./errorReduser";
import guestReducer from "./guestReducer";
import tableReducer from "./tableReducer";
import securityReducer from "./securityReduser";

export default combineReducers({
  errors: errorReduser,
  guest: guestReducer,
  table: tableReducer,
  security: securityReducer
});
