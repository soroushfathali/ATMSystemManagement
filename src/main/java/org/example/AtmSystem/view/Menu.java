package view;

import controller.AuthController;
import controller.CourseController;
import controller.UserController;
import model.dtos.CourseDto;
import model.dtos.UserDto;
import model.entity.Role;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);

    private static final UserController userController = new UserController();

    private static final AuthController authController = new AuthController();
    private static final CourseController courseController = new CourseController();

    public static void MainMenu() {
        aa:
        while (true) {
            System.out.println("""
                    hello mate!
                    for login type 1
                    for forgot password type 2
                    for exit type exit
                    """);
            String inp = sc.next();
            switch (inp) {
                case "1":
                    Role role = login();
                    if (role != null) {
                        switch (role) {
                            case ADMIN -> adminMenu();
                            case STUDENT -> stuMenu();
                            case EMPLOYEE -> EmpMenu();
                        }
                    }
                    break;
                case "2":
                    forgotPass();
                    break;
                case "exit":
                    System.out.println("""
                            goodbye,
                            see u soon!
                            """);
                    break aa;
                default:
                    System.out.println("""
                            ridi mes adam data bede!
                            """);
            }
        }
    }

    private static void EmpMenu() {
        aa:
        while (true) {
            System.out.println("""
                     hello sir.
                     for add course inp 1
                     for udpate course inp 2
                     for delete course inp 3
                     for list course inp 4
                     for exit inp exit
                    """);
            String inp = sc.next();
            switch (inp) {
                case "1" -> addCourse();
                case "2" -> udpateCourse();
                case "3" -> deleteCourse();
                case "4" -> courseController.findAll().forEach(System.out::println);
                case "exit" -> {
                    System.out.println("bye bye");
                    break aa;
                }
                default -> System.out.println("dorost bezan");
            }
        }
    }

    private static void deleteCourse() {
        System.out.println("""
                input id
                """);
        long id = sc.nextLong();
        courseController.delete(id);
    }

    private static void udpateCourse() {
        System.out.println("""
                input like sample
                id,name,unit,teacher,semester
                """);
        String[] inputs = sc.next().split(",");
        CourseDto courseDto = new CourseDto();
        courseDto.setId(Long.parseLong(inputs[0]));
        courseDto.setName(inputs[1]);
        courseDto.setUnit(Integer.parseInt(inputs[2]));
        courseDto.setTeacher(Long.parseLong(inputs[3]));
        courseDto.setSemester(Integer.parseInt(inputs[4]));
        courseController.save(courseDto);
    }

    private static void addCourse() {
        System.out.println("""
                input like sample
                name,unit,teacher,semester
                """);
        String[] inputs = sc.next().split(",");
        CourseDto courseDto = new CourseDto();
        courseDto.setName(inputs[0]);
        courseDto.setUnit(Integer.parseInt(inputs[1]));
        courseDto.setTeacher(Long.parseLong(inputs[2]));
        courseDto.setSemester(Integer.parseInt(inputs[3]));
        courseController.save(courseDto);
    }

    private static void stuMenu() {
    }

    private static void adminMenu() {
        aa:
        while (true) {
            System.out.println("""
                    hello sir!
                    for register new user input 1
                    for update user input 2
                    for remove user input 3
                    for showSingle user input 4
                    for showAll user input 5
                    for exit new user input exit
                    """);
            String inp = sc.next();
            switch (inp) {
                case "1" -> register();
                case "2" -> update();
                case "3" -> {
                    userController.findAll().forEach(System.out::println);
                    System.out.println("""
                            ---------------------
                            enter user id from above list
                            """);
                    long id = sc.nextLong();
                    userController.delete(id);
                }
                case "4" -> {
                    userController.findAll().forEach(System.out::println);
                    System.out.println("""
                            ---------------------
                            enter user id from above list
                            """);
                    long id = sc.nextLong();
                    UserDto userDto = userController.findById(id);
                    System.out.println(userDto);
                }
                case "5" -> userController.findAll().forEach(System.out::println);
                case "exit" -> {
                    System.out.println("""
                            good bye admin!
                            """);
                    break aa;
                }
                default -> System.out.println("""
                        ridi mes adam data bede!
                        """);
            }
        }
    }

    private static void register() {
        System.out.println("""
                add new data like sample
                nationalCode,firstname,lastname,username,password,role
                """);
        String[] input = sc.next().split(",");
        UserDto dto = new UserDto();
        dto.setNationalCode(input[0]);
        dto.setFirstname(input[1]);
        dto.setLastname(input[2]);
        dto.setUsername(input[3]);
        dto.setPassword(input[4]);
        dto.setRole(Role.valueOf(input[5]));
        authController.register(dto);
    }

    private static void update() {
        userController.findAll().forEach(System.out::println);
        System.out.println("""
                add new data like sample
                id,nationalCode,firstname,lastname,username,password,role
                """);
        String[] input = sc.next().split(",");
        UserDto dto = new UserDto();
        dto.setId(Long.parseLong(input[0]));
        dto.setNationalCode(input[1]);
        dto.setFirstname(input[2]);
        dto.setLastname(input[3]);
        dto.setUsername(input[4]);
        dto.setPassword(input[5]);
        dto.setRole(Role.valueOf(input[6]));
        userController.update(dto);
    }

    private static Role login() {
        System.out.println("""
                input data like sample
                username,password
                """);
        String[] input = sc.next().split(",");
        return authController.login(input[0], input[1]);
    }

    private static void forgotPass() {
        System.out.println("""
                input data like sample
                username,nationalCode,newPass
                """);
        String[] input = sc.next().split(",");
        authController.forgotPass(input[0], input[1], input[2]);
    }
}
