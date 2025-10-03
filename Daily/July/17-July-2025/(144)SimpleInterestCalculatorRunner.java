
import java.math.BigDecimal;

class SimpleInterestCalculatorRunner {
    public static void main(String[] args) {
        SimpleInterestCalculator calculator = new SimpleInterestCalculator("4500.00", "7.5");
        BigDecimal totalValue = calculator.calculateTotalValue(5);
        System.out.println("Total Value after 5 years: " + totalValue);
    }
}

class SimpleInterestCalculator {
    BigDecimal principal;
    BigDecimal interest;

    public SimpleInterestCalculator(String principal, String interest) {
        this.principal = new BigDecimal(principal);
        this.interest = new BigDecimal(interest).divide(new BigDecimal("100"));
    }

    public BigDecimal calculateTotalValue(int noOfYears) {
        BigDecimal totalValue = principal.add(principal.multiply(interest).multiply(new BigDecimal(noOfYears)));
        return totalValue;
    }
}