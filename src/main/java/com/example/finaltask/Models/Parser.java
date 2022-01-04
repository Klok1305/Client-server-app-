package com.example.finaltask.Models;

import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
        int flag = 0;
        Transactions tran = new Transactions();


        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
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
            ClientIDs.add(tran.getCustomer_id());
            Amounts.add(tran.getAmount());
            //tranrep.save(tran);
        }
        List<Double> n;
        n = answerish(606275);
        reader.close();
        FileWriter a = new FileWriter("C:\\Users\\B.N.B\\IdeaProjects\\demo\\temp.txt");
        a.write(n.get(0).toString() + ',' + n.get(1).toString()+','+ n.get(2).toString()+','+n.get(3).toString());
        a.close();
    }
    public List<Double> answerish(double id) {
        List<Double> needed = new ArrayList<>();
        Parser p = new Parser();
        for (int i = 0; i < ClientIDs.size(); i++) {
            if (ClientIDs.get(i) == id) {
                needed.add(Amounts.get(i));
            }
        }
        List<Double> out = new ArrayList<>();
        double max = Collections.max(needed);
        int max_n = 0;
        double num = 0;
        for (int i = 0; i < needed.size(); i++) {
            needed.set(i, Math.abs(needed.get(i)));
            if (Collections.frequency(needed, needed.get(i)) > max_n) {
                max_n = Collections.frequency(needed, needed.get(i));
                num = needed.get(i);
            }
        }
        out.add(606275.0);
        out.add(max);
        out.add(num);
        out.add(Double.valueOf(max_n));
        return out;
    }
}
