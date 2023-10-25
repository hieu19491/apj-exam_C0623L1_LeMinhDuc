package Manager;

import DAO.ReadAndWriteListStudent;
import Models.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager implements IManager<Student> {
    private ArrayList<Student> list;
    private ReadAndWriteListStudent readAndWriteListStudent;

    public StudentManager() {
        readAndWriteListStudent = new ReadAndWriteListStudent();
        list = readAndWriteListStudent.readFile();
    }
    public int findIndex(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return  i;
            }
        }
        return -1;
    }
    @Override
    public boolean add(Student student) {
        list.add(student);
        readAndWriteListStudent.writeList(list);
        return true;
    }

    @Override
    public boolean edit(int index, Student student) {
        list.set(index, student);
        readAndWriteListStudent.writeList(list);
        return true;
    }

    @Override
    public boolean delete(int index) {
        list.remove(index);
        readAndWriteListStudent.writeList(list);
        return true;
    }

    @Override
    public ArrayList<Student> findAll() {
        return list;
    }

    public ArrayList<Student> sortASC() {
        ArrayList<Student> listTemp = list;
        for (int i = 0; i < listTemp.size(); i++) {
            for (int j = 0; j < listTemp.size() - 1- i; j++) {
                if (listTemp.get(j).getAverage() > listTemp.get(j+1).getAverage()) {
                    Student temp = listTemp.get(j);
                    listTemp.set(j, listTemp.get(j+1));
                    listTemp.set(j+1,temp);
                }
            }
        }
        return  listTemp;
    }
    public ArrayList<Student> sortDCS() {
        ArrayList<Student> listTemp = list;
        for (int i = 0; i < listTemp.size(); i++) {
            for (int j = 0; j < listTemp.size() - 1- i; j++) {
                if (listTemp.get(j).getAverage() < listTemp.get(j+1).getAverage()) {
                    Student temp = listTemp.get(j);
                    listTemp.set(j, listTemp.get(j+1));
                    listTemp.set(j+1,temp);
                }
            }
        }
        return  listTemp;
    }
}
