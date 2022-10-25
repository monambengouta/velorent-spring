package com.example.velorent.Controller;

import com.example.velorent.Entity.Velorent;
import com.example.velorent.Service.VelorentService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("velorent")
public class VelorentController {

    public VelorentService velorentService;
    public RestTemplate restTemplate;
    private Environment environment;

    public VelorentController(VelorentService velorentService, RestTemplate restTemplate, Environment environment) {
        this.velorentService = velorentService;
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @PostMapping
    public Velorent rentVelorent(@RequestBody Velorent velorent) {
        return velorentService.rentVelorent(velorent);
    }
    @GetMapping("/{id}")
    public Optional<Velorent> getVelorent(@PathVariable("id") Long idVelorent) {
        return velorentService.getVelorent(idVelorent);
    }
    @GetMapping
    public List<Velorent> getAllVelorent() {
        return velorentService.getAllVelorent();
    }

    @GetMapping("/bystartdate}")
    public List<Velorent> getVelorentsByStartDate(@RequestBody Date date) {
        return velorentService.getVelorentsByDate(date);
    }
    @GetMapping("/byenddate}")
    public List<Velorent> getVelorentsByendDate(@RequestBody Date date) {
        return velorentService.getVelorentsByDate(date);
    }
    @PatchMapping
    public Velorent updateVelorent(Velorent velorent) {
        return velorentService.updateVelorent(velorent);
    }

    @DeleteMapping
    public void cancelVelorent(Long idVelorent) {
        velorentService.cancelVelorent(idVelorent);
    }

    @GetMapping("/user/{userId}")
    public List<Velorent> getVelorentsByuserId(@PathVariable("userId") Long userId){

        // Object user =  restTemplate.getForObject(environment.getProperty("USER__URL_MICROSERVICE"+"/user/"+userId), Object.class);
        return velorentService.getVelorentsByuserId(userId);
    }
}
