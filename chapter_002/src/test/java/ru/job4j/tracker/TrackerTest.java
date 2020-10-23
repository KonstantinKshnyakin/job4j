package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.db.MemTracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenItemNameDontExistThenReturnNull() {
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        List<Item> result = tracker.findByName("SoS");
        assertThat(result.size(), is(0));
    }

    @Test
    public void whenAdd4ItemsThenReturn4Items() {
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("L0"));
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        tracker.add(new Item("L3"));
        List<Item> all = tracker.findAll();
        for (int i = 0; i < all.size(); i++) {
            assertEquals(all.get(i).getName(), ("L" + i));
            assertNotNull(all.get(i).getId());
        }
    }

    @Test
    public void whenItemDontExistThenReturnNull() {
        MemTracker tracker = new MemTracker();
        List<Item> all = tracker.findAll();
        for (Item item : all) {
            assertNull(item);
        }
    }

    @Test
    public void whenAdd2ItemsWithEqualNameThenReturn2Items() {
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("L0"));
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        tracker.add(new Item("L0"));
        List<Item> all = tracker.findByName("L0");
        assertEquals(all.size(), 2);
    }

    @Test
    public void whenAddItemsAndNotEqualNameThenReturn2Items() {
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("L0"));
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        tracker.add(new Item("L0"));
        List<Item> all = tracker.findByName("L");
        assertEquals(all.size(), 0);
    }

    @Test
    public void whenReplace() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        Integer id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        Integer id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void compareReversTest() {
        Item item5 = new Item("item5");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        List<Item> list = Arrays.asList(item5, item1, item2);
        Collections.sort(list, new ItemsReversSort());
        List<Item> expected = Arrays.asList(item5, item2, item1);
        Assert.assertEquals(expected, list);
    }

    @Test
    public void compareTest() {
        Item item5 = new Item("item5");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        List<Item> list = Arrays.asList(item5, item1, item2);
        Collections.sort(list);
        List<Item> expected = Arrays.asList(item1, item2, item5);
        Assert.assertEquals(expected, list);
    }
}
