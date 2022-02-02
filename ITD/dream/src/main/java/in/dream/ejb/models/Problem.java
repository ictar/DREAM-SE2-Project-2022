package in.dream.ejb.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQueries({
        @NamedQuery(name="Problem.findAll", query="SELECT a from Problem a WHERE a.farmer=?1"),
})
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

    private String title;

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    private Farmer farmer;

    @ManyToOne
    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmerid) {
        this.farmer = farmerid;
    }

    private Agronomist agronomist;

    @ManyToOne
    public Agronomist getAgronomist() {
        return agronomist;
    }

    public void setAgronomist(Agronomist agronomist) {
        this.agronomist = agronomist;
    }
}
