// subclass of Expense class
public class DiscountedExpense extends Expense {
    int discountPercentage;
    double discountedAmount;

    // constructor
    public DiscountedExpense(String expenseName, double expenseAmount, int discountPercentage) {
        super(expenseName, expenseAmount); // calls the constructor of the Expense class
        this.discountPercentage = discountPercentage;
        calculateDiscountedAmount(); // method which calculates discounted amount when object is made
    }

    // calculates the discounted amount using original amount and discount percentage, and stores it
    private void calculateDiscountedAmount() {
        this.discountedAmount = expenseAmount * (1 - discountPercentage / 100.0);
    }

    // returns the final amount after calculating discount
    public double getFinalAmount() {
        return discountedAmount; //stores the final discounted amount under getFinalAmount method
    }
}
