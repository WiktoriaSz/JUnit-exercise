package test;

import exercise.com.Basket;
import exercise.com.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BasketTest {

    Basket basket;
    Item doll;
    Item lego;
    Item train;

    @Before
    public void setUp() {
        basket = new Basket();
        doll = new Item("lalka", 25.20);
        lego = new Item("lego", 40.50);
        train = new Item("ciufcia", 30.00);
    }

    @Test
    public void addOneTest() {
        basket.addItem(doll);
        assertTrue(basket.getItemList().containsKey(doll));
    }

    @Test
    public void addFewTest() {
        basket.addFew(doll, 3);
        assertTrue(basket.getItemList().containsKey(doll));
        assertEquals(3, (int) basket.getItemList().get(doll));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFewExceptionTest() {
        basket.addFew(doll, -2);
        assertTrue(basket.getItemList().containsKey(doll));
    }

    @Test
    public void deleteItemFromList() {
        basket.addFew(doll, 3);
        basket.deleteAllOfThisItems(doll);
        assertFalse(basket.getItemList().containsKey(doll));
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteNonExistingItemExceptionTest() {
        basket.deleteAllOfThisItems(lego);
    }

    @Test
    public void deleteOne() {
        basket.addFew(doll, 3);
        basket.deleteParticularQuantity(doll, 1);
        assertTrue(basket.getItemList().containsKey(doll));
        assertEquals(2, (int) basket.getItemList().get(doll));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteFewMinusQuantityExceptionTest() {
        basket.addFew(doll, 3);
        basket.deleteParticularQuantity(doll, -2);
        basket.deleteParticularQuantity(doll, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteTooManyQuantityExceptionTest() {
        basket.addFew(doll, 3);
        System.out.println("Quantity of this item is: " + basket.getItemList().get(doll));
        basket.deleteParticularQuantity(doll, 10);
    }

    @Test
    public void printTest(){
        basket.addItem(doll);
        basket.addItem(lego);
        assertEquals("Basket = [lalka=1, lego=1]", basket.toString());
    }

    @Test
    public void printPriceTest() {
        basket.addItem(doll);
        basket.addItem(lego);
        basket.addFew(train, 2);
        assertEquals(125.70, basket.fullPrice(), 0.001);
    }
}
