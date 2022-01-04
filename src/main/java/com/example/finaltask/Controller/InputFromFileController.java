package com.example.finaltask.Controller;

import com.example.finaltask.Models.Parser;
import com.example.finaltask.Models.Transactions;
import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.lang.reflect.Parameter;

@Controller
public class InputFromFileController {
    @Autowired
    private TransactionsRepository tranrep;

    @GetMapping("/inputFromFile")
    public String getFromFile(){
        return "InputFromFile";
    }

    @PostMapping("/inputFromFile")
    public String AddData(Transactions tran) throws IOException {
        Parser p = new Parser();
        p.UseScanner();
        return "redirect:/inputFromFile";
    }
}
