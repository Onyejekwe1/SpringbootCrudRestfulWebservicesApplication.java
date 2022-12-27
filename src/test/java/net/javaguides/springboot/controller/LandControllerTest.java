package net.javaguides.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.CoreMatchers.is;

import net.javaguides.springboot.dto.LandDto;
import net.javaguides.springboot.entity.Land;
import net.javaguides.springboot.provider.LandData;
import net.javaguides.springboot.service.LandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
//@Transactional
public class LandControllerTest {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    protected ObjectMapper objectMapper;

    @SpyBean
    protected ModelMapper modelMapper;

    @SpyBean
    protected LandService landService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }


    @Test
    void addLand_expectOk() throws Exception {

        LandDto landDto = LandData.getDefaultLandDTO();

        mvc.perform(post("/api/land")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(landDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.serialNumber", is(landDto.getSerialNumber())))
                .andExpect(jsonPath("$.soilType", is(landDto.getSoilType())));

        verify(landService).add(any());
    }

    @Test
    void editLand_expectOk() throws Exception {

        Long id = (long)2;
        LandDto landDto = LandData.getDefaultLandDTO();
        Land land = LandData.getLandFromLandDTO(landDto,id);

        landDto.setSoilType("loamy soil");


        mvc.perform(put("/api/land/"+land.getId())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(landDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.serialNumber", is(landDto.getSerialNumber())))
                .andExpect(jsonPath("$.soilType", is(landDto.getSoilType())));

        verify(landService).update(any(),any());
    }

    @Test
    void getLand_expectOk() throws Exception {

        String url = "/api/land/";

        mvc.perform(get(url))
                .andExpect(status().isOk());

        verify(landService).getAll();
    }
}
