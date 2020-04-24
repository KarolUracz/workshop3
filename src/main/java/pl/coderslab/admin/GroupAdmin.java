package pl.coderslab.admin;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

import java.util.Scanner;

public class GroupAdmin {
    public static void main(String[] args) {
        GroupDao groupDao = new GroupDao();
        String option = null;
        do {
            Group[] allGroups = groupDao.findAllGroups();
            for (Group group : allGroups) {
                System.out.println(group);
            }
            System.out.print("Wybierz jedną z opcji: ");
            System.out.println("add");
            System.out.println("edit");
            System.out.println("delete");
            System.out.println("quit");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextLine()) {
                System.out.print("Wprowadź poprawną opcję: ");
                scanner.nextLine();
            }
            option = scanner.nextLine();
            switch (option) {
                case "add":
                    Group group = new Group();
                    System.out.print("Wprowadź nazwę nowej grupy: ");
                    String name = scanner.nextLine();
                    group.setName(name);
                    groupDao.create(group);
                    break;
                case "edit":
                    System.out.print("Podaj id grupy do edycji: ");
                    int groupId = scanner.nextInt();
                    Group toUpdate = groupDao.readGroup(groupId);
                    if (toUpdate==null) {
                        System.out.println("Grupa o takim id nie istnieje.");
                        break;
                    }
                    System.out.print("Wprowadź nową nazwę: ");
                    String newName = scanner.next();
                    toUpdate.setName(newName);
                    groupDao.updateGroup(toUpdate);
                    break;
                case "delete":
                    System.out.print("Podaj id grupy do usunięcia: ");
                    groupId = scanner.nextInt();
                    groupDao.deleteGroup(groupId);
                    break;
                case "quit":
                default:
                    break;
            }
        } while (!"quit".equals(option));
    }
}

