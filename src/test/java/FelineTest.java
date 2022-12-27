import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int expectedNumberOfKittens;
    private final int actualNumberOfKittens;
    public FelineTest(int numberOfKittens, int actualNumberOfKittens){
        this.expectedNumberOfKittens = numberOfKittens;
        this.actualNumberOfKittens = actualNumberOfKittens;
    }
    @Parameterized.Parameters
    public static Object[][] getKittens(){
        return new Object[][]{
                {1, 1},
                {10, 10},
                {0, 0}
        };
    }
    @Test
    public void returnListOfFoods() throws Exception {
        Feline feline = new Feline();
        List<String> listOfAnimals = List.of("Животные", "Птицы", "Рыба");
        assertEquals(listOfAnimals, feline.eatMeat());
    }
    @Test
    public void returnFelineFamily(){
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void returnOneKitten(){
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
    @Test
    public void returnNumberOfKittens(){
        Feline feline = new Feline();
        assertEquals(expectedNumberOfKittens, feline.getKittens(actualNumberOfKittens));
    }
}
