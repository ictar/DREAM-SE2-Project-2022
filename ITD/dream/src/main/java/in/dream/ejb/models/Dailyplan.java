package in.dream.ejb.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Dailyplan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dailyplanid;

    public Long getDailyplanid() {
        return dailyplanid;
    }

    public void setDailyplanid(Long dailyplanid) {
        this.dailyplanid = dailyplanid;
    }

    private String title;

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private LocalDate date;

    @Basic
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private String content;

    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private int status;

    @Basic
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private String deviation;

    @Basic
    public String getDeviation() {
        return deviation;
    }

    public void setDeviation(String deviation) {
        this.deviation = deviation;
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
