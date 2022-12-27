package net.javaguides.springboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.var;
import net.javaguides.springboot.dto.IrrigationConfigurationDto;
import net.javaguides.springboot.dto.LandDto;
import net.javaguides.springboot.entity.Land;
import net.javaguides.springboot.service.LandService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/land")
public class LandController {
    private final LandService landService;
    private final ModelMapper mapper;

    @GetMapping("")
    public ResponseEntity<List<LandDto>> gets(){
        List<Land> lands = landService.getAll();

        List<LandDto> dto = lands.stream().map(m-> mapper.map(m, LandDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("{landId}")
    public ResponseEntity<Land> getById(@PathVariable Long landId){
        Land drone = landService.getById(landId);
        return new ResponseEntity<>(drone,HttpStatus.OK);
    }

    @PostMapping("/configure/{landId}")
    public ResponseEntity<LandDto> configure(@Valid @RequestBody IrrigationConfigurationDto model, @PathVariable Long landId){
        Land land = landService.configure(model,landId);
        var landDTO = mapper.map(land, LandDto.class);
        return new ResponseEntity<>(landDTO,HttpStatus.OK);
    }

    @PutMapping("{landId}")
    public ResponseEntity<Land> update(@Valid @RequestBody LandDto model,@PathVariable Long landId){
        Land drone = landService.update(model,landId);
        return new ResponseEntity<>(drone,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Land> add(@Valid @RequestBody LandDto model){
        Land drone = landService.add(model);
        return new ResponseEntity<>(drone,HttpStatus.OK);
    }
}
