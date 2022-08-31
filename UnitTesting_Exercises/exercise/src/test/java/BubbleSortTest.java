import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

public class BubbleSortTest {

    @Test
    public void testSorting(){
        int[] arrayBeforeSorting = {5, 1, 3};
        Bubble.sort(arrayBeforeSorting);
        int[] arrayAfterSorting = {1, 3, 5};

        Assert.assertArrayEquals(arrayBeforeSorting, arrayAfterSorting);
    }
}
