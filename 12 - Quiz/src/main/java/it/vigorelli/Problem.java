package it.vigorelli;

import java.io.Serializable;

public class Problem implements Serializable {
    private String question;
    private String answer;

    public Problem(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect(String response)   {
        return response.trim().equalsIgnoreCase(answer);
    }
}
