package pl.coderslab.dao;

import pl.coderslab.db.DBUtil;
import pl.coderslab.model.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupDao {
    private static final String CREATE_GROUP_QUERY = "INSERT INTO `groups`(name) VALUES (?)";
    private static final String READ_GROUP_QUERY = "SELECT * FROM `groups` WHERE id = ?";
    private static final String UPDATE_GROUP_QUERY = "UPDATE `groups` SET name = ? where id = ?";
    private static final String DELETE_GROUP_QUERY = "DELETE FROM `groups` WHERE id = ?";
    private static final String FIND_ALL_GROUPS_QUERY = "SELECT * FROM `groups`";

    public Group readGroup(int group_id) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_GROUP_QUERY);
            statement.setInt(1, group_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("name"));
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Group create(Group group) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_GROUP_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                group.setId(resultSet.getInt(1));
            }
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateGroup(Group group) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_GROUP_QUERY);
            statement.setString(1, group.getName());
            statement.setInt(2, group.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGroup(int groupId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_GROUP_QUERY);
            statement.setInt(1, groupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Group> findAllGroups() {
        try (Connection conn = DBUtil.getConnection()) {
            List<Group> groups = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_GROUPS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("name"));
                groups.add(group);
            }
            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Group[] addToArray(Group g, Group[] groups) {
        Group[] tmpGroups = Arrays.copyOf(groups, groups.length + 1);
        tmpGroups[groups.length] = g;
        return tmpGroups;
    }
}
