package ru.job4j.tracker.store;


import java.sql.*;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;

import java.io.InputStream;
import java.util.*;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
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
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {

        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO items (name, created) VALUES (?, ?)")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        boolean rslt;
        try (PreparedStatement ps = cn.prepareStatement("UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            rslt = ps.execute();
        }
        return rslt;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rslt;
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM items WHERE id = ?")) {
            ps.setInt(1, id);
            rslt = ps.execute();
        }
        return rslt;
    }


    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> rslt = new LinkedList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from items")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rslt.add(new Item(rs.getInt(1)
                        , rs.getString(2)
                        , rs.getTimestamp(3).toLocalDateTime()));
            }
        }
        return rslt;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> rslt = new LinkedList<>();
        try (PreparedStatement ps = cn.prepareStatement("select * from items where name like ?")) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rslt.add(new Item(rs.getInt(1)
                        , rs.getString(2)
                        , rs.getTimestamp(3).toLocalDateTime()));
            }
        }
        return rslt;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item rslt = new Item();
        try (PreparedStatement ps = cn.prepareStatement("select * from items where id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            rslt.setId(rs.getInt(1));
            rslt.setName(rs.getString(2));
            rslt.setCreated(rs.getTimestamp(3).toLocalDateTime());
        }
        return rslt;
    }
}