import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest {

    @Test
    public void testCalculateAdd() {
        Calculation calculation = new Add();
        final int actual = calculation.calculate(1, 1);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void testCalculateSub() {
        Calculation calculation = new Sub();
        final int actual = calculation.calculate(1, 1);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void testCalculateMul() {
        Calculation calculation = new Mul();
        final int actual = calculation.calculate(1, 1);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void testCalculateDiv() {
        Calculation calculation = new Div();
        final int actual = calculation.calculate(9, 1);
        assertThat(actual).isEqualTo(9);
    }
}