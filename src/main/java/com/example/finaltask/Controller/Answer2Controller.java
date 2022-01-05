package com.example.finaltask.Controller;

import com.example.finaltask.Models.Answer2;
import com.example.finaltask.Models.Transactions;
import com.example.finaltask.repo.Answer2Repo;
import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;

@Controller
public class Answer2Controller {
    @Autowired
    private TransactionsRepository tranrep;
    @Autowired
    private Answer2Repo a2;


    //public String getAns2Page() {
    //   return "answer2";
    //}

    //@PostMapping
    @GetMapping("/answer2")
    public String help(Model model) {
        List<Transactions> l = tranrep.findAll();
        Long curId = l.get(0).getCustomer_id();
        List<Long> ids = new ArrayList<>();
        List<Double> maxam = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        List<Transactions> temp = tranrep.ret2(curId);
        Double am = -1.0;
        Integer k = 0;
        List<Double> ams = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            ams.add(abs(temp.get(i).getAmount()));
        }
        for (int i = 0; i < temp.size(); i++) {
            if (Collections.frequency(ams, ams.get(i)) > k) {
                k = Collections.frequency(ams, ams.get(i));
                am = ams.get(i);
            }
        }
        ids.add(curId);
        maxam.add(am);
        n.add(k);
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i).getCustomer_id() != curId) {
                curId = l.get(i).getCustomer_id();
                temp = tranrep.ret2(curId);
                for (int j = 0; i < temp.size(); i++) {
                    ams.add(abs(temp.get(i).getAmount()));
                }
                for (int j = 0; i < temp.size(); i++) {
                    if (Collections.frequency(ams, ams.get(i)) > k) {
                        k = Collections.frequency(ams, ams.get(i));
                        am = ams.get(i);
                    }
                }
            }
            ids.add(curId);
            maxam.add(am);
            n.add(k);
        }
        for (int i = 0; i < n.size(); i++) {
            Answer2 ans = new Answer2();
            ans.setCustomer_id(ids.get(i));
            ans.setAbs(maxam.get(i));
            ans.setN(n.get(i));
            a2.save(ans);
            a2.flush();
        }
        List<Answer2> l2 = a2.findAll();
        model.addAttribute("trans", l2);
        return "answer2";
    }
}
