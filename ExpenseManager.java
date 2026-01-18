//imports libraries
import java.util.ArrayList; //allows list to be created
import java.util.Scanner; //allows input

//main class
public class ExpenseManager {
    public static void main(String[] args) {
        ArrayList<Expense> allExpenses = new ArrayList<>(); // stores all expense objects in a list, created from the Expense class
        Scanner scanner = new Scanner(System.in); //to read input from user

        while (true) { // loop for program flow
            System.out.println("| Welcome to the Student Expense Manager! | \nWhat would you like to do today?: \n" +
                    "1. Add Expense\n" +
                    "2. Add Discounted Expense\n" +
                    "3. View All Expenses\n" +
                    "4. Show Total Spending\n" +
                    "5. Show Highest Expense\n" +
                    "6. Exit");
            System.out.print("Choose your option (1-6): ");

            int option = scanner.nextInt(); //stores integer input under option variable
            scanner.nextLine(); //clears previous input

            System.out.println("\nYou chose option " + option + "\n"); // output message to guide the user

            switch (option) {
                case 1: // adds normal expense
                    System.out.print("Enter expense name: ");
                    String expenseName = scanner.nextLine(); //stores input under variable

                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble(); //stores input under variable
                    scanner.nextLine(); //clears previous input

                    if (expenseAmount < 0) { // check for negative value
                        System.out.println("Amount cannot be negative.\n");
                    } else { // creates new expense and adds to list
                        Expense expense = new Expense(expenseName, expenseAmount);
                        allExpenses.add(expense);
                        System.out.println("\nNew expense added!\nExpense Name: " + expense.expenseName + "\nAmount: £" + expense.expenseAmount + "\n");
                    }
                    break;

                case 2: // adds discounted expense
                    System.out.print("Enter discounted expense name: ");
                    String dExpenseName = scanner.nextLine();//stores input under variable

                    System.out.print("Enter original amount: ");
                    double dExpenseAmount = scanner.nextDouble();//stores input under variable

                    System.out.print("Enter discount percentage: ");
                    int discountPercentage = scanner.nextInt();//stores input under variable
                    scanner.nextLine();

                    if (dExpenseAmount < 0 || discountPercentage < 0) { // checks for negative value
                        System.out.println("Amount and discount cannot be negative.\n");
                    } else { // creates new expense and adds to list
                        DiscountedExpense dExpense = new DiscountedExpense(dExpenseName, dExpenseAmount, discountPercentage);
                        allExpenses.add(dExpense);
                        System.out.println("\nNew expense added! \nExpense name: " + dExpense.expenseName + "\nAmount after discount: £" + dExpense.getFinalAmount() + "\n");
                    }
                    break;

                case 3: // view all expenses
                    if (allExpenses.isEmpty()) { //checks if there are any expenses stored in list
                        System.out.println("No expenses have been stored.");
                        break;
                    }

                    System.out.println("Below are all your expenses:\n");
                    for (Expense exp : allExpenses) { //checks for every expense in list of all expenses
                        if (exp instanceof DiscountedExpense) { // discounted expense
                            System.out.println("Expense name: " + exp.expenseName);
                            System.out.println("Original amount: " + exp.expenseAmount);
                            System.out.println("Amount after discount: " + exp.getFinalAmount());
                            System.out.println("Type: Discounted");
                            System.out.println();
                        } else { // normal expense
                            System.out.println("Expense name: " + exp.expenseName);
                            System.out.println("Amount: " + exp.expenseAmount);
                            System.out.println("Type: Normal");
                            System.out.println();
                        }
                    }
                    break;

                case 4: // shows total spending
                    if (allExpenses.isEmpty()) { //checks if there are any expenses stored in the list
                        System.out.println("No expenses have been stored.\n");
                        break;
                    }

                    //for every value in each expense within the list, calculates the total
                    double total = 0;
                    for (Expense exp : allExpenses) {
                        total = total + exp.getFinalAmount();
                    }
                    System.out.println("Your total spending amount is: £" + total + "\n");
                    break;

                case 5: // shows the highest expense
                    if (allExpenses.isEmpty()) { //checks if there are any expenses stored in the expenses list
                        System.out.println("No expenses have been stored.\n");
                        break;
                    }
                    //finds the expense with the highest amount in the list
                    Expense highest = allExpenses.get(0);
                    for (Expense exp : allExpenses) {
                        if (exp.getFinalAmount() > highest.getFinalAmount()) {
                            highest = exp;
                        }
                    }

                    // shows the user the details of their highest stored expense, along with its type
                    if (highest instanceof DiscountedExpense) {
                        System.out.println("Below is your highest stored expense:\n");
                        System.out.println("Expense name: " + highest.expenseName);
                        System.out.println("Original amount: " + highest.expenseAmount);
                        System.out.println("Final amount: " + highest.getFinalAmount());
                        System.out.println("Type: Discounted");
                    } else {
                        System.out.println("Below is your highest stored expense:\n");
                        System.out.println("Title: " + highest.expenseName);
                        System.out.println("Amount: " + highest.expenseAmount);
                        System.out.println("Type: Normal");
                    }
                    System.out.println();
                    break;

                case 6: // exits the program
                    System.out.println("Thank you for using Student Expense Manager.");
                    return;

                default: //input validation, tells user to enter input in range 1-6
                    System.out.println("Invalid option. Please choose an option between 1-6.\n");
            }
        }
    }
}
