package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("/userAccount")
    public String getAccountDetails(){
        return "Here is the account details of the account";
    }
}
