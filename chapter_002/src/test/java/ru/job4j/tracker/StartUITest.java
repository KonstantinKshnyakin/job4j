//package ru.job4j.tracker;
//
//import org.junit.Test;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
//
//public class StartUITest {
//
//    @Test
//    public void whenAddItem() {
//        String[] answers = {"Fix PC"};
//        Input input = new StubInput(answers);
//        Tracker tracker = new Tracker();
//        StartUI.createItem(input, tracker);
//        Item created = tracker.findAll()[0];
//        Item expected = new Item("Fix PC");
//        assertThat(created.getName(), is(expected.getName()));
//    }
//
//    @Test
//    public void whenAdd2Item() {
//        String[] answers = {"Fix PC", "Fix PC"};
//        Input input = new StubInput(answers);
//        Tracker tracker = new Tracker();
//        StartUI.createItem(input, tracker);
//        StartUI.createItem(input, tracker);
//        int length = tracker.findByName("Fix PC").length;
//        assertEquals(2, length);
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("new item");
//        tracker.add(item);
//        String[] answers = {
//                item.getId(),
//                "replaced item"
//        };
//        StartUI.editItem(new StubInput(answers), tracker);
//        Item replaced = tracker.findById(item.getId());
//        assertThat(replaced.getName(), is("replaced item"));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("deleted item");
//        tracker.add(item);
//        String[] answers = {item.getId()};
//        StartUI.delete(new StubInput(answers), tracker);
//        Item replaced = tracker.findById(item.getId());
//        assertEquals(replaced, null);
//    }
//}
//
