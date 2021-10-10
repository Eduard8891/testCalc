import java.util.Scanner;

public class Main {

    static Calculator calculator = new Calculator();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {

                String line = scanner.nextLine().replaceAll(" ", "");
                if (line.matches("I{0,3}V*I{0,3}X*[+]*[-]*[*]*[/]*I{0,3}V*I{0,3}X*")) {
                    String result = calculator.romanDigitsOperations(line);
                    if (result == null) {
                        break;
                    }
                    System.out.println(result);
                } else if (line.matches("[\\d]{1,2}[+]*[-]*[*]*[/]*[\\d]{1,2}")) {

                    String[] digits = line.split("[+\\-*/]");
                    if (digits.length < 2 || digits[1] == null) {
                        throw new Exception("В строке только одно число");
                    }
                    if (Integer.parseInt(digits[0]) > 10 || Integer.parseInt(digits[1]) > 10) {
                        throw new Exception("В выражении есть числа больше 10");
                    } else {
                        int result = calculator.digitsOperations(line);
                        System.out.println(result);
                    }
                } else if (line.matches(".{1,3}")) {
                    throw new Exception("Строка не является математической операцией");
                } else {
                    throw new Exception("В выражении есть ошибки");
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();

        }

    }


}
