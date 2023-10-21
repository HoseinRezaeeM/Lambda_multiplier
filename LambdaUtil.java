import java.math.BigDecimal;
import java.math.RoundingMode;
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
        intSupplier = ()-> (int) (Math.random() * 100);

        return intSupplier;
    }



    public static IntUnaryOperator boundedRandomIntSupplier() {
       IntUnaryOperator intUnaryOperator;
       intUnaryOperator = (s) ->(int) (Math.random() * s);
        return intUnaryOperator;
    }


    public static IntUnaryOperator intSquareOperation() {
        IntUnaryOperator intUnaryOperator;
        intUnaryOperator = (s) ->(s*s);
        return intUnaryOperator;
    }


    public static LongBinaryOperator longSumOperation() {
        LongBinaryOperator longBinaryOperator;
        longBinaryOperator =Long::sum;                  //MethodReference
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
        Supplier<IntUnaryOperator> supplier ;
        supplier =()-> (IntUnaryOperator) operand -> operand *n;  //multiplier Wowwww
        return supplier;
    }

    /**
     * Returns {@link Supplier} of {@link Supplier} of {@link Supplier} of {@link String} "WELL DONE".
     *
     * @return a supplier instance
     */
    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        //todo
        return null;
    }

    /**
     * Returns a {@link UnaryOperator} that accepts str to str function and returns the same function composed with trim
     *
     * @return function that composes functions with trim() function
     */
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        //todo
        return null;
    }

    /**
     * Returns a {@link BiFunction} that has two parameters. First is {@link IntUnaryOperator} which is some integer function.
     * Second is {@link IntPredicate} which is some integer condition. And the third is {@link IntUnaryOperator} which is
     * a new composed function that uses provided predicate (second parameter of binary function) to verify its input
     * parameter. If predicate returns {@code true} it applies a provided integer function
     * (first parameter of binary function) and returns a result value, otherwise it returns an element itself.
     *
     * @return a binary function that receiver predicate and function and compose them to create a new function
     */
    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        //todo :: extra points
        return null;
    }

    /**
     * Returns a {@link BiFunction} which first parameter is a {@link Map} where key is a function name, and value is some
     * {@link IntUnaryOperator}, and second parameter is a {@link String} which is a function name. If the map contains a
     * function by a given name then it is returned by high order function otherwise an identity() is returned.
     *
     * @return a high-order function that fetches a function from a function map by a given name or returns identity()
     */
    public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {
        //todo :: extra points
        return null;
    }
}
