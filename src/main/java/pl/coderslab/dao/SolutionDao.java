package pl.coderslab.dao;

import pl.coderslab.db.DBUtil;
import pl.coderslab.model.Solution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {
    private static final String CREATE_SOLUTION_QUERY = "INSERT INTO solutions(created, updated, description,exercise_id, user_id) VALUES (?,?,?,?,?)";
    private static final String READ_SOLUTION_QUERY = "SELECT * FROM solutions WHERE id = ?";
    private static final String UPDATE_SOLUTION_QUERY = "UPDATE solutions SET created = ?, updated = ?, description = ?, exercise_id = ?, user_id = ? where id = ?";
    private static final String DELETE_SOLUTION_QUERY = "DELETE FROM solutions WHERE id = ?";
    private static final String FIND_ALL_SOLUTIONS_QUERY = "SELECT * FROM solutions";
    private static final String FIND_ALL_SOLUTIONS_BY_USER_ID_QUERY = "SELECT * FROM solutions WHERE user_id = ?";
    private static final String FIND_ALL_BY_EXERCISE_ID_QUERY = "SELECT * FROM solutions WHERE exercise_id = ? ORDER BY created ASC ";
    private static final String FIND_ALL_EXERCISES_WITHOUT_SOLUTION_QUERY = "SELECT * FROM solutions WHERE user_id = ? AND description IS NULL";
    private static final String FIND_RECENT_SOLUTIONS_QUERY = "SELECT solutions.*, users.username, exercises.title " +
            "FROM " +
            "solutions INNER JOIN users On solutions.user_id = users.id " +
            "INNER JOIN exercises ON solutions.exercise_id = exercises.id" +
            " ORDER BY created DESC LIMIT ?";

    public Solution readSolution(int solution_id) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, solution_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUser_id(resultSet.getInt("user_id"));
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Solution createSolution(Solution solution) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_SOLUTION_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, solution.getCreated());
            statement.setString(2, solution.getUpdated());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getExercise_id());
            statement.setInt(5, solution.getUser_id());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                solution.setId(resultSet.getInt(1));
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateSolution(Solution solution) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_SOLUTION_QUERY);
            statement.setString(1, solution.getCreated());
            statement.setString(2, solution.getUpdated());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getExercise_id());
            statement.setInt(5, solution.getUser_id());
            statement.setInt(6, solution.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSolution(int solution_id) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_SOLUTION_QUERY);
            statement.setInt(1, solution_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Solution> findAllSolutions() {
        try (Connection conn = DBUtil.getConnection()) {
            List<Solution> solutions = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTIONS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUser_id(resultSet.getInt("user_id"));
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Solution> findAllSolutionsByUserId(int userId) {
        try (Connection connection = DBUtil.getConnection()) {
            List<Solution> found = new ArrayList<>();
            Solution solution = new Solution();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_SOLUTIONS_BY_USER_ID_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUser_id(resultSet.getInt("user_id"));
                found.add(solution);
            }
            return found;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Solution> findAllSolutionsByExerciseId(int exerciseId) {
        List<Solution> found = new ArrayList<>();
        Solution solution = new Solution();
        try (Connection connection = DBUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_EXERCISE_ID_QUERY);
            statement.setInt(1, exerciseId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUser_id(resultSet.getInt("user_id"));
                found.add(solution);
            }
            return found;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<Solution> findAllExercisesWithoutSolution(int userId) {
        List<Solution> solutions = new ArrayList<>();
        Solution solution = new Solution();
        try (Connection connection = DBUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_EXERCISES_WITHOUT_SOLUTION_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUser_id(resultSet.getInt("user_id"));
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    private Solution[] addToArray(Solution solution, Solution[] solutions) {
//        Solution[] tmpSolutions = Arrays.copyOf(solutions, solutions.length + 1);
//        tmpSolutions[solutions.length] = solution;
//        return tmpSolutions;
//    }

    public List<Solution> findRecent(int limit) {
        try (Connection conn = DBUtil.getConnection()) {
            List<Solution> solutions = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_RECENT_SOLUTIONS_QUERY);
            statement.setInt(1, limit);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUser_id(resultSet.getInt("user_id"));
                solution.setUsername(resultSet.getString("username"));
                solution.setExerciseTitle(resultSet.getString("title"));
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
