/**
 * 
 */
package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 * @author vagrant
 *
 */
@ManagedBean
@ViewScoped
public class EdiableTableView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    List<Car> cars1;

//    @ManagedProperty("#{carService}")
    private CarService service;
    
    /**
     * 
     */
    @PostConstruct
    public void init() {
        service = new CarService();
        cars1 = service.createCars();
    }

    /**
     * @return h
     */
    public List<Car> getCars1() {
        return cars1;
    }

    /**
     * @param cars1
     */
    public void setCars1(List<Car> cars1) {
        this.cars1 = cars1;
    }
    
    /**
     * @param event
     */
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getSoldoutString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    /**
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
