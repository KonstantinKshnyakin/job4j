package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenItemNameDontExistThenReturnNull() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        Item result = tracker.findById("SoS");
        assertNull(result);
    }

    @Test
    public void whenAdd4ItemsThenReturn4Items() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("L0"));
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        tracker.add(new Item("L3"));
        Item[] all = tracker.findAll();
        for (int i = 0; i < all.length; i++) {
            assertEquals(all[i].getName(), ("L" + i));
            assertNotNull(all[i].getId());
        }
    }

    @Test
    public void whenItemDontExistThenReturnNull() {
        Tracker tracker = new Tracker();
        Item[] all = tracker.findAll();
        for (int i = 0; i < all.length; i++) {
            assertNull(all[i]);
        }
    }

    @Test
    public void whenAdd2ItemsWithEqualNameThenReturn2Items() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("L0"));
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        tracker.add(new Item("L0"));
        Item[] all = tracker.findByName("L0");
        assertEquals(all.length, 2);
    }

    @Test
    public void whenAddItemsAndNotEqualNameThenReturn2Items() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("L0"));
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        tracker.add(new Item("L0"));
        Item[] all = tracker.findByName("L");
        assertEquals(all.length, 0);
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}
