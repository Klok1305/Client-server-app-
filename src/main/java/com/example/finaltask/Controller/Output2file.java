package com.example.finaltask.Controller;

import com.example.finaltask.Models.OutPut;
import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class Output2file {
    @Autowired
    private TransactionsRepository tranrep;
    @Autowired
    private OutPut t;

    @GetMapping("/out2file")
    public String get2filepage(){
        return "makeoutput";
    }

    @PostMapping("/out2file")
    public String AddData() throws IOException {
        t.Write();
        return "redirect: /out2file";
    }
}
