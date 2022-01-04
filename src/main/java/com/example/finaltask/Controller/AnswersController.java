package com.example.finaltask.Controller;

import com.example.finaltask.Models.Parser;
import com.example.finaltask.Models.Transactions;
import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Controller
public class AnswersController {
    @GetMapping("/answers")
    public String getAnswers() throws IOException {
        Parser p = new Parser();
        p.UseScanner();
        System.out.println(p.answerish(606275).toString());
        return "answers_page";
    }

    @PostMapping
    public String getTransactionsPage(Model model) throws IOException {

        return null;
    }
}
