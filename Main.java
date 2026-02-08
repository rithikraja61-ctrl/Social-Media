import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main() {
        List<User> userList = new ArrayList();
        User currentUser = null;
        while (true) {
            System.out.println("Welcome To Social Media");
            System.out.println("1.Login\n 2.Sign Up");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Enter Your UserName :");
                String name = sc.nextLine();
                System.out.println("Enter Your Password");
                String password = sc.nextLine();
                boolean valid = false;
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getUsername().equals(name) &&
                            userList.get(i).getPassword().equals(password)) {
                        valid = true;
                        currentUser = userList.get(i);
                    }
                }
                if (!valid) {
                    System.out.println("Invalid User Name");
                    continue;
                }

            } else if (choice == 2) {
                User user = new User();
                System.out.println("Enter Your First Name");
                user.setFirstname(sc.nextLine());
                System.out.println("Enter Your Last Name");
                user.setLastname(sc.nextLine());
                System.out.println("Enter Mobile Number");
                user.setPhonenumber(sc.nextLine());
                boolean validUserName = false;
                while (!validUserName) {
                    boolean available = true;
                    System.out.println("Enter New User Name");
                    String userName = sc.nextLine();
                    for (int i = 0; i < userList.size(); i++) {
                        if (userList.get(i).getUsername().equals(userName)) {
                            available = false;
                            break;
                        }
                    }
                    if (available) {
                        user.setUsername(userName);
                        validUserName = true;
                    } else {
                        System.out.println("UserName Already Taken");
                    }
                }
                System.out.println("Enter Your Password");
                user.setPassword(sc.nextLine());
                userList.add(user);
                currentUser = user;
            } else {
                System.out.println("InvalidChoice");
                continue;
            }
            int appChoice = 0;
            while (appChoice != 5) {
                System.out.println("Welcome" + currentUser.getUsername());
                System.out.println("1.Add New Post");
                System.out.println("2.View My Post");
                System.out.println("3.Update My Post");
                System.out.println("4.Delete My Post");
                System.out.println("5.LogOut");
                appChoice = sc.nextInt();
                sc.nextLine();
                if (appChoice == 1) {
                    Post post = new Post();
                    System.out.println("Enter Title Of Post");
                    post.setTitle(sc.nextLine());
                    System.out.println("Enter Description Of Post");
                    post.setDescription(sc.nextLine());
                    currentUser.getPost().add(post);

                } else if (appChoice == 2) {
                    if (currentUser.getPost().isEmpty()) {
                        System.out.println("You Does Not Post Yet");
                    } else {
                        for (int i = 0; i < currentUser.getPost().size(); i++) {
                            System.out.println(i + 1 + "]Post Title :");
                            System.out.println(currentUser.getPost().get(i).getTitle());
                            System.out.println("Post Description :");
                            System.out.println(currentUser.getPost().get(i).getDescription());
                        }
                    }
                }else if (appChoice == 3) {
                    if (currentUser.getPost().isEmpty()) {
                        System.out.println("You Does Not Post Yet");
                    } else {
                        System.out.println("Select Post :");
                        for (int i = 0; i < currentUser.getPost().size(); i++) {
                            System.out.println(i + 1 + ":" + currentUser.getPost().get(i).getTitle());
                        }
                        int ch = sc.nextInt();
                        sc.nextLine();
                        System.out.println("1. Update Title Of Post");
                        System.out.println("2. Update Description Of Post");
                        int updateChoice = sc.nextInt();
                        sc.nextLine();
                        if (updateChoice == 1) {
                            System.out.println("Enter New Title");
                            currentUser.getPost().get(ch-1).setTitle(sc.nextLine());
                            System.out.println("Updated Successfully");

                        } else if (updateChoice == 2) {
                            System.out.println("Enter New Description");
                            currentUser.getPost().get(ch-1).setDescription(sc.nextLine());
                            System.out.println("Updated Successfully");
                        }
                    }
                } else if (appChoice == 4) {
                    if (currentUser.getPost().isEmpty()) {
                        System.out.println("You Does Not Post Yet");
                    } else {
                        System.out.println("Select Post :");
                        for (int i = 0; i < currentUser.getPost().size(); i++) {
                            System.out.println(i + 1 + ":" + currentUser.getPost().get(i).getTitle());
                        }
                        int ch = sc.nextInt();
                        sc.nextLine();
                        currentUser.getPost().remove(ch-1);
                        System.out.println("Removed Successfully");
                    }
                }
                else if(appChoice==5)
                {
                    System.out.println("Logout....");
                }
            }
        }
    }
}
