/**
 * 
 */
package infrastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import domain.IFileDAO;

/**
 * @author vagrant
 *
 */
public class TextFileDAO extends IFileDAO {

    /* (非 Javadoc)
     * @see domain.IFileDAO#openFile(java.lang.String)
     */
    @Override
    public void openFile(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
    }

    /* (非 Javadoc)
     * @see domain.IFileDAO#closeFile()
     */
    @Override
    public void closeFile() throws IOException {
        bufferedReader.close();
    }

    /* (非 Javadoc)
     * @see domain.IFileDAO#readLine()
     */
    @Override
    public String readLine() throws IOException {
        return bufferedReader.readLine();
        
    }

}
