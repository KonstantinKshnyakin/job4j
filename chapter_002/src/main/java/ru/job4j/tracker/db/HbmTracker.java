package ru.job4j.tracker.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.Item;

import java.util.List;
import java.util.function.Function;

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
        transaction(session -> session.save(item));
        return item;
    }

    @Override
    public boolean replace(Integer id, Item item) {
        return transaction(session ->
                session.createQuery(
                        "update Item i set i.name = :name, i.description = :description where i.id = :id"
                )
                        .setParameter("id", item.getId())
                        .setParameter("description", item.getDescription())
                        .executeUpdate() == 1
        );
    }

    @Override
    public boolean delete(Integer id) {
        return transaction(session ->
                session.createQuery("delete from Item i where i.id = :id")
                        .setParameter("id", id)
                        .executeUpdate() == 1
        );
    }

    @Override
    public List<Item> findAll() {
        return transaction(session ->
                session.createQuery("select i from Item i", Item.class)
                        .getResultList()
        );
    }

    @Override
    public List<Item> findByName(String name) {
        return transaction(session ->
                session.createQuery("select i from Item i where i.name = :name", Item.class)
                        .setParameter("name", name)
                        .getResultList()

        );
    }

    @Override

    public Item findById(Integer id) {
        return transaction(
                session -> session.get(Item.class, id)
        );
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    private <T> T transaction(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
