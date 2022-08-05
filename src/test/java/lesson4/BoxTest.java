package lesson4;

import org.junit.jupiter.api.*;

public class BoxTest {
    Box box;

    @Nested
    class WhenEmptyBox {
        @BeforeEach
        void createEmptyBox(){
            box = new Box();
        }

        @Test
        void whenDeleteBallException() {
            Assertions.assertThrows(BoxIsEmptyException.class, () -> box.deleteBall()); // передаем тип исключения и лямбда-выражение
        }

        @Nested
        class WhenOneBall {
            @BeforeEach
            void addBall() {
                box.addBall();
            }

            @Test
            void deleteBall() throws BoxIsEmptyException {
                box.deleteBall();
                Assertions.assertEquals(0, box.getBallsCount());
            }
        }
        @Nested
        class TestCl {

        }
    }
}
