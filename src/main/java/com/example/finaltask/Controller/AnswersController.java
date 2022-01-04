package com.example.finaltask.Controller;

import com.example.finaltask.Models.Parser;
import com.example.finaltask.Models.Transactions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class AnswersController {
    @GetMapping("/answers")
    public String getAnswers(){
        return "answers_page";
    }


    public List<Double> answerish(double id){
        List<Long> ClinetIDs;
        List<Double> Ammounts;
        List<Double> needed = new ArrayList<>();
        Parser p = new Parser();
        ClinetIDs = p.getClients();
        Ammounts = p.getAmounts();
        for (int i= 0; i < ClinetIDs.size(); i++){
            if (ClinetIDs.get(i) == id){
                needed.add(Ammounts.get(i));
            }
        }
        double max = Collections.max(needed);
        int max_n = 0;
        double num = 0;
        for (int i= 0; i < needed.size(); i++){
            needed.set(i, Math.abs(needed.get(i)));
            if (Collections.frequency(needed, needed.get(i)) > max_n){
                max_n = Collections.frequency(needed, needed.get(i));
                num = needed.get(i);
            }
        }
        List<Double> out = new ArrayList<>();
        out.add(max);
        out.add(num);
        out.add(Double.valueOf(max_n));
        return needed;
    }
    @PostMapping
    public String getTransactionsPage(Model model){
        List<Double> nums = new ArrayList<>();
        nums = answerish(1);
        model.addAttribute("nums", nums);
        return "redirect:/Transactions_page";
    }
}
