package pl.coderslab.admin;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import java.util.Scanner;

public class UserAdmin {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        String option = null;
        do {
            User[] allUsers = userDao.findAllUsers();
            for (User user : allUsers) {
                System.out.println(user);
            }
            System.out.println("Wybierz jedną z opcji: add, edit, delete, quit");
            System.out.print("Select: ");

            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextLine()) {
                System.out.print("Wprowadź poprawną opcję: ");
                scanner.nextLine();
            }
            option = scanner.nextLine();
            switch (option) {
                case "add":
                    User user = new User();
                    System.out.println("Wprowadź nową nazwę: ");
                    String newName = scanner.next();
                    System.out.println("Wprowadź nowy email: ");
                    String newMail = scanner.next();
                    System.out.println("Wprowadź nowe hasło: ");
                    String newPassword = scanner.next();
                    System.out.println("Wprowadź nowe id grupy: ");
                    int newGroupId = scanner.nextInt();
                    user.setUsername(newName);
                    user.setEmail(newMail);
                    user.setPassword(newPassword);
                    user.setGroup_id(newGroupId);
                    userDao.createUser(user);
                    break;
                case "edit":
                    System.out.print("Podaj id użytkownika do edycji: ");
                    int userId = scanner.nextInt();
                    User toUpdate = userDao.readUser(userId);
                    if (toUpdate == null) {
                        System.out.println("Użytkownik o takim id nie istnieje.");
                        break;
                    }
                    System.out.println("Wprowadź nową nazwę: ");
                    String updateName = scanner.next();
                    System.out.println("Wprowadź nowy email: ");
                    String updateMail = scanner.next();
                    System.out.println("Wprowadź nowe hasło: ");
                    String updatePassword = scanner.next();
                    System.out.println("Wprowadź nowe id grupy: ");
                    int updateGroupId = scanner.nextInt();
                    toUpdate.setUsername(updateName);
                    toUpdate.setEmail(updateMail);
                    toUpdate.setPassword(updatePassword);
                    toUpdate.setGroup_id(updateGroupId);
                    userDao.updateUser(toUpdate);
                    break;
                case "delete":
                    System.out.print("Podaj id grupy do usunięcia: ");
                    userId = scanner.nextInt();
                    userDao.deleteUser(userId);
                    break;
                case "quit":
                default:
                    break;
            }
        } while (!"quit".equals(option));
    }
}
