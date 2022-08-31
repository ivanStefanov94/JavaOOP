package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTest {

    private Aquarium aquarium;
    private Fish fish;
    private static final String NAME = "Atlantis";
    private static final int CAPACITY = 50;

    @Before
    public void setUp(){
        aquarium = new Aquarium(NAME, CAPACITY);
        fish = new Fish("Johnny");
    }

    @Test
    public void testAquariumGetters(){
        Assert.assertEquals(aquarium.getName(), NAME);
        Assert.assertEquals(aquarium.getCapacity(), CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testExceptionForNullOrEmptyAquariumName(){
        aquarium = new Aquarium(null, CAPACITY);
        aquarium = new Aquarium("", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionForNegativeCapacity(){
        aquarium = new Aquarium(NAME, -1);
    }

    @Test
    public void testFishClass(){
        Assert.assertEquals(fish.getName(), "Johnny");
        Assert.assertTrue(fish.isAvailable());
    }

    @Test
    public void testGetCountOfFish(){
        aquarium.add(fish);
        Assert.assertEquals(aquarium.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionForAddingFishWhenInsufficientAquariumCapacity(){
        aquarium = new Aquarium(NAME, 1);
        Fish fish1 = new Fish("Pesho");

        aquarium.add(fish);
        aquarium.add(fish1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionForRemovingNonExistingFish(){
        aquarium.remove("Tom");
    }

    @Test
    public void testSuccessfulRemoveOfFish(){
        aquarium.add(fish);
        aquarium.remove("Johnny");
        Assert.assertEquals(aquarium.getCount(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionForSellNonExistingFish(){
        aquarium.sellFish("Bob");
    }

    @Test
    public void testSuccessfulFishSell(){
        aquarium.add(fish);
        Assert.assertEquals(aquarium.sellFish("Johnny"), fish);
        Assert.assertFalse(fish.isAvailable());
    }

    @Test
    public void testReport(){
        aquarium.add(fish);
        aquarium.report();
    }
}
