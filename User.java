import java.util.ArrayList;
import java.util.List;

public class User implements UserContract{
   private String username;
   private String password;
   private String firstname;
   private String lastname;
   private String phoneNumber;
   private List<UserContract> follower=new ArrayList<>();
   private List<UserContract> following=new ArrayList<>();
   private List<Post> post=new ArrayList<>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Post> getPost() {
        return post;
    }


    public List<UserContract> getFollower() {
        return follower;
    }

    public void setFollower(List<UserContract> follower) {
        this.follower = follower;
    }

    public List<UserContract> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserContract> following) {
        this.following = following;
    }
    public void post(String title,String description)
    {
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);
        this.getPost().add(post);
    }
    public void viewPost()
    {
        for (int i = 0; i < this.getPost().size(); i++) {
            System.out.println(i + 1 + "]Post Title :");
            System.out.println(this.getPost().get(i).getTitle());
            System.out.println("Post Description :");
            System.out.println(this.getPost().get(i).getDescription());
        }
    }
    public void viewPostTitle()
    {
        for (int i = 0; i < this.getPost().size(); i++) {
            System.out.println(i + 1 + ":" + this.getPost().get(i).getTitle());
        }
    }
    public void updateTitle(int index,String title)
    {
        this.getPost().get(index).setTitle(title);
    }
    public void updateDescription(int index,String description)
    {
        this.getPost().get(index).setDescription(description);
    }
    public void deletePost(int index)
    {
        this.getPost().remove(index);
    }
    public boolean validPost(int index)
    {
        if(index<0||index>this.getPost().size())
        {
            return false;
        }
        return true;
    }
}
