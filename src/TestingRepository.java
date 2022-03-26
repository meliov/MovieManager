import dao.DaoFactory;
import dao.exception.NonExistingEntityException;
import dao.repository.MovieRepository;
import dao.repository.ProgramRepository;
import dao.repository.ReviewRepository;
import dao.repository.UserRepository;
import dao.exception.EntityAlreadyExistsException;
import dao.impl.DaoFactoryImpl;
import model.DayOfWeek;
import model.entity.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;

import static model.DayOfWeek.TUESDAY;
import static model.Genre.FANTASY;
import static model.mock.MockMovies.MOCK_MOVIES;
import static model.mock.MockProgram.MOCK_PROGRAM;
import static model.mock.MockReviews.MOCK_REVIEWS;
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
        for(Movie m: movieRepository.findAllSorted(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getReleaseDate().compareTo(o2.getReleaseDate());
            }
        })){
            System.out.println(m);
        }
        System.out.println("Movies sorted by price: ");
        for(Movie m: movieRepository.findAllSorted(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Double.compare(o1.getPrice(),o2.getPrice());

            }
        })){
            System.out.println(m);
        }

        //reviews
        System.out.println();
        System.out.println();
        System.out.println("Review\tReview\tReview\tReview\tReview");
        System.out.println();

        ReviewRepository reviewRepository = daoFactory.createReviewRepository();
        for(Review r : MOCK_REVIEWS){
            try {
                reviewRepository.create(r);
            } catch (EntityAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Reviews");
        for(Review r: reviewRepository.findAll()){
            System.out.println(r);
        }
        System.out.println("Find all REviews by user");
        try {
            for(Review r: reviewRepository.findByUser(new RegisteredUser(1L))){
                System.out.println(r);
            }
        } catch (NonExistingEntityException e) {
            e.printStackTrace();
        }
        System.out.println("Find all REviews by movie");
        try {
            for(Review r: reviewRepository.findByMovie(new Movie(2L))){
                System.out.println(r);
            }
        } catch (NonExistingEntityException e) {
            e.printStackTrace();
        }
        System.out.println("Find all REviews by date");
        try {
            for(Review r: reviewRepository.findByDate(LocalDate.now())){
                System.out.println(r);
            }
        } catch (NonExistingEntityException e) {
            e.printStackTrace();
        }
        //daily program
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Daily program");
        System.out.println();
        ProgramRepository programRepository = daoFactory.createProgramRepository();

        for(DailyProgram d: MOCK_PROGRAM){
            try {
                programRepository.create(d);
            } catch (EntityAlreadyExistsException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Printing program for al days");

        for(DailyProgram d: programRepository.findAll()){
            System.out.printf("%s-%n", d.getDayOfWeek());
            d.getProjections().forEach(m -> m.forEach((k,v) -> System.out.printf(" %s - %s\n", k, v.getMovieName())));
        }
        System.out.println("Printing program for Tuesday");
        System.out.println();
        try {
            programRepository.findByDayOfWeek(TUESDAY).getProjections().forEach(m -> m.forEach((k,v) -> System.out.printf(" %s - %s\n", k, v.getMovieName())));
        } catch (NonExistingEntityException e) {
            e.printStackTrace();
        }

    }
}
