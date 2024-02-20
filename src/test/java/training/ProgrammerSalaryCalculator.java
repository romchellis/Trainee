package training;

public class ProgrammerSalaryCalculator implements EmployeeSalaryCalculator {
    @Override
    public double calculate(Double baseRate) {
        return 5 * baseRate;
    }
}
