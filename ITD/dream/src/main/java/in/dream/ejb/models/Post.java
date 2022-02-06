package in.dream.ejb.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Post.findAll", query="SELECT a from Post a order by a.time Desc"),
        @NamedQuery(name="Post.findOne", query="SELECT a from Post a where a.postid=?1")
})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postid;

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    private String title;

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String content;

    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Timestamp time;

    @Basic
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @ManyToOne
    @JoinColumn(name="farmer")
    private Farmer farmer;

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    @ManyToOne
    @JoinColumn(name="forum")
    private Forum forum;

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    @OrderBy("time asc")
    private List<Comment> comments;
    public List<Comment> getComments() {
        return comments;
    }
    public void addComment(Comment comment) {
        if(this.comments == null) {
            this.comments = new ArrayList<Comment>();
        }
        this.comments.add(comment);
    }
}
