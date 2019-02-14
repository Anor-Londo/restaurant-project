import axios from "axios";
import { GET_ERRORS } from "./types";

export const createGuest = (guest, history) => async dispatch => {
  try {
    const res = await axios.post("http://localhost:8001/guest/create", guest);
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};