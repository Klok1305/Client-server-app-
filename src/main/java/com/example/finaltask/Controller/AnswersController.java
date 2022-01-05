package com.example.finaltask.Controller;


import com.example.finaltask.Models.Transactions;
import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.io.IOException;
import java.util.List;


@Controller
public class AnswersController {
    private final TransactionsRepository tranrep;

    public AnswersController(TransactionsRepository tranrep) {this.tranrep = tranrep;}

    @GetMapping("/answers")
    public String getAnswers() throws IOException {
        return "answers_page";
    }

    @PostMapping
    public String listie(@ModelAttribute Transactions tran, Model model) throws IOException {
        List<Transactions> trans = tranrep.findAllByCustomer_idOrderByAmountAmountDesc(tran.getCustomer_id());
        model.addAttribute("trans", trans);
        return "redirect:/answers";
    }
}
