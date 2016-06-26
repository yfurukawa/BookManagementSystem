/**
 * 
 */
package view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author vagrant
 *
 */
@ManagedBean
public class CommandLinkController implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private boolean UseAuthority = true;
    /**
     * @return hgj
     * 
     */
    public boolean checkAuthority() {
        //addMessage("Welcome to Primefaces!!");
        return false;
    }

    /**
     * @param summary
     */
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return useAuthority
     */
    public boolean isUseAuthority() {
        return UseAuthority;
    }

    /**
     * @param useAuthority セットする useAuthority
     */
    public void setUseAuthority(boolean useAuthority) {
        UseAuthority = useAuthority;
    }
}
