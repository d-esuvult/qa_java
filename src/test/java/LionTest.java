
import com.example.Feline;
import com.example.Lion;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionTest {

    Feline felineMock = Mockito.mock(Feline.class);

    private final String sex;
    private final boolean checkSex;

    public LionTest(String sex, boolean checkSex) {
        this.sex = sex;
        this.checkSex = checkSex;
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }


    @Test
    public void returnTwoManes() throws Exception {
        Lion lion = new Lion(sex, felineMock);
        System.out.println(lion.doesHaveMane() + " " + lion.getSex());
        assertEquals(checkSex, lion.doesHaveMane());
    }

    // Проверка текста ошибки
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testManeException() throws Exception {
        thrown.expect(Exception.class);
        //you can test the exception message like
        thrown.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        Lion lion = new Lion("", felineMock);
        lion.doesHaveMane();
    }
    @Test
    public void returnOneKitten() throws Exception {
        Lion lion = new Lion(sex, felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void returnListOfFoods() throws Exception {
        Lion lion = new Lion(sex, felineMock);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> listOfAnimals = List.of("Животные", "Птицы", "Рыба");
        assertEquals(listOfAnimals, lion.getFood());
    }
}
