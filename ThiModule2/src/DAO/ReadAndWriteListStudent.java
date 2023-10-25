package DAO;

import Models.Student;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ReadAndWriteListStudent {
    File file = new File("student.csv");

    public void writeList(ArrayList<Student> list) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Student student : list
            ) {
                line += student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getGender() + "," + student.getAddress() + "," + student.getAverage() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Student> readFile() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Student student = new Student(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], Double.parseDouble(data[5]));
                list.add(student);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
