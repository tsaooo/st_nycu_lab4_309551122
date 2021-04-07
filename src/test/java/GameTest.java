import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game testGame;
    static Stream<Arguments> WinCaseProvider() {
        return Stream.of(
                Arguments.of("r", "s"),
                Arguments.of("p", "r"),
                Arguments.of("s", "p")
        );
    }
    static Stream<Arguments> DrawCaseProvider() {
        return Stream.of(
                Arguments.of("r", "r"),
                Arguments.of("p", "p"),
                Arguments.of("s", "s")
        );
    }
    static Stream<Arguments> LoseCaseProvider() {
        return Stream.of(
                Arguments.of("r", "p"),
                Arguments.of("p", "s"),
                Arguments.of("s", "r")
        );
    }
    @BeforeEach
    public void setup(){
        testGame = new Game();
    }
    @Test
    public void ValidInputTest(){
        assertThrows(IllegalArgumentException.class, ()->{
            testGame.validate("abc", "r");
        });
    }
    @ParameterizedTest()
    @MethodSource("DrawCaseProvider")
    public void DrawTest(String p1, String p2){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testGame.play(p1, p2);
        assertEquals(outContent.toString(), "Draw!\n");
    }
    @ParameterizedTest()
    @MethodSource("WinCaseProvider")
    public void Player2WinTest(String p1, String p2){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testGame.play(p1, p2);
        assertEquals(outContent.toString(), "Player 1 win!\n");
    }
    @ParameterizedTest()
    @MethodSource("LoseCaseProvider")
    public void Player1WinTest(String p1, String p2){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testGame.play(p1, p2);
        assertEquals(outContent.toString(), "Player 2 win!\n");
    }
}