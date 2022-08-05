package lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {

   private static Logger logger = LoggerFactory.getLogger("FunctionsTest");

   @BeforeAll
   static void beforeAll() {
      logger.info("Метод выполняется 1 раз перед всеми тестами класса");
   }

   @BeforeEach
   void beforeEach() {
      logger.info("Метод выполняется перед каждым тестом класса");
   }

   @Test
   @DisplayName("Метод проверки площади существующего треугольника ")
   void AreaOfTriangleEqualTest() throws SizeLengthIsNotPositiveException {
      Triangle triangle = new Triangle(1,1,1); //0.4330127018922193
      Assertions.assertEquals(0.4330127018922193,triangle.getArea());
   }

   @Test
   @DisplayName("Метод проверки  попытки создать несуществующий треугольник")
   void NotExistsTriangleTest() throws SizeLengthIsNotPositiveException {
         Assertions.assertThrows(SizeLengthIsNotPositiveException.class, () -> new Triangle(10, 2, 1));
   }

   @ParameterizedTest
   @CsvSource({"1, 1, 1, 0.4330127018922193", "1, 3, 3, 1.479019945774904"})
   @DisplayName("Метод проверки площади существующего треугольника при помощи CSV data provider")
   void AreaOfTriangleEqualCsvTest(double a, double b, double c, double expectedResult) throws SizeLengthIsNotPositiveException {

      try {
         Triangle triangle = new Triangle(a, b, c);
         double actualResult = triangle.getArea();
         Assertions.assertEquals(expectedResult, actualResult);
      }
       catch(SizeLengthIsNotPositiveException e) {}
   }

   @AfterEach
   void afterEach() {
      logger.info("Метод выполняется 1 раз после каждого теста класса");
   }

   @AfterAll
   static void afterAll() {
      logger.info("Метод выполняется 1 раз после всех тестов класса");
   }

}
