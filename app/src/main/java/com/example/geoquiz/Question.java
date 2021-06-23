package com.example.geoquiz;

public class Question {
    //ATTRIBUTES
    private int question;
    private boolean answer;

    //CONSTRUCTOR
    public Question(int question, boolean answer){
        this.question = question;
        this.answer = answer;
    }

    //SETTERS & GETTERS
    public void setQuestion(int question){
        this.question = question;
    }

    public int getQuestion(){
        return question;
    }

    public void setAnswer(boolean answer){
        this.answer = answer;
    }

    public boolean getAnswer(){
        return answer;
    }
}
