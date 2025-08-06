
package com.eazybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/userLoan")
    public String getLoanDetails(){
        return "Here is the Loan details of the user";
    }
}
