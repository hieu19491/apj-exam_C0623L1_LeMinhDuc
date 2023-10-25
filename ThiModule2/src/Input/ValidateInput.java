package Input;

import java.util.Scanner;

public class ValidateInput {
    private static Scanner scanner = new Scanner(System.in);
    public static int getInputInt() {
        String regexNum = "^\\d+$";
        while (true) {
            String inputNum = scanner.nextLine();
            if (inputNum.matches(regexNum)) {
                return Integer.parseInt(inputNum);
            } else {
                System.out.print("Hãy nhập định dạng số.\nNhập lại: ");
            }
        }
    }
    public static double getInputDouble() {
        String regexNum = "^-?\\d+(\\.\\d+)?$";
        while (true) {
            String inputNum = scanner.nextLine();
            if (inputNum.matches(regexNum)) {
                return Double.parseDouble(inputNum);
            } else {
                System.out.print("Hãy nhập định dạng số.\nNhập lại: ");
            }
        }
    }
    public static String getInputString() {
        return scanner.nextLine();
    }
    public static int getInputGender() {
        String regexNum = "^[01]$";
        while (true) {
            String inputNum = scanner.nextLine();
            if (inputNum.matches(regexNum)) {
                return Integer.parseInt(inputNum);
            } else {
                System.out.print("1: Nữ || 0:Nam.\nNhập lại: ");
            }
        }
    }
}
