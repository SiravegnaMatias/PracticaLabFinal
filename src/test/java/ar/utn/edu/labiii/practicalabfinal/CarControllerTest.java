package ar.utn.edu.labiii.practicalabfinal;

import ar.utn.edu.labiii.practicalabfinal.controllers.CarController;
import ar.utn.edu.labiii.practicalabfinal.dtos.car.CarRequestDto;
import ar.utn.edu.labiii.practicalabfinal.dtos.car.CarResponseDto;
import ar.utn.edu.labiii.practicalabfinal.services.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void testCreateCar() throws Exception {
        // Mock the request body
        CarRequestDto carRequestDto = new CarRequestDto();
        carRequestDto.setBrand("BMW");
        carRequestDto.setModel("M8");

        // Mock the response
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setId(1L);
        carResponseDto.setBrand("BMW");
        carResponseDto.setModel("M8");

        // Mock the service method
        Mockito.when(carService.createCar(Mockito.any(CarRequestDto.class))).thenReturn(carResponseDto);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(carRequestDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value("BMW"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("M8"));
    }

    // Helper method to convert object to JSON string
    private static String asJsonString(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}