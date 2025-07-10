package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/userBalance")
    public String getBalanceDetails(){
        return "Here is the balance of user";
    }
}
