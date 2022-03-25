import dao.DaoFactory;
import dao.UserRepository;
import dao.exception.EntityAlreadyExistsException;
import dao.impl.DaoFactoryImpl;
import model.User;
import model.mock.MockUsers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

import static model.mock.MockUsers.MOCK_USERS;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("Hello world!");
////        Path path = Paths.get("data/fp_wiki.txt");
////        var lines = Files.lines(path, Charset.forName("utf-8"));
////        DaoFactory daoFactory = new DaoFactoryImpl();
////        UserRepository registeredUserRepository = daoFactory.createRegisteredUserRepository();
////        var usersStream = lines.map(line -> Arrays.stream(line.split("\\s+")))
////                .collect(Collectors.toList());

        DaoFactory daoFactory = new DaoFactoryImpl();
        UserRepository userRepository = daoFactory.createRegisteredUserRepository();
        for(User u: MOCK_USERS){
            try {
                userRepository.create(u,"user");
            } catch (EntityAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        for(User u: userRepository.findAll()){
            System.out.println(u);
        }
    }
}
