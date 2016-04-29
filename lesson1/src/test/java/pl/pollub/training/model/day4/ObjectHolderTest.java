package pl.pollub.training.model.day4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectHolderTest {

    private IObjectHolder<Integer> holder = new IntegerHolder();

    @After
    public void clearAfter() {
        holder = new IntegerHolder();
    }

    @Before
    public void clearBefore() {
        holder = new IntegerHolder();
    }

    @Test
    public void remove() throws Exception {
        holder.add(1);
        assertEquals(1, holder.size());
        holder.remove(1);
        assertEquals(0, holder.size());
    }

    @Test
    public void add() throws Exception {
        holder.add(5, 6);
        assertEquals(2, holder.size());
    }
}