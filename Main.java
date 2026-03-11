import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User currentUser;
        boolean exit=false;
        while (!exit) {
            System.out.println("Welcome To Social Media");
            System.out.println("1.Login\n2.Sign Up\n3.Exit");
            Scanner sc = new Scanner(System.in);
            String choice=sc.nextLine();
            if(choice.equals("1")) {
                System.out.println("Enter Your UserName :");
                String name = sc.nextLine();
                System.out.println("Enter Your Password :");
                String password = sc.nextLine();
                int index=Utilities.login(userList,name,password);
              if(index==-1)
              {
                  System.out.println("Invalid Credential");
                  continue;
              }
              currentUser=userList.get(index);

            } else if (choice.equals("2")) {
                System.out.println("Enter First Name");
                String firstName=sc.nextLine();
                System.out.println("Enter Last Name");
                String lastName=sc.nextLine();
                System.out.println("Mobile Number");
                String mobileNumber=sc.nextLine();
                String username="";
                boolean valid=false;
                while(!valid)
                {
                    System.out.println("Enter a New Username");
                    username=sc.nextLine();
                    valid=Utilities.usernameAvailable(userList,username);
                    if(!valid)
                    {
                        System.out.println("Username is Taken,Try Again");
                    }

                }
                System.out.println("Enter Your Password");
                String password=sc.nextLine();
                currentUser=Utilities.signUp(userList,firstName,lastName,mobileNumber,username,password);
            }
            else if(choice.equals("3")){
                  System.out.println("Exiting...");
                  exit=true;
                  continue;

            }else {
                System.out.println("InvalidChoice");
                continue;
            }
            String appChoice="";
            while (!appChoice.equals("7")) {
                System.out.println("Welcome" + currentUser.getUsername());
                System.out.println("1.Add New Post");
                System.out.println("2.View My Post");
                System.out.println("3.Update My Post");
                System.out.println("4.Delete My Post");
                System.out.println("5.View My Profile");
                System.out.println("6.Search Profile");
                System.out.println("7.LogOut");
                appChoice = sc.nextLine();
                if (appChoice.equals("1")) {

                    System.out.println("Enter Title Of Post");
                    String title=sc.nextLine();
                    System.out.println("Enter Description Of Post");
                    String description=sc.nextLine();
                    currentUser.post(title,description);

                } else if (appChoice.equals("2")) {
                    if (currentUser.getPost().isEmpty()) {
                        System.out.println("You Does Not Post Yet");
                    } else {
                        currentUser.viewPost();
                    }
                }else if (appChoice.equals("3")) {
                    if (currentUser.getPost().isEmpty()) {
                        System.out.println("You Does Not Post Yet");
                    } else {
                        boolean valid = false;
                        int ch = 0;
                        while (!valid) {
                            System.out.println("Select Post :");
                            currentUser.viewPostTitle();
                            ch = Utilities.validIntegerInput(sc.nextLine());
                            if (ch == -1) {
                                System.out.println("Invalid Input Try Again");
                                continue;
                            }
                            else if(!currentUser.validPost(ch))
                            {
                                System.out.println("Invalid Input Try Again");
                                continue;
                            }
                            valid=true;
                        }
                        valid = false;
                        while (!valid) {
                            System.out.println("1. Update Title Of Post");
                            System.out.println("2. Update Description Of Post");
                            String updateChoice = sc.nextLine();
                            if (updateChoice.equals("1")) {
                                System.out.println("Enter New Title");
                                String title = sc.nextLine();
                                currentUser.updateTitle(ch - 1, title);
                                System.out.println("Updated Successfully");

                            } else if (updateChoice.equals("2")) {
                                System.out.println("Enter New Description");
                                String description = sc.nextLine();
                                currentUser.updateDescription(ch - 1, description);
                                System.out.println("Updated Successfully");
                            }
                            else{
                                System.out.println("Invalid Input Try Again!");
                                continue;
                            }
                            valid=true;


                        }
                    }
                } else if (appChoice.equals("4")) {
                    if (currentUser.getPost().isEmpty()) {
                        System.out.println("You Does Not Post Yet");
                    } else {
                        boolean valid = false;
                        while (!valid) {
                            System.out.println("Select Post :");
                            currentUser.viewPostTitle();
                            int ch = Utilities.validIntegerInput(sc.nextLine());
                            if (ch == -1) {
                                System.out.println("Invalid Input,Try Again!");
                                continue;
                            }
                            currentUser.deletePost(ch - 1);
                            System.out.println("Removed Successfully");
                            valid = true;
                        }
                    }
                }
                else if(appChoice.equals("5"))
                {
                  System.out.println("My Profile");
                  System.out.println("UserName:"+currentUser.getUsername());
                  System.out.println("Total Number Of Post:"+currentUser.getPost().size());
                  System.out.println("Followers :"+currentUser.getFollower().size()+" "+"Following :"+currentUser.getFollowing().size());
                }
                else if(appChoice.equals("6")) {
                    boolean valid=false;
                    List<UserContract> filter = new ArrayList<>();
                    while(!valid) {
                        System.out.println("Enter Profile Name:");
                        String s = sc.nextLine();
                        for (int i = 0; i < userList.size(); i++) {
                            if (userList.get(i).getUsername().contains(s)) {
                                filter.add(userList.get(i));
                            }
                        }
                        if(filter.isEmpty())
                        {
                            System.out.println("No Profile Found");
                            System.out.println("Search Again  Enter ,Go To Main Menu Type 'exit' ");
                            String stop=sc.nextLine();
                            if(!stop.equals("exit"))
                            {
                                continue;
                            }
                        }
                        valid=true;
                    }
                    if(!filter.isEmpty()) {

                        for (int i = 0; i < filter.size(); i++) {
                            System.out.println(i + 1 + "] " + filter.get(i).getUsername());
                        }
                        valid=false;
                        int temp=0;
                        while(!valid) {
                            System.out.println("Select Profile");
                             temp = Utilities.validIntegerInput(sc.nextLine());
                             if(temp==-1)
                             {
                                 System.out.println("Invalid Input,Try Again!");
                                 continue;
                             }
                             else if(temp>filter.size())
                             {
                                 System.out.println("Invalid Input,Try Again!");
                                 continue;
                             }
                             valid=true;
                        }
                        UserContract selectedUser = filter.get(temp - 1);
                        boolean stop = false;
                        while (!stop) {
                            boolean isFollowing = false;
                            for (int i = 0; i < currentUser.getFollowing().size(); i++) {
                                if (currentUser.getFollowing().contains(selectedUser)) {
                                    isFollowing = true;
                                    break;
                                }
                            }
                            System.out.println("UserName:" + selectedUser.getUsername());
                            if (isFollowing) {
                                System.out.println("Your Currently Following");
                            } else {
                                System.out.println("Your Not Currently Following");
                            }
                            System.out.println("Total Number Of Post");
                            System.out.println(selectedUser.getPost().size());
                            System.out.println("Followers :" + selectedUser.getFollower().size());
                            System.out.println("Following :" + selectedUser.getFollowing().size());
                            if (isFollowing) {
                                System.out.println("1]Unfollow");
                            } else {
                                System.out.println("1]Follow");
                            }
                            System.out.println("2]View Post ");
                            System.out.println("3] exit");
                            String ch = sc.nextLine();
                            if (ch.equals("1")) {
                                if (isFollowing) {
                                    currentUser.getFollowing().remove(selectedUser);
                                    selectedUser.getFollower().remove(selectedUser);
                                    System.out.println("Unfollow Successfully");
                                } else {
                                    currentUser.getFollowing().add(selectedUser);
                                    selectedUser.getFollower().add(selectedUser);
                                    System.out.println("Follow Successfully");
                                }
                            } else if (ch.equals("2")) {
                                if (selectedUser.getPost().isEmpty()) {
                                    System.out.println("No Post Available");
                                    continue;
                                }
                                selectedUser.viewPost();
                            } else if (ch.equals("3")) {
                                stop = true;
                            } else {
                                System.out.println("Invalid Choice");
                            }


                        }
                    }
                }

                else if(appChoice.equals("7"))
                {
                    System.out.println("Logout....");
                }
                else{
                    System.out.println("Invalid Choice!");
                }

            }
        }
    }
}
