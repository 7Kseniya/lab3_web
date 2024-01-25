package lab3_web;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab3_web.beans.PointBean;
import lab3_web.database.PointDao;
import lab3_web.database.PointDto;
import lab3_web.entity.Point;
import lab3_web.utils.AreaChecker;
import lombok.Getter;
import lombok.Setter;

@Named("service")
@ApplicationScoped
@Getter
@Setter
public class Service {
    @Inject
    private PointDao pointDao;
    private AreaChecker areaChecker;

    public Service() {
        this.areaChecker = new AreaChecker();
    }

    public void addPoint(PointBean pointBean) {
        double x = pointBean.getX();
        double y = pointBean.getY();
        double r = pointBean.getR();
        double startTime = System.currentTimeMillis();
        boolean hit = areaChecker.isHit(x, y, r);
        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);
        double executionTime = System.currentTimeMillis() - startTime;

        Point point = new Point(pointBean.getListContainer().getSessionID(), x, y, r, hit, executionTime);
        PointDto pointDto = new PointDto(x, y, r, currentTime, hit, executionTime);

        pointDao.savePoint(point);
        pointBean.getListContainer().getList().add(pointDto);
    }
    public void removeDotsBySessionId(String sessionID) {
        pointDao.remove(sessionID);
    }

}
