package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "comment")
    private String text;

    @Column(name = "date")
    private LocalDate createdDate;

    //A single user can have multiple comments. Hence the 'comments' table is mapped to 'users' table with Many:One mapping
    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "user_id")
    private User user;

    //Multiple comments can be associated with one image. Hence the 'comments' table is mapped to 'image' table with Many:One mapping
    @ManyToOne(fetch = FetchType.LAZY)
   
    @JoinColumn(name = "image_id")
    private Image image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}