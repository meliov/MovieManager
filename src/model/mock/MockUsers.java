package model.mock;

import model.Admin;
import model.RegisteredUser;
import model.User;
import model.Worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockUsers {
    public static final List<User> MOCK_USERS = Arrays.asList(
            new RegisteredUser("Ivaylo", "Tanev", "tade", "Ivo123123", "ivaylo@gmail.com"),
            new Worker("Ivan", "Manev", "vayne", "Vanko123123", "ivan@gmail.com"),
            new Admin("Jordan", "Jaeger", "ErenAttackTitan", "LeviIsAWarMachine223", "eren@gmail.com")
    );
}
