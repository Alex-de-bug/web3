package xyz;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cookie")
    private String cookie;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attempt> attempts;

    public User() {
    }

    public User(String cookie) {
        this.cookie = cookie;
        attempts = new ArrayList<>();
    }

    public void addAuto(Attempt attempt) {
        attempt.setUser(this);
        attempts.add(attempt);
    }

    public void removeAuto(Attempt attempt) {
        attempts.remove(attempt);
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", cookie='" + cookie +
                '}';
    }
}
