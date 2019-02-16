import { GET_GUESTS } from "../action/types";

const initialState = {
  guests: [],
  guest: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_GUESTS:
      return {
        ...state,
        guests: action.payload
      };
    default:
      return state;
  }
}
