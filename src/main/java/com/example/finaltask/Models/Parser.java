package com.example.finaltask.Models;

import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
@Component
public class Parser {
    @Autowired
    private TransactionsRepository tranrep;

    public void UseScanner() throws IOException {
        String file_path = "C:\\Users\\B.N.B\\IdeaProjects\\demo\\test.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file_path));
        String line = null;
        Scanner scanner = null;
        int flag = 0;
        List<Transactions> tr = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            Transactions tran = new Transactions();
            while (scanner.hasNext()) {
                String data = scanner.next();
                switch (flag) {
                    case 0:
                        tran.setCustomer_id(Long.valueOf(data));
                        break;
                    case 1:
                        tran.setTr_datetime(data);
                        break;
                    case 2:
                        tran.setMcc_code(Long.valueOf(data));
                        break;
                    case 3:
                        tran.setTr_type(Long.valueOf(data));
                        break;
                    case 4:
                        tran.setAmount(Double.parseDouble(data));
                        break;
                    case 5:
                        tran.setTerm_id(Double.parseDouble(data));
                        break;
                    default:
                        System.out.println("Некорректные данные:" + data);
                        break;
                                }
                flag++;
            }
            flag = 0;
            tranrep.save(tran);

        }
    }
}
