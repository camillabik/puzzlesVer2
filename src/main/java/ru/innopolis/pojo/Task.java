package ru.innopolis.pojo;


public class Task {
   private int id;
   private User user;
   private Question question;
   private Answer answer;
   private boolean isRight;

    public Task(int id, User user, Question question, Answer answer, boolean isRight) {
        this.id = id;
        this.user = user;
        this.question = question;
        this.answer = answer;
        this.isRight = isRight;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
