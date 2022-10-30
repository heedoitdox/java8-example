public class OopAndFpExample {
    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService(new Add(), new Sub());
        final int additionResult = calculatorService.calculate(11,1);
        System.out.println(additionResult);

        final int subtractionResult = calculatorService.calculate(11,1);
        System.out.println(subtractionResult);

        final int multiplicationResult = calculatorService.calculate(11,1);
        System.out.println(multiplicationResult);

        final int divisionResult = calculatorService.calculate(15,5);
        System.out.println(divisionResult);

        // functional programing
        FpCalculatorService fpCalculatorService = new FpCalculatorService();
        System.out.println("       addition: " + fpCalculatorService.calculate((i1, i2) -> i1 + i2, 11, 2));
        System.out.println("    subtraction: " + fpCalculatorService.calculate((i1, i2) -> i1 - i2, 11, 2));
        System.out.println(" multiplication: " + fpCalculatorService.calculate((i1, i2) -> i1 * i2, 11, 2));
        System.out.println("       division: " + fpCalculatorService.calculate((i1, i2) -> i1 / i2, 11, 2));
        System.out.println("custom division: " + fpCalculatorService.calculate((i1, i2) -> ((i1 + i2) * 2) / i2, 11, 2));
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
    private final Calculation calculation2;

    public CalculatorService(Calculation calculation, Calculation calculation2) {
        this.calculation = calculation;
        this.calculation2 = calculation2;
    }

    // 뭔가 비즈니스 로직이 들어간 calculate
    public int calculate(int num1, int num2) {
        if(num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1 : " + num1 + ", num2: " + num2);
        }
    }

    public int compute(int num1, int num2) {
        if(num1 > 10 && num2 < num1) {
            return calculation2.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1 : " + num1 + ", num2: " + num2);
        }
    }
}

class FpCalculatorService {
    public int calculate(Calculation calculation, int num1, int num2) {
        if(num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1 : " + num1 + ", num2: " + num2);
        }
    }
}