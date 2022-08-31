package heroRepository;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {

    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp(){
        heroRepository = new HeroRepository();
        hero = new Hero("Ubbe", 100);
    }

    @Test
    public void testGetCount(){
        heroRepository.create(hero);
        assertEquals(heroRepository.getCount(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNullHeroException(){
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateDuplicateHeroNameException(){
        heroRepository.create(hero);
        heroRepository.create(new Hero("Ubbe", 100));
    }

    @Test
    public void testSuccessfulHeroCreation(){
        assertEquals(heroRepository.create(hero), "Successfully added hero Ubbe with level 100");
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullHeroException(){
        heroRepository.create(hero);
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveEmptyNameHeroException(){
        heroRepository.create(hero);
        heroRepository.remove(" ");
    }

    @Test
    public void testSuccessfulRemove(){
        heroRepository.create(hero);
        assertTrue(heroRepository.remove("Ubbe"));
    }

    @Test
    public void testGetHeroWithHighestLevel(){
        Hero hero1 = new Hero("Ivar", 99);
        heroRepository.create(hero);
        heroRepository.create(hero1);

        assertEquals(heroRepository.getHeroWithHighestLevel(), hero);
    }

    @Test
    public void testGetHero(){
        heroRepository.create(hero);
        assertEquals(heroRepository.getHero("Ubbe"), hero);
    }

    @Test
    public void testGetHeroes(){
        heroRepository.create(hero);
        heroRepository.create(new Hero("Ivar", 100));
        heroRepository.getHeroes();
    }
}
