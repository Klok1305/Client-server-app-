package com.example.finaltask.Controller;


import com.example.finaltask.Models.Transactions;
import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.util.List;


@Controller
public class AnswersController {
    private final TransactionsRepository tranrep;

    public AnswersController(TransactionsRepository tranrep) {
        this.tranrep = tranrep;
    }

    @GetMapping("/answers")
    public String getAnswers() throws IOException {
        return "answers_page";
    }

    @PostMapping
    public String getTransactionsPage(Model model, @RequestParam(value = "customer_id", required = true) String ID) throws IOException {
        List<Transactions> trans = tranrep.findAllByCustomeridOrderByAmountAmountDesc(Long.valueOf(ID));
        model.addAttribute("trans", trans);
        return "answers_page";
    }
}
