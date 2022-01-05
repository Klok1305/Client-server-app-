package com.example.finaltask.Controller;

import com.example.finaltask.Models.Transactions;
import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private TransactionsRepository tranrep;
    @GetMapping("/trasactions")
    public String getTransactionsPage(Model model){
        //List<Transactions> all = tranrep.findAll();
        List<Transactions> trans = tranrep.returnthing();
        model.addAttribute("trans", trans);
        return "Transactions_page";
    }
}
