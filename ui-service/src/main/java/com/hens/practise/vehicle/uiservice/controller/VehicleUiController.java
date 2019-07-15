package com.hens.practise.vehicle.uiservice.controller;

import com.hens.practise.vehicle.uiservice.model.Vehicle;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        addCustomersToModel(model);

        return "vehiclepage";
    }

    @GetMapping("/find/findbystatus")
    public String getVehicleByStatus(@RequestParam("status") String status,
                                     Model model) {

        if (StringUtils.isNotEmpty(status)) {

            String uri = "http://data-service/vehicles/statuses?status=" + status;
            ResponseEntity<List<Vehicle>> responseEntity =
                    restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Vehicle>>() {});

            model.addAttribute("vehicles", responseEntity.getBody());
        }

        addCustomersToModel(model);

        return "vehiclepage";
    }

    @GetMapping("/find/findbycustomer")
    public String getVehiclesByCustomer(@RequestParam("customer") String customer,
                                        Model model) {

        if (StringUtils.isNotEmpty(customer)) {

            String uri = "http://data-service/vehicles/customers?customer=" + customer;
            ResponseEntity<List<Vehicle>> responseEntity =
                    restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Vehicle>>() {});

            model.addAttribute("vehicles", responseEntity.getBody());
        }

        addCustomersToModel(model);

        return "vehiclepage";
    }

    private void addCustomersToModel(Model model) {

        String uri = "http://data-service/vehicles/customers/all";

        ResponseEntity<List<String>> responseEntity =
                restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});

        model.addAttribute("customers", responseEntity.getBody());
    }
}
