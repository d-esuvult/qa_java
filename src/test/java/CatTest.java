import com.example.Cat;
import com.example.Feline;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    @Test
    public void getSound() {
        Cat cat = new Cat(feline);
        System.out.println(cat.getSound());
        assertEquals("Мяу", cat.getSound());
    }

     @Test
     public void getFood() throws Exception {
        Feline realFeline = new Feline();
         Cat cat = new Cat(realFeline);
         List<String> listOfAnimals = List.of("Животные", "Птицы", "Рыба");
         assertEquals(listOfAnimals,cat.getFood());
     }
}
