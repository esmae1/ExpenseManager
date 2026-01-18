//Expense class
public class Expense {
    String expenseName; //stores the name of expense
    double expenseAmount; //stores amount of the expense

    // constructor for the Expense class
    public Expense(String expenseName, double expenseAmount) {
        this.expenseName = expenseName; //stores users expense name under expenseName
        this.expenseAmount = expenseAmount; //stores users amount under expenseAmount
    }

    // method to returns final amount
    public double getFinalAmount() {
        return expenseAmount; //stores final amount under getFinalAmount method
    }
}
