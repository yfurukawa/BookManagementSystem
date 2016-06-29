/**
 * 
 */
package view;

import java.io.Serializable;

/**
 * @author vagrant
 *
 */
public class Car implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String id="aaa";
    private int year=1999;
    private boolean soldout=true;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public boolean isSoldout() {
        return soldout;
    }
    public void setSoldout(boolean soldout) {
        this.soldout = soldout;
    }
    
    public String getSoldoutString() {
        if(soldout) {
            return "true";
        }
        else {
            return "false";
        }
    }

}
