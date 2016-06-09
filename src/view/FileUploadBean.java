/**
 * 
 */
package view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
/**
 * @author vagrant
 *
 */
@ManagedBean
public class FileUploadBean {

    private UploadedFile file;
    
    /**
     * @return h
     */
    public UploadedFile getFile() {
        return file;
    }
 
    /**
     * @param file
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    /**
     * 
     */
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
