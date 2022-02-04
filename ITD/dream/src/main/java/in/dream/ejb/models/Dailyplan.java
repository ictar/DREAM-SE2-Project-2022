package in.dream.ejb.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Dailyplan.findOne", query="SELECT dp from Dailyplan dp where dp.dailyplanid=?1"),
        @NamedQuery(name="Dailyplan.findByAgronomist", query="SELECT dp from Dailyplan dp where dp.agronomist.agronomistid=?1 order by dp.date desc")
})
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

    public void setCompleted() {this.status = 1;}

    private String deviation;

    @Basic
    public String getDeviation() {
        return deviation;
    }

    public void setDeviation(String deviation) {
        this.deviation = deviation;
    }

    @ManyToOne
    @JoinColumn(name="agronomist")
    private Agronomist agronomist;

    public Agronomist getAgronomist() {
        return agronomist;
    }

    public void setAgronomist(Agronomist agronomist) {
        this.agronomist = agronomist;
    }

    @ManyToMany
    @JoinTable(
            name = "farmerInDailyPlan",
            joinColumns = {@JoinColumn(name="dailyplanid")},
            inverseJoinColumns = {@JoinColumn(name="farmerid")}
    )
    private Collection<Farmer> farmers;
}
