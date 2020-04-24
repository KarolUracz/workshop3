package pl.coderslab.admin;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import java.util.Scanner;

public class ExerciseAdmin {
    public static void main(String[] args) {
        ExerciseDao exerciseDao = new ExerciseDao();
        String option = null;
        do {
            Exercise[] exercises = new Exercise[0];
            for (Exercise exercise: exercises) {
                System.out.println(exercise);
            }
            System.out.println("Wybierz jedną z opcji: add, edit, delete, quit");
            System.out.print("Select: ");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextLine()){
                System.out.print("Wprowadź poprawną opcję: ");
                scanner.next();
            }
            option = scanner.nextLine();
            switch (option) {
                case "add":
                    Exercise exercise = new Exercise();
                    System.out.print("Wprowadź nowy tytuł zadania: ");
                    String newTitle = scanner.next();
                    System.out.println("Wprowadź nowy opis: ");
                    String newDescription = scanner.next();
                    exercise.setTitle(newTitle);
                    exercise.setDescription(newDescription);
                    exerciseDao.createExercise(exercise);
                    break;
                case "edit":
                    System.out.print("Podaj id ćwiczenia do edycji: ");
                    int exerciseId = scanner.nextInt();
                    Exercise toUpdate = exerciseDao.readExercise(exerciseId);
                    if (toUpdate == null) {
                        System.out.println("ćwiczenie o takim id nie istnieje.");
                        break;
                    }
                    System.out.println("Wprowadź nową nazwę zadania: ");
                    String updateTitle = scanner.next();
                    System.out.println("Wprowadź nowy opis: ");
                    String updateDescription = scanner.next();
                    toUpdate.setTitle(updateTitle);
                    toUpdate.setDescription(updateDescription);
                    exerciseDao.updateExercise(toUpdate);
                    break;
                case "delete":
                    System.out.print("Podaj id grupy do usunięcia: ");
                    exerciseId = scanner.nextInt();
                    exerciseDao.deleteExercise(exerciseId);
                    break;
                case "quit":
                default:
                    break;
            }

        } while (!"quit".equalsIgnoreCase(option));
    }
}
