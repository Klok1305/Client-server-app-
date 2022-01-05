package com.example.finaltask.Models;

import com.example.finaltask.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class OutPut {
    @Autowired
    private TransactionsRepository tranrep;

    public void WriteToFile(String data) {
        File file = new File("C:\\Users\\B.N.B\\IdeaProjects\\demo\\out.txt");
        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;

        try {
            int noOfLines = 1;
            file_writer = new FileWriter(file, true);
            buffered_writer = new BufferedWriter(file_writer);

            for (int i = noOfLines; i > 0; i--) {
                buffered_writer.write(data);
                buffered_writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffered_writer.close();
                file_writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Write() throws IOException {
        List<Transactions> l = tranrep.findAll();
        File file = new File("C:\\Users\\B.N.B\\IdeaProjects\\demo\\out.txt");
        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;
        file_writer = new FileWriter(file, true);
        buffered_writer = new BufferedWriter(file_writer);
        buffered_writer.write("customer_id, tr_datetime, mcc_code, tr_type, amount, term_id");
        for (int i = 0; i < l.size(); i++) {
            WriteToFile( l.get(i).getCustomer_id().toString() + ',' + l.get(i).getTr_datetime().toString() + ',' + l.get(i).getMcc_code().toString() + ',' + l.get(i).getTr_type().toString() + ',' + l.get(i).getAmount() + ',' + l.get(i).getTerm_id());
        }
    }
}
