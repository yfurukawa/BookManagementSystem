/**
 * 
 */
package view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author vagrant
 *
 */
@ManagedBean
@SessionScoped
public class InputView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String background = "background-color: #aa0000";
    private String backgroundForSize = "";
    private String value = "";
    private String valueH = "";
    private String valueW = "";
    private String valueD = "";

    /**
     * @return background
     */
    public String getBackground() {
        return background;
    }

    /**
     * @param background セットする background
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value セットする value
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * 
     */
    public void validate() {
        if(this.value.isEmpty()) {
            setBackground("background-color: #555500");
        }
        else {
            setBackground("");
        }
    }

    /**
     * @return valueH
     */
    public String getValueH() {
        return valueH;
    }

    /**
     * @param valueH セットする valueH
     */
    public void setValueH(String valueH) {
        this.valueH = valueH;
    }

    /**
     * @return valueW
     */
    public String getValueW() {
        return valueW;
    }

    /**
     * @param valueW セットする valueW
     */
    public void setValueW(String valueW) {
        this.valueW = valueW;
    }

    /**
     * @return valueD
     */
    public String getValueD() {
        return valueD;
    }

    /**
     * @param valueD セットする valueD
     */
    public void setValueD(String valueD) {
        this.valueD = valueD;
    }
    
    /**
     * 
     */
    public void validateForSize() {
        if(this.isSizeValid()) {
            setBackgroundForSize("");
        }
        else {
            setBackgroundForSize("background-color: #a0a0a0");
        }
    }
    
    private boolean isSizeValid() {
        return (this.valueH.isEmpty() && this.valueW.isEmpty() && this.valueD.isEmpty()) ||
                (!this.valueH.isEmpty() && !this.valueW.isEmpty() && !this.valueD.isEmpty());
    }

    /**
     * @return backgroundForSize
     */
    public String getBackgroundForSize() {
        return backgroundForSize;
    }

    /**
     * @param backgroundForSize セットする backgroundForSize
     */
    public void setBackgroundForSize(String backgroundForSize) {
        this.backgroundForSize = backgroundForSize;
    }
}
