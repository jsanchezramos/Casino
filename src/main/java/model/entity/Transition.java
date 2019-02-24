package model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransition;
    private String userId;
    private String namePlay;
    private int increment;
    private Date lastPlay;

    public Transition(String userId, String namePlay, int increment, Date lastPlay) {
        this.userId = userId;
        this.namePlay = namePlay;
        this.increment = increment;
        this.lastPlay = lastPlay;
    }

    public Transition() {
    }

    public Long getIdTransition() {
        return idTransition;
    }

    public int getIncrement() {
        return increment;
    }

    public String getUserId() {
        return userId;
    }

    public String getNamePlay() {
        return namePlay;
    }

    public Date getLastPlay() {
        return lastPlay;
    }
}
