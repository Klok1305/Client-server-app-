package com.example.finaltask.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnswersController {
    @GetMapping("/answers")
    public String getAnswers(){
        return "answers_page";
    }
}
