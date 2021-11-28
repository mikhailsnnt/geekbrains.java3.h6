import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
class ArrayUtilTest {
    @ParameterizedTest
    @MethodSource("validGetAfterLastFourDigitsData")
    void getAfterLastFourDigits_shouldReturnValid(int[] input,int[] expected) {
        Assertions.assertArrayEquals(expected,ArrayUtil.getAfterLastFourDigits(input));
    }
    @ParameterizedTest
    @MethodSource("errorGetAfterLastFourDigitsData")
    void getAfterLastFourDigits_shouldThrowError(int[] input){
        Assertions.assertThrows(RuntimeException.class, ()->ArrayUtil.getAfterLastFourDigits(input));
    }
    private static Stream<Arguments> validGetAfterLastFourDigitsData(){
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5,6},new int[]{5,6}),
                Arguments.of(new int[]{4,1,5,4,6,7}, new int[]{6,7}),
                Arguments.of(new int[]{4,4,4,4,4,4}, new int[0]),
                Arguments.of(new int[]{4,2},new int[]{2})
        );
    }
    private static Stream<Arguments> errorGetAfterLastFourDigitsData(){
        return Stream.of(
                Arguments.of((Object) new int[]{1,23,123,23,44}),
                Arguments.of((Object) new int[0]),
                Arguments.of((Object)new int[]{1,2})
        );
    }

}