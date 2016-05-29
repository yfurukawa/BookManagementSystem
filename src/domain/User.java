/**
 * 
 */
package domain;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author vagrant
 *
 */
@ManagedBean
@ViewScoped
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String manager;
    private String name;

    /**
     * 
     */
    public User(){
        setManager("true");
        setName("hoge");
    }
    /**
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name セットする name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return isManager
     */
    public String getManager() {
        return manager;
    }

    /**
     * @param isManager セットする isManager
     */
    public void setManager(String isManager) {
        this.manager = isManager;
    }
    

}
