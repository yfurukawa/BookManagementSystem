/**
 * 
 */
package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author vagrant
 *
 */
@ManagedBean
@ApplicationScoped
public class CarService implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return h
     */
    public List<Car> createCars() {
        List<Car> list = new ArrayList<Car>();
        list.add(new Car());
        list.add(new Car());
        
        return list;
    }
}
