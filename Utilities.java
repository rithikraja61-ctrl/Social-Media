import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilities {
private static Scanner sc=new Scanner(System.in);
public static int login(List<User> users,String username,String password)
{
    if(users.size()==0)
    {
        return -1;
    }
    else{
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) &&
                    users.get(i).getPassword().equals(password)) {
                return i;
            }
        }
    }
    return -1;
}
public static User signUp(List<User>users,String firstname,String lastname,String phoneNumber,String username,String password)
{
    User user = new User();
    user.setFirstname(firstname);
    user.setLastname(lastname);
    user.setPhoneNumber(phoneNumber);
    user.setUsername(username);
    user.setPassword(password);
    users.add(user);
    return user;
}
public static int validIntegerInput(String input)
{

    try{
        int valid=new Integer(input);
        if(valid<=0)
        {
            return -1;
        }
        return valid;

    }
    catch(Exception e){

      return -1;
    }
}
public static int validStringInput(String input)
{
    if(input.equals("exit"))
    {
        return 0;
    }
    else if(input.equals("")||input.charAt(0)==' ')
    {
        return -1;
    }
    else
    {
        return 1;
    }
}
public static boolean usernameAvailable(List<User> users,String userName)
{
    boolean available=true;
    for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(userName)) {
            available = false;
            break;
        }
    }
    if(available) {
        return true;
    } else {
        return  false;
    }
}
}
