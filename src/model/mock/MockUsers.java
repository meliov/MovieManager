package model.mock;

import model.entity.Admin;
import model.entity.RegisteredUser;
import model.entity.User;
import model.entity.Worker;

import java.util.Arrays;
import java.util.List;

public class MockUsers {
    public static final List<User> MOCK_USERS = Arrays.asList(
            new RegisteredUser("Ivaylo", "Tanev", "tade", "Ivo123123", "ivaylo@gmail.com"),
            new Worker("Ivan", "Manev", "vayne", "Vanko123123", "ivan@gmail.com"),
            new Admin("Jordan", "Jaeger", "ErenAttackTitan", "LeviIsAWarMachine223", "eren@gmail.com")
    );
}
