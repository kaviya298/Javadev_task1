import java.util.Scanner;

public class ConsoleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        System.out.println("Welcome to the Console Calculator!");

        while (continueCalculation) {
            try {
                // Prompt for first number
                System.out.print("Enter the first number: ");
                double num1 = Double.parseDouble(scanner.nextLine());

                // Prompt for operation
                System.out.print("Enter an operation (+, -, *, /): ");
                char operation = scanner.nextLine().charAt(0);

                // Prompt for second number
                System.out.print("Enter the second number: ");
                double num2 = Double.parseDouble(scanner.nextLine());

                double result;
                switch (operation) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        result = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation. Please enter one of +, -, *, or /.");
                }

                System.out.println("The result is: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Ask if the user wants to perform another calculation
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                continueCalculation = false;
                System.out.println("Thank you for using the Console Calculator. Goodbye!");
            }
        }

        scanner.close();
    }
}
