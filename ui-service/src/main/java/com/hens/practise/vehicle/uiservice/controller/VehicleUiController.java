package com.hens.practise.vehicle.uiservice.controller;

import com.hens.practise.vehicle.uiservice.model.Vehicle;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/vehicles")
public class VehicleUiController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/find/findall")
    public String getAllVehicles(Model model) {

        String findAllUri = "http://data-service/vehicles/findall";
        ResponseEntity<List<Vehicle>> responseEntity =
                restTemplate.exchange(findAllUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Vehicle>>(){});

        model.addAttribute("vehicles", responseEntity.getBody());

        return "vehiclepage";
    }

    @GetMapping("/find/findbystatus")
    public String getVehicleByStatus(@RequestParam("status") String status,
                                     Model model) {

        if (StringUtils.isNotEmpty(status)) {
            String uri = "http://data-service/vehicles/status/" + status;
            ResponseEntity<List<Vehicle>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Vehicle>>() {
            });

            model.addAttribute("vehicels", responseEntity.getBody());
        }

        return "vehiclepage";
    }
}
