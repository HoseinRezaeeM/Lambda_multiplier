package src.src.main.java;

import src.src.main.java.LambdaUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n*********  Hosein Rrezaei HW11 ********\n");
        Supplier<String> helloSupplier = LambdaUtil.helloSupplier();
        System.out.println(helloSupplier.get());  //Hello


        System.out.println("---- Q1 ----\n");
        Predicate<String> isEmptyPredicate = LambdaUtil.isEmptyPredicate();
        System.out.println(isEmptyPredicate.test("java"));  //false
        System.out.println(isEmptyPredicate.test(""));      //true


        System.out.println("---- Q2 ----\n");
        BiFunction<String, Integer, String> stringMultiplier = LambdaUtil.stringMultiplier();
        System.out.println(stringMultiplier.apply("Hi", 3)); // HiHiHi


        System.out.println("---- Q3 ----\n");
        Function<BigDecimal, String> toDollarStringFunction = LambdaUtil.toDollarStringFunction();
        String tenDollarStr = toDollarStringFunction.apply(BigDecimal.TEN.setScale(2));
        System.out.println(tenDollarStr);     // $10.00


        System.out.println("---- Q4 ----\n");
        Predicate<String> lengthInRangePredicate = LambdaUtil.lengthInRangePredicate(4, 8);
        System.out.println(lengthInRangePredicate.test("Hello world"));//false


        System.out.println("---- Q5 ----\n");
        IntSupplier randomIntSupplier = LambdaUtil.randomIntSupplier();
        int firstValue = randomIntSupplier.getAsInt();
        int secondValue = randomIntSupplier.getAsInt();
        System.out.println(firstValue == secondValue); //false


        System.out.println("---- Q6 ----\n");
        IntUnaryOperator boundedRandomIntSupplier = LambdaUtil.boundedRandomIntSupplier();
        int randomIntLessThan1000 = boundedRandomIntSupplier.applyAsInt(1000);
        System.out.println(randomIntLessThan1000 < 1000);
        //true


        System.out.println("---- Q7 ----\n");
        IntUnaryOperator squareOperation = LambdaUtil.intSquareOperation();
        System.out.println(squareOperation.applyAsInt(4));     //16


        System.out.println("---- Q8 ----\n");
        LongBinaryOperator sumOperation = LambdaUtil.longSumOperation();
        System.out.println(sumOperation.applyAsLong(5, -10));//-5


        System.out.println("---- Q9 ----\n");
        ToIntFunction<String> stringToIntConverter = LambdaUtil.stringToIntConverter();
        int num = stringToIntConverter.applyAsInt("234");
        System.out.println(num);//234


        System.out.println("---- Q10 ----\n");
        Supplier<IntUnaryOperator> fiveMultiplyFunctionSupplier = LambdaUtil.nMultiplyFunctionSupplier(5);
        IntUnaryOperator multiplyByFiveOperation = fiveMultiplyFunctionSupplier.get();
        int result = multiplyByFiveOperation.applyAsInt(11);
        System.out.println(result);//11 * 5 => 55


        System.out.println("---- Q11 ----\n");
        Supplier<Supplier<Supplier<String>>> wellDoneSupplier = LambdaUtil.trickyWellDoneSupplier();
        System.out.println(wellDoneSupplier.get().get().get());//WELL DONE!


        System.out.println("---- Q12 ----\n");
        UnaryOperator<Function<String, String>> composeWithTrimFunction = LambdaUtil.composeWithTrimFunction();
        Function<String, String> toLowerWithTrim = composeWithTrimFunction.apply(String::toLowerCase);
        System.out.println(toLowerWithTrim.apply("  Hey k"));//hey


        //extra points
        System.out.println("---- Q13 ----\n");
        BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> intFunctionToConditionalIntFunction
                = LambdaUtil.functionToConditionalFunction();
        IntUnaryOperator abs = intFunctionToConditionalIntFunction.apply(a -> -a, a -> a < 0);
        System.out.println(abs.applyAsInt(-5));  //5


        System.out.println("---- Q14 ----\n");
        BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader = LambdaUtil.functionLoader();
        Map<String, IntUnaryOperator> functionMap = new HashMap<>();
        functionMap.put("increment", x -> x + 1);
        functionMap.put("square", x -> x * x);

        IntUnaryOperator incrementFunction = functionLoader.apply(functionMap, "increment");
        IntUnaryOperator squareFunction = functionLoader.apply(functionMap, "square");
        IntUnaryOperator identityFunction = functionLoader.apply(functionMap, "none");

        System.out.println(incrementFunction.applyAsInt(4));//5
        System.out.println(squareFunction.applyAsInt(3));//9
        System.out.println(identityFunction.applyAsInt(10));//10
        System.out.println("\\\\Finish//");
    }

}
