
import com.example.Feline;
import com.example.Lion;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean checkSex;

    public LionTest(String sex, boolean sexTwo) {
        this.sex = sex;
        this.checkSex = sexTwo;
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
        Lion lion = new Lion(sex);
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
        Lion lion = new Lion("");
        lion.doesHaveMane();
    }
    Feline feline = Mockito.mock(Feline.class);
    @Test
    public void returnOneKitten() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    // Тут я не знаю как вернуть список

    @Test
    public void returnListOfFoods() throws Exception {
        Feline realFeline = new Feline();
        Lion lion = new Lion(realFeline);
        List<String> listOfAnimals = List.of("Животные", "Птицы", "Рыба");
        assertEquals(listOfAnimals, lion.getFood());
    }
}
