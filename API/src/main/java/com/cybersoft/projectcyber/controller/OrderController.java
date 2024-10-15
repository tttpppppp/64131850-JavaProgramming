package com.cybersoft.projectcyber.controller;

import com.cybersoft.projectcyber.payload.request.OrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @PostMapping
    public ResponseEntity<?> order(@RequestBody OrderRequest orderRequest) {

        return new ResponseEntity<>("" , HttpStatus.OK);
    }
}
