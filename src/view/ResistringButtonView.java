/**
 * 
 */
package view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author vagrant
 *
 */
@ManagedBean(name="resistringButtonView")
@ViewScoped
public class ResistringButtonView implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param actionEvent
     */
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
     
    /**
     * @param summary
     */
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
