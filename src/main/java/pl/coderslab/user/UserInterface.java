package pl.coderslab.user;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Solution;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        int userId = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        String option = null;
        SolutionDao solutionDao = new SolutionDao();
        do {
            System.out.print("Wybierz jedną z opcji: add, view");
            option = scanner.next();
            switch (option) {
                case "add":
                    Solution solution = new Solution();
                    Solution[] solutions = solutionDao.findAllSolutionsByUserId(userId);
                    for (Solution sol : solutions) {
                        System.out.println(sol);
                    }
                    Solution[] sols = solutionDao.findAllExercisesWithoutSolution(userId);
                    for (Solution solution1 : sols) {
                        System.out.println(sols);
                    }
                    System.out.println("Podaj id zadania, do którego chcesz wprowadzić rozwiązanie: ");
                    int exerciseId = scanner.nextInt();
                    solution = solutionDao.readSolution(exerciseId);
                    System.out.print("Wpisz rozwiązanie: ");
                    String description = scanner.nextLine();
                    Solution toUpdate = new Solution();
                    toUpdate.setId(solution.getId());
                    toUpdate.setCreated(solution.getCreated());
                    toUpdate.setUpdated(LocalDate.now().toString());
                    toUpdate.setDescription(description);
                    toUpdate.setExercise_id(solution.getExercise_id());
                    toUpdate.setUser_id(solution.getUser_id());
                    solutionDao.updateSolution(toUpdate);
                    break;
                case "view":
                    Solution[] solutions1 = solutionDao.findAllSolutionsByUserId(userId);
                    for (Solution solution1: solutions1) {
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
