package lab3_web.beans;

import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab3_web.Service;
import lombok.Data;
import lombok.NoArgsConstructor;


@Named("pointBean")
@ApplicationScoped
@NoArgsConstructor
@Data
public class PointBean implements Serializable {
    private double x;
    private double y;
    private double r;
    private Integer timezone;

    @Inject
    private Service service;

    @Inject
    private ListContainer listContainer;


    public PointBean(double x, double y, double r, Integer timezone, Service service, ListContainer listContainer) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.timezone = timezone;
        this.service = service;
        this.listContainer = listContainer;
    }
    

    public void processRequest() {
        FacesContext.getCurrentInstance()
            .getExternalContext()
            .getSessionMap()
            .put("timezone", timezone);
            System.out.println(this);
            service.addPoint(this);
    }





}