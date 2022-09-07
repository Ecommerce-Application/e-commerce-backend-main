package com.revature.controllers;

import com.revature.dtos.TransactionDto;
import com.revature.models.Transaction;
import com.revature.services.TransactionService;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000" }, allowCredentials = "true")
public class TransactionController {

    private TransactionService ts;


    public TransactionController(TransactionService ts) {
        this.ts = ts;
    }

    @GetMapping("/{id}")
    public Optional<List<Transaction>> findByUserId(@PathVariable("id") int id){

        return ts.findByUserId(id);
    }


    @PostMapping
    public Transaction add(@Valid @RequestBody TransactionDto newTran){

        return ts.add(newTran);

    }




}
