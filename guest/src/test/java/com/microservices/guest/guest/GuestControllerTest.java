package com.microservices.guest.guest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GuestController.class)
public class GuestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestService guestService;

    @MockBean
    private GuestRepository guestRepository;

    private Gson gson = new GsonBuilder().create();

    private static final String NAME = "Subject";
    private static final String PHONE = "10001000";
    private static final boolean RESERVED = true;

    @Test
    public void createGuest() throws Exception{
        Guest resp = new Guest(NAME, PHONE, RESERVED);
        resp.setId(1000);

        when(guestService.createGuest(anyString(), anyString())).thenReturn(resp);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/guest/create")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(f(resp));

        ResultActions responce = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(f(resp)));
    }

    private String f(Object obj) throws Exception {
        return new ObjectMapper().writeValueAsString(obj);
    }
}

