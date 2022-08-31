import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] ARRAY = {1, 5, 4, 7, 9};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        this.database = new Database(ARRAY);
    }


    @Test
    public void testIfConstructorCreatesValidObject(){
        Assert.assertEquals("Count of elements is incorrect", database.getElements().length, ARRAY.length);
        Assert.assertArrayEquals("Arrays are not the same",database.getElements(), ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] array = new Integer[17];
        new Database(array);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForZeroElements() throws OperationNotSupportedException {
        Integer[] array = new Integer[0];
        new Database(array);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForAddingNullAsElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddingElementCorrectly() throws OperationNotSupportedException {
        database.add(7);
        Assert.assertEquals(database.getElements().length, ARRAY.length + 1);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], Integer.valueOf(7));
    }

    @Test
    public void testRemovingAnElement() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(database.getElements().length, ARRAY.length - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForRemovingAnElement() throws OperationNotSupportedException {
        for (int i = 0; i < ARRAY.length; i++) {
            database.remove();
        }

        database.remove();
    }

}
