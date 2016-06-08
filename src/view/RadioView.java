/**
 * 
 */
package view;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

/**
 * @author vagrant
 *
 */
@SessionScoped
public class RadioView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String type = "PS4";
    /**
     * @return type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type セットする type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    

}
