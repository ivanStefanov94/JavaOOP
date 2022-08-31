import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class IteratorTest {

    private ListIterator listIterator;
    private static final String[] ARRAY = {"John", "Bob", "Tom"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForCreatingAnObjectWithNullElements() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testHasNext(){
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();

        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();

        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove(){
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintException() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrint(){
        Assert.assertEquals(listIterator.print(), ARRAY[0]);
    }
}
