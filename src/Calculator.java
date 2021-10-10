public class Calculator {

    public int digitsOperations(String ex) {
        try {
            String operation = ex.replaceAll("\\d", "");
            String[] digits = ex.split("[+\\-*/]");

            switch (operation) {
                case ("+"):
                    return Integer.parseInt(digits[0]) + Integer.parseInt(digits[1]);
                case ("-"):
                    return Integer.parseInt(digits[0]) - Integer.parseInt(digits[1]);
                case ("*"):
                    return Integer.parseInt(digits[0]) * Integer.parseInt(digits[1]);
                case ("/"):
                    return Integer.parseInt(digits[0]) / Integer.parseInt(digits[1]);
                default:
                    System.out.println("Invalid arguments");
                    return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public String romanDigitsOperations(String ex) {
        try {
            String operations = ex.replaceAll("I*V*X*", "");
            String[] digits = ex.split("[+[-]*/]");
            if (digits.length > 1) {
                int result = digitsOperations(parseRomanDigits(digits[0]) + operations + parseRomanDigits(digits[1]));
                if (result < 0 || result == 0) {
                    throw new Exception("Результатом выражения является отрицательное число или ноль");
                } else {
                    return parseToRoman(result);
                }
            } else throw new Exception("В выражении не хватает аргументов");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public String parseToRoman(int number) {
        if (number < 11) {
            return oneDigitOrSecondInTwoDigit(number);
        } else {
            if (number == 100) {
                return firstInTwoDigit(number);
            }
            char first = Integer.toString(number).charAt(0);
            char second = Integer.toString(number).charAt(1);
            int f = Integer.parseInt(String.valueOf(first));
            int s = Integer.parseInt(String.valueOf(second));
            return firstInTwoDigit(f) + oneDigitOrSecondInTwoDigit(s);
        }
    }

    public String oneDigitOrSecondInTwoDigit(int number) {
        if (number == 0) {
            return "";
        }
        if (number < 4) {
            StringBuilder result = new StringBuilder("I");
            for (int i = 1; i < number; i++) {
                result.append("I");
            }
            return result.toString();
        } else if (number < 9) {
            if (number < 5) {
                return "IV";
            } else if (number > 5) {
                StringBuilder result = new StringBuilder("V");
                for (int i = 5; i < number; i++) {
                    result.append("I");
                }
                return result.toString();
            } else return "V";
        } else if (number == 9) {
            return "IX";
        } else return "X";
    }

    public String firstInTwoDigit(int number) {
        if (number < 4) {
            StringBuilder result = new StringBuilder("X");
            for (int i = 1; i < number; i++) {
                result.append("X");
            }
            return result.toString();
        } else if (number < 9) {
            if (number < 5) {
                return "XL";
            } else if (number > 5) {
                StringBuilder result = new StringBuilder("L");
                for (int i = 5; i < number; i++) {
                    result.append("X");
                }
                return result.toString();
            } else return "L";
        } else if (number == 9) {
            return "XC";
        } else return "C";
    }


    public int parseRomanDigits(String romanDigit) {
        switch (romanDigit) {
            case ("I"):
                return 1;
            case ("II"):
                return 2;
            case ("III"):
                return 3;
            case ("IV"):
                return 4;
            case ("V"):
                return 5;
            case ("VI"):
                return 6;
            case ("VII"):
                return 7;
            case ("VIII"):
                return 8;
            case ("IX"):
                return 9;
            case ("X"):
                return 10;
            default:
                return 0;
        }
    }
}
