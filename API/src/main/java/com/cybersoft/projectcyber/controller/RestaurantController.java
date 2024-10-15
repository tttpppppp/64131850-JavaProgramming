package com.cybersoft.projectcyber.controller;

import com.cybersoft.projectcyber.payload.ReponseData;
import com.cybersoft.projectcyber.payload.request.RestaurantRequest;
import com.cybersoft.projectcyber.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<?> insertRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
        ReponseData reponseData = new ReponseData();
        if(restaurantService.insertRestaurant(restaurantRequest)) {
            reponseData.setMessage("Restaurant inserted successfully");
            return new ResponseEntity<>(reponseData, HttpStatus.CREATED);
        }
        reponseData.setMessage("Restaurant insert failed");
        return new ResponseEntity<>(reponseData , HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getRestaurantHomePage(){
        ReponseData reponseData = new ReponseData();
        if(!restaurantService.getRestaurantHomePage().isEmpty()){
            reponseData.setMessage("Restaurant get home page successfully");
            reponseData.setData(restaurantService.getRestaurantHomePage());
            return new ResponseEntity<>(reponseData, HttpStatus.OK);
        }
        reponseData.setMessage("Restaurant get home page failed");
        return new ResponseEntity<>(reponseData, HttpStatus.OK);
    }
}
