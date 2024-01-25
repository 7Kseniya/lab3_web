package lab3_web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "point")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    private String sessionID;

    private double x;
    private double y;
    private double r;
    //private LocalDateTime currentTime;
    private boolean hit;
    private double executionTime;


    public Point(String sessionID, double x, double y, double r, boolean hit, double executionTime) {
        this.sessionID = sessionID;
        this.x = x;
        this.y = y;
        this.r = r;
        //this.currentTime = currentTime;
        this.hit = hit;
        this.executionTime = executionTime;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return this.r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isHit() {
        return this.hit;
    }

    public boolean getHit() {
        return this.hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public double getExecutionTime() {
        return this.executionTime;
    }

    public void setExecutionTime(double executionTime) {
        this.executionTime = executionTime;
    }

}