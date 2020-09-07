package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    public SqlTracker() {
        this.cn = null;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement("insert into items (name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(String.valueOf(generatedKeys.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        int delete = 0;
        try (PreparedStatement ps = cn.prepareStatement("update items set name = ? where id = ?")) {
            ps.setString(1, item.getName());
            ps.setInt(2, Integer.parseInt(id));
            delete = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete == 1;
    }

    @Override
    public boolean delete(String id) {
        int delete = 0;
        try (PreparedStatement ps = cn.prepareStatement("delete from items where id = ?")) {
            ps.setInt(1, Integer.parseInt(id));
            delete = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete == 1;
    }

    @Override
    public List<Item> findAll() {
        ArrayList<Item> itemList = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from items")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(String.valueOf(rs.getInt("id")));
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        ArrayList<Item> itemList = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from items where name = ?")) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(String.valueOf(rs.getInt("id")));
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try (PreparedStatement ps = cn.prepareStatement("select * from items where id = ?")) {
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new Item(rs.getString("name"));
                item.setId(String.valueOf(rs.getInt("id")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}
