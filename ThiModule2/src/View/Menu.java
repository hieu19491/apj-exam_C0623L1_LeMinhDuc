package View;

import Input.ValidateInput;
import Manager.StudentManager;
import Models.Student;

public class Menu {
    private StudentManager studentManager = new StudentManager();
    public void showMainMenu(){
        while(true) {
            System.out.println("-----Chương trình quản lý sinh viên-----\n" +
                    "Chọn chức năng theo số (để tiếp tục)\n" +
                    "1. Xem danh sách sinh viên\n" +
                    "2. Thêm mới\n" +
                    "3. Cập nhật\n" +
                    "4. Xóa\n" +
                    "5. Sắp xếp\n" +
                    "0. Thoát\n");
            System.out.print("Chọn chức năng: ");
            int choice = ValidateInput.getInputInt();
            switch (choice) {
                case 1:
                    showListStudent();
                    break;
                case 2:
                    showMenuAdd();
                    break;
                case 3:
                    showMenuEdit();
                    break;
                case 4:
                    showMenuDelete();
                    break;
                case 5:
                    showMenuSort();
                    break;
                case 0:
                    System.out.println("==>Thoát thành công!!!");
                    System.exit(0);
                    break;
            }
        }
    }

    private void showMenuSort() {
        while (true) {
            System.out.println("\n-----Sắp xếp sinh viên theo điểm trung bình-----\n" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Sắp xếp điểm trung bình tăng dần\n" +
                    "2. Sắp xếp điểm trung bình giảm dần\n" +
                    "0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = ValidateInput.getInputInt();
            switch (choice) {
                case 1:
                    showMenuSortASC();
                    break;
                case 2:
                    showMenuSortDCS();
                    break;
                case 0:
                    showMainMenu();
                    break;
            }
        }


    }

    private void showMenuSortDCS() {
        System.out.println("\n-----Sắp xếp điểm trung bình tăng dần-----");
        for (Student student:
                studentManager.sortDCS()) {
            System.out.println(student);
        }
    }

    private void showMenuSortASC() {
        System.out.println("\n-----Sắp xếp điểm trung bình tăng dần-----");
        for (Student student:
             studentManager.sortASC()) {
            System.out.println(student);
        }
    }

    private void showMenuDelete() {
        System.out.println("\n-----Xóa sinh viên-----");
        System.out.print("Nhập mã sinh viên cần sửa: ");
        int id = ValidateInput.getInputInt();
        int index = studentManager.findIndex(id);
        if (index == -1) {
            System.out.println("==>Không có thông tin sinh viên này!!!\n");
            return;
        }
        System.out.println("Bạn có chắc chắn muốn xóa sinh viên này không?\nCó: Y");
        System.out.print("Nhập lựa chọn: ");
        String choice = ValidateInput.getInputString();
        if (choice.toLowerCase().equals("y")){
            studentManager.delete(index);
            System.out.println("==> Xóa thành công\n");
        } else {
            System.out.println("==> Thất bại\n");
        }
    }

    private void showMenuEdit() {
        System.out.println("\n-----Cập nhật thông tin-----");
        System.out.print("Nhập mã sinh viên cần sửa: ");
        int id = ValidateInput.getInputInt();
        int index = studentManager.findIndex(id);
        if (index == -1) {
            System.out.println("==>Không có thông tin sinh viên này!!!\n");
            return;
        }
        System.out.print("Nhập họ và tên: ");
        String name = ValidateInput.getInputString();
        System.out.print("Nhập tuổi: ");
        int age = ValidateInput.getInputInt();
        System.out.print("Nhập giới tính: ");
        int gender = ValidateInput.getInputGender();
        System.out.print("Nhập địa chỉ: ");
        String address = ValidateInput.getInputString();
        System.out.print("Nhập điểm trung bình: ");
        double average = ValidateInput.getInputDouble();
        Student student = new Student(id, name, age, gender, address, average);
        studentManager.edit(index, student);
        System.out.println("==> Sửa thông tin thành công\n");
    }

    private void showMenuAdd() {
        System.out.println("\n-----Thêm sinh sinh-----");
        System.out.print("Nhập mã sinh viên: ");
        int id = ValidateInput.getInputInt();
        System.out.print("Nhập họ và tên: ");
        String name = ValidateInput.getInputString();
        System.out.print("Nhập tuổi: ");
        int age = ValidateInput.getInputInt();
        System.out.print("Nhập giới tính: ");
        int gender = ValidateInput.getInputGender();
        System.out.print("Nhập địa chỉ: ");
        String address = ValidateInput.getInputString();
        System.out.print("Nhập điểm trung bình: ");
        double average = ValidateInput.getInputDouble();
        Student student = new Student(id, name, age, gender,address,average);
        studentManager.add(student);
        System.out.println("==> Thêm thành công\n");
    }

    private void showListStudent() {
        System.out.println("\n-----Danh sách sinh viên-----");
        for (Student student:studentManager.findAll()) {
            System.out.println(student);
        }
        System.out.println();
    }
}
