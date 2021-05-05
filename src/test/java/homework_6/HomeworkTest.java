package homework_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class HomeworkTest {

    @ParameterizedTest
    @MethodSource("runtimeExceptionProvider")
    @NullAndEmptySource
    void shouldThrowRuntimeExceptionWhenArrayNotContainFour(int[] arr){
        Assertions.assertThrows(RuntimeException.class, () -> Main.getSubArrayAfterLastFour(arr));
    }

    private static Stream<Arguments> runtimeExceptionProvider(){
        return Stream.of(
            Arguments.arguments(new int[] {2, 5}),
                Arguments.arguments(new int[] {-1, -3, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("returnSubArrayAfterLastFourProvider")
    void shouldReturnSubArrayAfterLastFour(int[] expected, int[] arr){
        Assertions.assertArrayEquals(expected, Main.getSubArrayAfterLastFour(arr));
    }

    private static Stream<Arguments> returnSubArrayAfterLastFourProvider(){
        return Stream.of(
                Arguments.arguments(new int[]{1, 3}, new int[] {-2, 4, 1, 3}),
                Arguments.arguments(new int[]{0}, new int[] {0, 0, 4, 0}),
                Arguments.arguments(new int[]{1, 1 ,2}, new int[] {4, 1, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("trueWhenArrayContainOneAndFourProvider")
    void shouldReturnTrueWhenArrayContainOneAndFour(int[] arr){
        Assertions.assertTrue(Main.arrayContainOneAndFour(arr));
    }

    private static Stream<Arguments> trueWhenArrayContainOneAndFourProvider(){
        return Stream.of(
                Arguments.arguments(new int[] {1, 4}),
                Arguments.arguments(new int[] {1, 1, 4, 4})
        );
    }
    @ParameterizedTest
    @MethodSource("falseWhenArrayNotContainOneOrFourProvider")
    void shouldReturnFalseWhenArrayNotContainOneOrFour(int[] arr){
        Assertions.assertFalse(Main.arrayContainOneAndFour(arr));
    }

    private static Stream<Arguments> falseWhenArrayNotContainOneOrFourProvider(){
        return Stream.of(
                Arguments.arguments(new int[] {0, 2}),
                Arguments.arguments(new int[] {-5, -2, 152})
        );
    }





}
