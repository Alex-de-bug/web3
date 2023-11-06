package xyz;
import xyz.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "result")
@Getter
@Setter
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "x")
    private Double x;
    @Column (name = "y")
    private Double y;
    @Column (name = "r")
    private Double r;
    @Column (name = "hit")
    private Boolean hit;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Attempt() {
    }

    public Attempt(int id, Double x, Double y, Double r, Boolean hit, User user) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.user = user;
    }


    @Override
    public String toString() {
        return "Attempt{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", hit=" + hit +
                ", user=" + user +
                '}';
    }
}
