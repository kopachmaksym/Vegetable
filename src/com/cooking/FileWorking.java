package com.cooking;
import java.io.*;
import java.util.Scanner;

public class FileWorking {

    public void FileWriting(String salat) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(
                "C:\\Users\\mk410\\OneDrive\\Desktop\\JavaProjects\\ComplexWork\\src\\com\\cooking\\Salats.txt",true));
        writer.append(String.format("\n\n%s",salat));
        writer.close();
    }

    public void FileReading(String path) throws IOException {
        File myObj = new File(path);
        Scanner reader = new Scanner(myObj);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();
    }

}
