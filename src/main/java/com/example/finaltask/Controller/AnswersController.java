package com.example.finaltask.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.io.IOException;


@Controller
public class AnswersController {
    @GetMapping("/answers")
    public String getAnswers() throws IOException {
        return "answers_page";
    }

    @PostMapping
    public String getTransactionsPage(Model model) throws IOException {
        return null;
    }
}
