package pl.coderslab.admin;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class SolutionAdmin {
    public static void main(String[] args) {
        SolutionDao solutionDao = new SolutionDao();
        String option = null;
        Scanner scanner = new Scanner(System.in);
        do {
            Solution[] allSolutions = solutionDao.findAllSolutions();
            for (Solution solution : allSolutions) {
                System.out.println(solution);
            }
            System.out.print("Wybierz jedną z opcji - add, view, quit: ");
            while (!scanner.hasNextLine()) {
                scanner.nextLine();
                System.out.print("Wybierz poprawną opcję: ");
            }
            option = scanner.next();
            Solution solution = new Solution();
            switch (option) {
                case "add":
                    Date date = new Date();
                    UserDao userDao = new UserDao();
                    User[] users = userDao.findAllUsers();
                    ExerciseDao exerciseDao = new ExerciseDao();
                    Exercise exercise = new Exercise();
                    for (User user: users) {
                        System.out.println(user);
                    }
                    System.out.println("Podaj id użytkownika: ");
                    int userId = scanner.nextInt();
                    Exercise[] exercises = exerciseDao.findAllExercises();
                    for(Exercise exercise1: exercises) {
                        System.out.println(exercise1);
                    }
                    System.out.println("Podaj id zadania: ");
                    int exerciseId = scanner.nextInt();
                    solution.setCreated(LocalDate.now().toString());
                    solution.setUpdated(null);
                    solution.setDescription(null);
                    solution.setExercise_id(exerciseId);
                    solution.setUser_id(userId);
                    solutionDao.createSolution(solution);
                    break;
                case "view":
                    System.out.println("Wprowadź id użytkownika, którego rozwiązania chcesz zobaczyć: ");
                    int solutionId = scanner.nextInt();
                    Solution[] solutions = solutionDao.findAllSolutionsByUserId(solutionId);
                    for (Solution solution1: solutions) {
                        System.out.println(solution1);
                    }
                    break;
                case "quit":
                default:
                    break;
            }
        } while ("quit".equalsIgnoreCase(option));
    }
}
