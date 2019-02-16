import axios from "axios";
import { GET_ERRORS, GET_GUESTS } from "./types";

export const createGuest = (guest, history) => async dispatch => {
  try {
    const res = await axios.post(
      "http://localhost:8090/guest-service/guest/create",
      guest
    );
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const getGuests = () => dispatch => {
  axios.get("http://localhost:8090/guest-service/guest").then(res =>
    dispatch({
      type: GET_GUESTS,
      payload: res.data
    })
  );
};
