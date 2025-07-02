package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/userCards")
    public String getCardsDetails(){
        return "here is the card details of the user";
    }
}
