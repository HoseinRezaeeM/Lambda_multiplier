package src.src.main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.*;

public class LambdaUtil {


    public static Supplier<String> helloSupplier() {
        Supplier<String> stringSupplier;
        stringSupplier = () -> new String("Hello");
        return stringSupplier;
    }

    public static Predicate<String> isEmptyPredicate() {
        Predicate<String> stringPredicate;
        stringPredicate = String::isEmpty;
        return stringPredicate;

    }

    public static BiFunction<String, Integer, String> stringMultiplier() {
        BiFunction<String, Integer, String> biFunction;
        biFunction = (string, integer) -> {
            for (int j = 1; j < integer; j++) {
                System.out.print(string);
            }
            return string;
        };
        return biFunction;
    }


    public static Function<BigDecimal, String> toDollarStringFunction() {
        Function<BigDecimal, String> decimalStringFunction;
        decimalStringFunction = BigDecimal::toString;
        return decimalStringFunction;
    }


    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        Predicate<String> predicate;
        predicate = (string) -> {
            if (string.length() < max && string.length() > min) {
                return true;
            }
            return false;
        };
        return predicate;
    }

    public static IntSupplier randomIntSupplier() {
        IntSupplier intSupplier;
        intSupplier = () -> (int) (Math.random() * 100);

        return intSupplier;
    }


    public static IntUnaryOperator boundedRandomIntSupplier() {
        IntUnaryOperator intUnaryOperator;
        intUnaryOperator = (s) -> (int) (Math.random() * s);
        return intUnaryOperator;
    }


    public static IntUnaryOperator intSquareOperation() {
        IntUnaryOperator intUnaryOperator;
        intUnaryOperator = (s) -> (s * s);
        return intUnaryOperator;
    }


    public static LongBinaryOperator longSumOperation() {
        LongBinaryOperator longBinaryOperator;
        longBinaryOperator = Long::sum;                  //MethodReference
        //longBinaryOperator =(a,b)-> Long.sum(a,b);      Lambda
        return longBinaryOperator;
    }


    public static ToIntFunction<String> stringToIntConverter() {
        ToIntFunction<String> toIntFunction;
        toIntFunction = Integer::parseInt;                      //MethodReference
        //toIntFunction =(string)->Integer.parseInt(string);         Lambda
        return toIntFunction;
    }


    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {
        Supplier<IntUnaryOperator> supplier;
        supplier = () -> (IntUnaryOperator) operand -> operand * n;  //multiplier Wowwww
        return supplier;
    }


    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        Supplier<Supplier<Supplier<Supplier<String>>>> supplierSupplier;
        supplierSupplier = () -> () -> () -> () -> new String("WELL DONE");
        return supplierSupplier.get();
    }


    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        UnaryOperator<Function<String, String>> functionUnaryOperator;
        functionUnaryOperator = (s) -> (s.andThen((Function<String, String>) (string) -> string.trim()));  //String::trim;
        return functionUnaryOperator;
    }

//extra point
    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> biFunction;
        int a = 0;
        biFunction = (intUnaryOperator, intPredicate) -> {
            if (intPredicate.negate().test(a))
                return intUnaryOperator;
            else

                return intUnaryOperator;

        };
        return biFunction;
    }
    public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {

        BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> operatorBiFunction;
        operatorBiFunction = (map, string) -> {
            if (string.equals("none")) {
                return IntUnaryOperator.identity();

            } return map.put(string,IntUnaryOperator.identity()); //identity return value operation do not operation on value
        };
        return operatorBiFunction;
    }
}