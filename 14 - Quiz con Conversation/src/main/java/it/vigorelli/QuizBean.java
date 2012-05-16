package it.vigorelli;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Named
@ConversationScoped
public class QuizBean implements Serializable {
    private int currentProblem;
    private int tries;
    private int score;
    private String response = "";
    private String correctAnswer;
    @Inject Conversation conversation;
    @Inject WorkspaceBean workspaceBean;

    @PostConstruct
    public void postConstruct() {
        conversation.begin();
        workspaceBean.getConversations().add(conversation.getId());
    }

    public Conversation getConversation() {
        return conversation;
    }

    private List<Problem> problems =
            new ArrayList<Problem>(Arrays.asList(
                    new Problem("which Java keyword is used to define a subclass?", "extends"),
                    new Problem("which java.util class describes a point in time?", "Date"),
                    new Problem("What was the original name of the Java Programming Language?", "Oak")

            ));

    public String getQuestion() {
        return problems.get(currentProblem).getQuestion();
    }

    public String getAnswer() {
        return correctAnswer;
    }

    public int getScore() {
        return score;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String answerAction() {
        tries++;
        if (problems.get(currentProblem).isCorrect(response)) {
            score++;
            nextProblem();
            if (currentProblem == problems.size()) {
                conversation.end();
                workspaceBean.getConversations().remove(conversation.getId());
                return "done";
            }
            else {
                return "success";
            }
        } else if (tries == 1) {
            return "again";
        } else {
            nextProblem();
            if (currentProblem == problems.size()) {
                conversation.end();
                workspaceBean.getConversations().remove(conversation.getId());
                return "done";
            } else {
                return "failure";
            }
        }
    }

    public String startOverAction() {
        Collections.shuffle(problems);
        currentProblem = 0;
        score = 0;
        tries = 0;
        response = "";
        return "startOver";
    }

    private void nextProblem() {
        correctAnswer = problems.get(currentProblem).getAnswer();
        currentProblem++;
        tries = 0;
        response = "";
    }
}
