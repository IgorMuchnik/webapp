package org.example.dao;

import org.example.model.Category;
import org.example.util.ConnectionFactory;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoInterface {

    @Override
    public boolean createUser(User user) {
        try (Connection cn = ConnectionFactory.getConnection();
             PreparedStatement ps = cn.prepareStatement("INSERT INTO users (name, surname, email, category) " +
                     "VALUES (?, ?, ?, ?::category_type)")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCategory().name());

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public User deleteUser(long id) {
        try (Connection cn = ConnectionFactory.getConnection();
             Statement st = cn.createStatement();
             PreparedStatement ps = cn.prepareStatement("DELETE FROM users WHERE id=?")) {

            ps.setLong(1, id);
            User user = getById(id);

            int i = ps.executeUpdate();
            if (i == 1) {
                return user;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public User getById(Long id) {
        try (Connection cn = ConnectionFactory.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id=" + id)) {

            while (rs.next()) {
                return parseResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getAll() {
        try (Connection cn = ConnectionFactory.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users")) {

            List<User> users = new ArrayList<User>();
            while (rs.next()) {
                users.add(parseResultSet(rs));
            }

            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private User parseResultSet(ResultSet rs) {
        try {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));
            user.setCategory(Category.valueOf(rs.getString("category")));
            return user;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
