package cn.itcast.domain;


public class User {
    private String username;
    private String password;
    private Integer id;

    public User() {
        //System.out.println("构造成成功了！");
    }

    public User(String username, String password, Integer id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
