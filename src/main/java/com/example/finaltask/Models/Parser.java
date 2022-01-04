package com.example.finaltask.Models;

import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
    @Autowired
    private TransactionsRepository tranrep;
    private List<Long> ClientIDs = new ArrayList<>();
    private List<Double> Amounts = new ArrayList<>();
    public void UseScanner() throws IOException {
        String file_path = "C:\\Users\\B.N.B\\IdeaProjects\\demo\\test.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file_path));
        String line = null;
        Scanner scanner = null;
        int index = 0;

        Transactions tran = new Transactions();


        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                switch (index) {
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
                        System.out.println("Некорректные данные::" + data);
                        break;
                                }
                index++;
            }
            index = 0;
            ClientIDs.add(tran.getCustomer_id());
            Amounts.add(tran.getAmount());
            //tranrep.save(tran);
        }

        reader.close();
    }
    public List<Long> getClients(){
        return ClientIDs;
    }

    public List<Double> getAmounts(){
        return Amounts;
    }
}
