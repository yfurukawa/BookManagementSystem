/**
 * 
 */
package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author vagrant
 *
 */
public abstract class IFileDAO {
    protected File file = null;
    protected FileReader fileReader = null;
    protected BufferedReader bufferedReader = null;
    
    /**
     * fileNameで指定されたファイルを読み込み用にオープンする。
     * @param fileName
     * @throws FileNotFoundException 
     */
    abstract public void openFile(String fileName) throws FileNotFoundException; 
    
    /**
     * @throws IOException
     */
    abstract public void closeFile() throws IOException;
    
    /**
     * ファイルから1行読み込む。
     * 読み込む行が無かった場合はnullを返す。
     * @return 読み込んだ1行文の文字列
     * @throws IOException
     */
    abstract public String readLine() throws IOException;
    
}
