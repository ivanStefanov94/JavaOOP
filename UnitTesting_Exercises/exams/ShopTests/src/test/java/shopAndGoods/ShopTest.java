package shopAndGoods;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;


import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {

    private Shop shop;
    private Map<String, Goods> shelves;
    private Goods goods;

    @Before
    public void setUp(){
        Shop shop = new Shop();
        Goods goods = new Goods("Sugar", "1646546");
        Goods goods1 = new Goods("Rice", "146846");

        this.shelves = new LinkedHashMap<>();

        shelves.put("Shelf2", goods1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionForAddGoods() throws OperationNotSupportedException {

        shop = new Shop();
        shop.addGoods("Shelf1", goods);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForAddGoodsItemExists() throws OperationNotSupportedException {

        shop = new Shop();
        shop.addGoods("Shelves1", goods);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testExceptionForAddGoodsNotNull() throws OperationNotSupportedException {

        shop = new Shop();
        shop.addGoods("Shelves1", new Goods("jam", "222"));
        shop.addGoods("Shelves1", new Goods("jam", "222"));
    }

    @Test
    public void testAddGoods() throws OperationNotSupportedException {
        shop = new Shop();
        //shelves.put("Shelves1",goods);
        assertEquals(shop.addGoods("Shelves1", new Goods("Jam", "151515")), "Goods: 151515 is placed successfully!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveException() throws OperationNotSupportedException {
        shop = new Shop();
        shop.removeGoods("Shelff1", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveExceptionGoodsDoNotExist() throws OperationNotSupportedException {
        shop = new Shop();
        shop.removeGoods("Shelves1", new Goods("Rice", "15151"));
    }

    @Test
    public void testRemoveGoods() throws OperationNotSupportedException {
        shop = new Shop();
        goods = new Goods("Jam", "151515");
        shop.addGoods("Shelves1", goods);

        assertEquals(shop.removeGoods("Shelves1", goods), "Goods: 151515 is removed successfully!");
    }

    @Test
    public void testGetName(){
        goods = new Goods("Jam", "151515");
       assertEquals(goods.getName(), "Jam");
    }

}