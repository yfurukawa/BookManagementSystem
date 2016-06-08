/**
 * 
 */
package view;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

/**
 * @author vagrant
 *
 */
@ManagedBean(name = "fileUploadBean")
@ViewScoped
public class FileUploadBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private UploadedFile file;

    /**
     * @return ghj
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
}
