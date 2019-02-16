import { GET_TABLES } from "../action/types";

const initialState = {
  tables: [],
  table: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_TABLES:
      return {
        ...state,
        tables: action.payload
      };
    default:
      return state;
  }
}
