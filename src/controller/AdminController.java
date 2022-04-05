package controller;


import dao.exception.EntityAlreadyExistsException;
import model.entity.Admin;
import model.entity.RegisteredUser;
import model.entity.User;
import service.AdminService;
import service.impl.AdminServiceImpl;
import view.Menu;
import view.NewUserDialog;

import java.util.List;

public class AdminController {
    private AdminService adminService;
    private Admin admin;
    public AdminController(AdminService adminService, Admin admin) {
        this.adminService = adminService;
        this.admin = admin;
    }

    public void init() {
        adminService.load();
        var menu = new Menu("Admins Menu", List.of(
                new Menu.Option("Load Users", () -> {
                    System.out.println("Loading users ...");
                    adminService.load();
                    return "Users loaded successfully.";
                }),
                new Menu.Option("Print All Users", () -> {
                    var users = adminService.findAll();
                    users.forEach(System.out::println);
                    return "Total users count: " + users.size();
                }),
                new Menu.Option("Add New User", () -> {
                    var user = new NewUserDialog().input();
                    User created = new RegisteredUser();
                    try {
                        created = adminService.addUser(admin,user);
                    } catch (EntityAlreadyExistsException e) {
                        System.out.println("Error: User already exists.");
                    }
                    return String.format("User ID:%s: '%s' added successfully.",
                            created.getId(), created.getUsername());
                })
        ));
        menu.show();
    }

}
