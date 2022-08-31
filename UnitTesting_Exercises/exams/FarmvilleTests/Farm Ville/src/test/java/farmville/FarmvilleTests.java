package farmville;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FarmvilleTests {

    private Farm farm;
    private Animal animal;

    @Before
    public void setUp(){
        farm = new Farm("Farmville", 10);
        animal = new Animal("goat", 10);
    }

    @Test
    public void testGetAnimalCount(){
        farm.add(animal);
        assertEquals(farm.getCount(), 1);
    }

    @Test
    public void testGetFarmName(){
        assertEquals(farm.getName(), "Farmville");
    }

    @Test
    public void testGetCapacity(){
        assertEquals(farm.getCapacity(), 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAnimalToFullFarmException(){
        farm = new Farm("Farmville", 1);
        Animal animal1 = new Animal("cow", 10);
        farm.add(animal);
        farm.add(animal1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingExistingAnimalException(){
        farm.add(animal);
        farm.add(animal);
    }

    @Test
    public void testRemovingAnimal(){
        farm.add(animal);
        assertTrue(farm.remove("goat"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSettingNegativeFarmCapacityException(){
        farm = new Farm("goat", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSettingFarmNullName(){
        farm = new Farm(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSettingFarmEmptyName(){
        farm = new Farm("", 1);
    }
}
