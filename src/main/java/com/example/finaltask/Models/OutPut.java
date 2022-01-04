package com.example.finaltask.Models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutPut {
    public static void WriteToFile(String data) {
        File file = new File("C:\\Users\\B.N.B\\IdeaProjects\\demo\\out.txt");
        FileWriter file_writer = null;
        BufferedWriter buffered_writer = null;

        try{
            int noOfLines = 1;
            file_writer = new FileWriter(file, true);
            buffered_writer = new BufferedWriter(file_writer);
            buffered_writer.append("ID, FirstName, LastName, Profession");

            for(int i = noOfLines; i > 0; i--)
            {
                buffered_writer.newLine();
                buffered_writer.write(data);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                buffered_writer.close();
                file_writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
