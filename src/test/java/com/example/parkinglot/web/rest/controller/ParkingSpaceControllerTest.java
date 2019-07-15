package com.example.parkinglot.web.rest.controller;

import com.example.parkinglot.bl.parking.ParkingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ParkingSpaceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ParkingService parkingService;

    @InjectMocks
    private ParkingSpaceController parkingSpaceController;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(parkingSpaceController)
                .build();

    }

    @Test
    public void verifyFetchFreeSpacesSuccess() throws Exception {
        Integer mockFreeSpots = 40;

        when(parkingService.fetchAllFreeSpots()).thenReturn(mockFreeSpots);

        mockMvc.perform(get("/v1/parking/spots"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalFreeSpaces").exists())
                .andExpect(jsonPath("$.totalFreeSpaces").value(mockFreeSpots))
                .andDo(print());

        verify(parkingService, times(1)).fetchAllFreeSpots();
        verifyNoMoreInteractions(parkingService);
    }
}
