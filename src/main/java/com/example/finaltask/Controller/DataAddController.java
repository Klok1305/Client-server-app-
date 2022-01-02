package com.example.finaltask.Controller;

import com.example.finaltask.Models.Transactions;
import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DataAddController {
    @Autowired
    private TransactionsRepository tranrep;

    @GetMapping("/adddata")
    public String getAddDataPage(){
        return "addData_page";
    }

    @PostMapping("/adddata")
    public String AddData(Transactions tran){
        tranrep.save(tran);
        return "redirect:/adddata";
    }
}
