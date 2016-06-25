/**
 * 
 */
package view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * @author vagrant
 *
 */
@ManagedBean
public class Switches implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private boolean wip;
    private boolean wipType = false;
    private boolean img=false;
    private String imgSrc="../img/1150_32.png";
    
    /**
     * @return wip
     */
    public boolean getWip() {
        return wip;
    }

    /**
     * @param wip セットする wip
     */
    public void setWip(boolean wip) {
        this.wip = wip;
    }

    /**
     * @return wipType
     */
    public boolean getWipType() {
        return wipType;
    }

    /**
     * @param wipType セットする wipType
     */
    public void setWipType(boolean wipType) {
        this.wipType = wipType;
    }

    /**
     * @return s
     */
    public String getRadioEnable() {
        if(getWipType()) {
            return "false";
        }
        else {
            return "true";
        }
    }
    
    /**
     * 
     */
    public void changeState() {
        if(getWip()) {
            setWipType(true);
        }
        else {
            setWip(false);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(getRadioEnable()));
    }

    /**
     * @return img
     */
    public boolean getImg() {
        return img;
    }

    /**
     * @param img セットする img
     */
    public void setImg(boolean img) {
        this.img = img;
    }
    /**
     * 
     */
    public void changeImg() {
        if(this.img) {
            this.imgSrc="../img/1150.png";
        }
        else {
            this.imgSrc="../img/1150_32.png";
        }
    }

    /**
     * @return imgSrc
     */
    public String getImgSrc() {
        return imgSrc;
    }

    /**
     * @param imgSrc セットする imgSrc
     */
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
