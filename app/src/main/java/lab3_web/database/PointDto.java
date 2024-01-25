package lab3_web.database;

import java.time.LocalDateTime;

import jakarta.faces.context.FacesContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PointDto {
    private double x;
    private double y;
    private double r;
    private LocalDateTime currentTime;
    private boolean hit;
    private double executionTime;

    public LocalDateTime getCurrentTime() {
        Integer timezone = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("timezone", 0);
        return currentTime.minusHours(timezone/60);
    }
}