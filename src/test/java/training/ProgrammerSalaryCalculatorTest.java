package training;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgrammerSalaryCalculatorTest {

    private EmployeeSalaryCalculator salaryCalculator = new ProgrammerSalaryCalculator();

    @ParameterizedTest
    @ValueSource(doubles = {10000d, 25000d, 50000d})
    void givenProgrammerSalary_isEqualTo_BaseMultipliedToServeYearsRate(Double baseRate) {
        double result = salaryCalculator.calculate(baseRate);

        assertThat(result).isEqualTo(5 * baseRate);
    }
}