package view;



import dao.DaoFactory;
import dao.exception.NonExistingEntityException;
import dao.impl.DaoFactoryImpl;
import dao.repository.UserRepository;
import model.entity.RegisteredUser;
import model.entity.User;
import util.Regex;

import java.time.LocalDate;
import java.util.Scanner;

public class NewUserDialog implements EntityDialog<User> {
    public static Scanner sc = new Scanner(System.in);

    @Override
    public RegisteredUser input() {
        DaoFactory daoFactory = new DaoFactoryImpl();
        UserRepository userRepository = daoFactory.createUserRepository("users.db");
        var user = new RegisteredUser();
        while (user.getUsername() == null) {
            System.out.println("Username:");
            var ans = sc.nextLine();
            if (Regex.regexValidation(ans, Regex.USER_NAMES_REGEX)) {
                System.out.println("Error: The username should be between 3 and 15 characters long.");
            }else if (userRepository.containsUsername(ans)){
                System.out.println("Error: username already exists.");
            }
            else {
                user.setUsername(ans);
            }
        }
        while (user.getFirstName() == null) {
            System.out.println("First Name:");
            var ans = sc.nextLine();
            if (Regex.regexValidation(ans, Regex.USER_FIRST_LAST_NAME_REGEX)) {
                System.out.println("Error: First name should be between 3 and 15 characters long.");
            } else {
                user.setFirstName(ans);
            }
        }
        while (user.getLastName() == null) {
            System.out.println("Last Name:");
            var ans = sc.nextLine();
            if (Regex.regexValidation(ans, Regex.USER_FIRST_LAST_NAME_REGEX)) {
                System.out.println("Error: Last name should be between 3 and 15 characters long.");
            } else {
                user.setLastName(ans);
            }
        }
        while (user.getPassword() == null) {
            System.out.println("Password(5 - 15 symbols):");
            var ans = sc.nextLine();
            if (Regex.regexValidation(ans, Regex.USER_PASS_REGEX)) {
                System.out.println("Error: Password should be between 5 and 15 characters long.");
            } else {
                user.setPassword(ans);
            }
        }
        while (user.getEmail() == null) {
            System.out.println("E-mail:");
            var ans = sc.nextLine();
            if (Regex.regexValidation(ans, Regex.USER_EMAIL_REGEX)) {
                System.out.println("Error: Email is not valid.");
            } else {
                user.setEmail(ans);
            }
        }
        return user;
    }
}
