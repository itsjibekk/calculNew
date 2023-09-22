import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 2 + 3):");
        String input = scanner.nextLine();


            try {
                String result = calc(input);
                System.out.println("Результат: " + result);
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }


    }

    public static String calc(String input) {
        String[] expression = input.split("\\s+");
        if (expression.length != 3) {
            throw new IllegalArgumentException("Неверное количество элементов в выражении.");
        }

        int operand1;
        int operand2;
        char operator;

        try {
            operand1 = Integer.parseInt(expression[0]);
            operator = expression[1].charAt(0);
            operand2 = Integer.parseInt(expression[2]);
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Неверный формат выражения.");
        }


        if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
            throw new IllegalArgumentException("Операнды должны быть в диапазоне от 1 до 10.");
        }

        int result;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль недопустимо.");
                }
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Неверный оператор.");
        }

        return String.valueOf(result);
    }
}
