package lab3_web.beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import lab3_web.Service;
import lab3_web.database.PointDto;
import lombok.Getter;
import lombok.Setter;

@Named("listContainer")
@ApplicationScoped
@Getter
@Setter
public class ListContainer implements Serializable{
    @Inject
    private Service service;
    private final String sessionID;
    private final List<PointDto> list;

    public ListContainer() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        this.sessionID = session.getId();
        this.list = new LinkedList<>();
    }

    public void remove() {
        System.out.println(sessionID);
        service.removeDotsBySessionId(sessionID);
        list.clear();
    }    
}