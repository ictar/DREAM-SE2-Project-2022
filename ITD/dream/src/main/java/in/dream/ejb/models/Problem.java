package in.dream.ejb.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemid;

    public Long getProblemid() {
        return problemid;
    }

    public void setProblemid(Long problemid) {
        this.problemid = problemid;
    }

    private String request;

    @Basic
    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    private Timestamp requesttime;

    @Basic
    public Timestamp getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Timestamp requesttime) {
        this.requesttime = requesttime;
    }

    private String answer;

    @Basic
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private Timestamp answertime;

    @Basic
    public Timestamp getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Timestamp answertime) {
        this.answertime = answertime;
    }

    private int feedback;

    @Basic
    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    private Timestamp feedbacktime;

    @Basic
    public Timestamp getFeedbacktime() {
        return feedbacktime;
    }

    public void setFeedbacktime(Timestamp feedbacktime) {
        this.feedbacktime = feedbacktime;
    }

    @ManyToOne
    private Farmer manyToOne;

    public Farmer getManyToOne() {
        return manyToOne;
    }

    public void setManyToOne(Farmer manyToOne) {
        this.manyToOne = manyToOne;
    }

    @ManyToOne
    private Agronomist agronomist;

    public Agronomist getAgronomist() {
        return agronomist;
    }

    public void setAgronomist(Agronomist agronomist) {
        this.agronomist = agronomist;
    }
}
