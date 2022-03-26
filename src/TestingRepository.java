import dao.DaoFactory;
import dao.exception.NonExistingEntityException;
import dao.repository.MovieRepository;
import dao.repository.UserRepository;
import dao.exception.EntityAlreadyExistsException;
import dao.impl.DaoFactoryImpl;
import model.entity.Movie;
import model.entity.User;

import java.io.IOException;

import static model.Genre.FANTASY;
import static model.mock.MockMovies.MOCK_MOVIES;
import static model.mock.MockUsers.MOCK_USERS;

public class TestingRepository {
    public static void main(String[] args) throws IOException {
//        System.out.println("Hello world!");
////        Path path = Paths.get("data/fp_wiki.txt");
////        var lines = Files.lines(path, Charset.forName("utf-8"));
////        DaoFactory daoFactory = new DaoFactoryImpl();
////        UserRepository registeredUserRepository = daoFactory.createRegisteredUserRepository();
////        var usersStream = lines.map(line -> Arrays.stream(line.split("\\s+")))
////                .collect(Collectors.toList());

        //user repo
        DaoFactory daoFactory = new DaoFactoryImpl();
        UserRepository userRepository = daoFactory.createUserRepository();
        for(User u: MOCK_USERS){
            try {
                userRepository.create(u);
            } catch (EntityAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        for(User u: userRepository.findAll()){
            System.out.println(u);
        }
        try {
            System.out.printf("%n User with username tade is: %s", userRepository.findByUsername("tade"));
        } catch (NonExistingEntityException e) {
            e.printStackTrace();
        }
        try {
            System.out.printf("%n User with email ivan@gmail.com is: %s", userRepository.findByEmail("eren@gmail.com"));
        } catch (NonExistingEntityException e) {
            e.printStackTrace();
        }
        //movies repo
        System.out.println();
        System.out.println("Movies\tMovies\tMovies\tMovies\tMovies");
        System.out.println();
        MovieRepository movieRepository = daoFactory.createMovieRepository();
        for(Movie m : MOCK_MOVIES){
            try {
                movieRepository.create(m);
            } catch (EntityAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.printf("Movie with name Batman: " + movieRepository.findByMovieName("Batman"));
        } catch (NonExistingEntityException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Movies with price 8:");
        try {
            for(Movie m: movieRepository.findByPrice(8)){
                System.out.println(m);
            }
        } catch (NonExistingEntityException e) {
            e.printStackTrace();
        }
        System.out.println("Movies with genre FANTASY: ");
        try {
            for(Movie m: movieRepository.findByGenre(FANTASY )){
                System.out.println(m);
            }
        } catch (NonExistingEntityException e) {
            e.printStackTrace();
        }
        System.out.println("Movies sorted by release date: ");
        for(Movie m: movieRepository.sortByReleaseDate()){
            System.out.println(m);
        }
        System.out.println("Movies sorted by price: ");
        for(Movie m: movieRepository.sortByPrice()){
            System.out.println(m);
        }
    }
}
