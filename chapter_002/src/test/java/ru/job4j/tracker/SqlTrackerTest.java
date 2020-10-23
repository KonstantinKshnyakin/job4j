package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.db.SqlTracker;
import ru.job4j.tracker.db.Store;
import ru.job4j.tracker.db.connection.ConnectionRollback;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws SQLException {
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenItemNameDontExistThenReturnNull() throws SQLException {
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        List<Item> result = tracker.findByName("SoS");
        for (Item item : result) {
            assertNull(item);
        }
    }

    @Test
    public void whenAdd4ItemsThenReturn4Items() throws SQLException {
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
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
    public void whenItemDontExistThenReturnNull() throws SQLException {
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        List<Item> all = tracker.findAll();
        for (Item item : all) {
            assertNull(item);
        }
    }

    @Test
    public void whenAdd2ItemsWithEqualNameThenReturn2Items() throws SQLException {
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        tracker.add(new Item("L0"));
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        tracker.add(new Item("L0"));
        List<Item> all = tracker.findByName("L0");
        assertEquals(all.size(), 2);
    }

    @Test
    public void whenAddItemsAndNotEqualNameThenReturn2Items() throws SQLException {
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        tracker.add(new Item("L0"));
        tracker.add(new Item("L1"));
        tracker.add(new Item("L2"));
        tracker.add(new Item("L0"));
        List<Item> all = tracker.findByName("L");
        assertEquals(all.size(), 0);
    }

    @Test
    public void whenReplace() throws SQLException {
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item bug = new Item("Bug");
        tracker.add(bug);
        Integer id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() throws SQLException {
        Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item bug = new Item("Bug");
        tracker.add(bug);
        Integer id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}
