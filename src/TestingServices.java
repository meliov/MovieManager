import dao.DaoFactory;
import dao.exception.ConstraintViolationException;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.InvalidEntityDataException;
import dao.impl.DaoFactoryImpl;
import model.entity.RegisteredUser;
import model.entity.User;
import service.UserService;
import service.impl.UserServiceIml;
import util.UserValidator;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static model.Role.REGISTERED_USER;

public class TestingServices {
    public static void main(String[] args) {
        var invalidUser = new RegisteredUser("rt", " Eskel","La", "12345", "Eskel@abv.bg");
        DaoFactory daoFactory = new DaoFactoryImpl();
        UserService userService = new UserServiceIml(daoFactory.createUserRepository(), new UserValidator());
        try {
            try {
                userService.create(invalidUser);
            } catch (EntityAlreadyExistsException e) {
                e.printStackTrace();
            }
        } catch (InvalidEntityDataException ex) {
            var sb = new StringBuilder(ex.getMessage());
            if (ex.getCause() instanceof ConstraintViolationException) {
                ex.printStackTrace();
//               sb.append(", invalid fields:\n");
//                var violations = ((ConstraintViolationException) ex.getCause()).getFieldViolations();
//                sb.append(violations.stream().map(v -> String.format(" - %s.%s [%s] - %s",
//                                v.getType().substring(v.getType().lastIndexOf(".") + 1),
//                                v.getField(),
//                                v.getInvalidValue(),
//                                v.getErrorMessage())
//                        ).collect(Collectors.joining("\n"))
//                );
            }
            //System.out.println(sb);
        }
    }
}
