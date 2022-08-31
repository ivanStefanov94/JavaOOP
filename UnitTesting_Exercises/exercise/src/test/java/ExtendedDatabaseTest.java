import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {

    private Database database;
    private static final Person[] PEOPLE ={
            new Person(1, "John"),
            new Person(2, "Maria"),
            new Person(3, "Tom")
    };

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
       database = new Database(PEOPLE);
    }

    @Test
    public void testIfConstructorCreatesValidObject(){
        Assert.assertEquals(database.getElements().length, PEOPLE.length);
        Assert.assertArrayEquals(database.getElements(), PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForZeroElements() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    @Test
    public void testPersonGetters(){
        Assert.assertEquals(database.getElements()[0].getId(), 1);
        Assert.assertEquals(database.getElements()[0].getUsername(), "John");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForAddingNullValue() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddingElementCorrectly() throws OperationNotSupportedException {
        Person david = new Person(4,"David");
        database.add(david);
        Assert.assertEquals(database.getElements().length, PEOPLE.length + 1);
        Assert.assertEquals(database.getElements()[3].getUsername(), "David");
    }

    @Test
    public void testRemovingElementCorrectly() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(database.getElements().length, PEOPLE.length - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForRemovingElement() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForZeroInputWhenSearchingById() throws OperationNotSupportedException {
        database.findById(0);
    }

    @Test
    public void testSearchingById() throws OperationNotSupportedException {
        Assert.assertEquals(database.findById(1), database.getElements()[0]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForNullInputWhenSearchingByUsername() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForEmptyDBWhenSearchingByUsername() throws OperationNotSupportedException {
        Database database = new Database(new Person[5]);
        database.findByUsername("John");
    }

    @Test
    public void testSearchingByUsername() throws OperationNotSupportedException {
        Assert.assertEquals(database.findByUsername("John"), database.getElements()[0]);
    }
}
