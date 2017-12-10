package ru.innopolis.pojo;


public class Test {
    private int id;
    private User user;
    private Test test;

    public Test(int id, User user, Test test) {
        this.id = id;
        this.user = user;
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
