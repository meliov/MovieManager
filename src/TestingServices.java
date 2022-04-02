import dao.DaoFactory;
import dao.exception.ConstraintViolationException;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.InvalidEntityDataException;
import dao.exception.NonExistingEntityException;
import dao.impl.DaoFactoryImpl;
import model.entity.RegisteredUser;
import model.entity.User;
import service.UserService;
import service.impl.UserServiceIml;
import util.UserValidator;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import static model.Role.REGISTERED_USER;
import static model.mock.MockMovies.MOCK_MOVIES;
import static model.mock.MockUsers.MOCK_USERS;

public class TestingServices {
    public static void main(String[] args) {
        var invalidUser = new RegisteredUser("rtasd", " Eskel","Lambert", "123458", "Eskel@abv.bg");
        DaoFactory daoFactory = new DaoFactoryImpl();
        UserService userService = new UserServiceIml(daoFactory.createUserRepository("users.db"), new UserValidator());

//                try {
//            try {
//                userService.create(invalidUser);
//            } catch (EntityAlreadyExistsException e) {
//                e.printStackTrace();
//            }
//        } catch (InvalidEntityDataException ex) {
//            var sb = new StringBuilder(ex.getMessage());
//            if (ex.getCause() instanceof ConstraintViolationException) {
//                ex.printStackTrace();
//               sb.append(", invalid fields:\n");
//                var violations = ((ConstraintViolationException) ex.getCause()).getFieldViolations();
//                sb.append(violations.stream().map(v -> String.format(" - %s.%s [%s] - %s",
//                                v.getType().substring(v.getType().lastIndexOf(".") + 1),
//                                v.getField(),
//                                v.getInvalidValue(),
//                                v.getErrorMessage())
//                        ).collect(Collectors.joining("\n"))
//                );
//            }
//            System.out.println(sb);
//        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("TESTING PERSISTABLE REPO");
        System.out.println();

        var existingUsernameUser = new RegisteredUser("rtasd", " Eskel","tade", "123458", "Eskel@abv.bg");

//        userService.load();
//        try {
//                userService.create(invalidUser);
//            } catch (EntityAlreadyExistsException | InvalidEntityDataException e) {
//                e.printStackTrace();
//            }

                userService.load();
        try {
                userService.create(existingUsernameUser);
            } catch (EntityAlreadyExistsException | InvalidEntityDataException e) {
                e.printStackTrace();
            }


//        try {
//            userService.deleteById(6);
//        } catch (NonExistingEntityException e) {
//            e.printStackTrace();
//        }
        userService.load();// metod v admin survisa da maha ili dobavq filmi v samiq user / sushto zaduljitelna validaciq predi repotata v adminService
       userService.findAll().forEach(System.out::println);

//        System.out.println("Movies");
//        var movies
//                = new LinkedHashSet<>(MOCK_MOVIES);
//        movies.forEach(System.out::println); //sichki id-ta sa null i gi smeta za 1 i sushto tui kato tva e set, sichko se opravq pri chetene ne ot mock a veche ot faila
    }
}
