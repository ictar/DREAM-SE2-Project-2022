package in.dream.ejb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forumid;

    public Long getForumid() {
        return forumid;
    }

    public void setForumid(Long forumid) {
        this.forumid = forumid;
    }
}
