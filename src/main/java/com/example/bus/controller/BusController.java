package com.example.bus.controller;

import com.example.bus.model.Bus;
import com.example.bus.repository.BusRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/buses")
public class BusController {

      private final BusRepository busRepository;

    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        var b = busRepository.findAll();
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @GetMapping("/{id_bus}")
    public ResponseEntity<Bus> getById(@PathVariable("id_bus") Long idBus) {
        var b = busRepository.findById(idBus)
                .orElseThrow(() -> new EntityNotFoundException("Can noy find"));
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus){
        var b = busRepository.save(bus);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Bus>> createMultipleBus(@RequestBody List<Bus> buses){
        var b = busRepository.saveAll(buses);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }

    @DeleteMapping ("/{id_bus}")
    public ResponseEntity<Void> deleteById(@PathVariable("id_bus") Long idBus) {
        busRepository.deleteById(idBus);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
