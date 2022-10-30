public class OopAnotherExample {
    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService(new Add());
        final int additionResult = calculatorService.calculate(1,1);
        System.out.println(additionResult);

        final int subtractionResult = calculatorService.calculate(1,1);
        System.out.println(subtractionResult);

        final int multiplicationResult = calculatorService.calculate(1,1);
        System.out.println(multiplicationResult);

        final int divisionResult = calculatorService.calculate(10,5);
        System.out.println(divisionResult);
    }
}

interface Calculation {
    int calculate(int num1, int num2);
}

class Add implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 + num2;
    }
}

class Sub implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 - num2;
    }
}

class Mul implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 * num2;
    }
}

class Div implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 / num2;
    }
}

class CalculatorService {
    private final Calculation calculation;

    public CalculatorService(final Calculation calculation) {
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2) {
        return calculation.calculate(num1, num2);
    }
}
