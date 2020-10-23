package ru.job4j.tracker.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.Item;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private StandardServiceRegistry registry;
    private SessionFactory sf;

    @Override
    public void init() {
        registry = new StandardServiceRegistryBuilder()
                .configure().build();
        sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(Integer id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Item i where i.id = :id");
        query.setParameter("id", id);
        int update = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return update == 1;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        Query<Item> query = session.createQuery(
                "select i from Item i",
                Item.class
        );
        List<Item> itemList = query.list();
        session.getTransaction().commit();
        session.close();
        return itemList;
    }

    @Override
    public List<Item> findByName(String name) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query<Item> query = session.createQuery(
                "select i from Item i where i.name = :name",
                Item.class
        );
        query.setParameter("name", name);
        List<Item> item = query.list();
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override

    public Item findById(Integer id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
