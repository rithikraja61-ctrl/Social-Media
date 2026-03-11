import java.util.List;

public interface UserContract {
    public List<Post> getPost();
    public List<UserContract> getFollower();
    public List<UserContract> getFollowing();
    public String getUsername();
    public void viewPost();
}
