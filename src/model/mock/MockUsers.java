package model.mock;

import model.entity.Admin;
import model.entity.Movie;
import model.entity.RegisteredUser;
import model.entity.User;

import java.util.*;

import static model.mock.MockMovies.MOCK_MOVIES;

public class MockUsers {
    private static  Set<Movie> movies = new HashSet<>(MOCK_MOVIES);
    public static final List<User> MOCK_USERS = Arrays.asList(
            new RegisteredUser("Ivaylo", "Tanev", "tade", "Ivo123123", "ivaylo@gmail.com"),
            new RegisteredUser("Ivan", "Manev", "vayne", "Vanko123123", "ivan@gmail.com"),
            new Admin("Jordan", "Jaeger", "ErenAttackTitan", "LeviIsAWarMachine223", "eren@gmail.com"),
            new RegisteredUser("Bojin", "Bojanov", "bojo", "Bo123123", "bojo1@gmail.com"),
            new RegisteredUser("Bingo", "Jaeger", "BingoTitan", "LeviIsAWarMachine223", "bingo@gmail.com",movies )
    );
}
