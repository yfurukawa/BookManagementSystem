package infrastructure;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author vagrant
 *
 */
public class TextFileDAOTest {
    TextFileDAO sut = null;
    
    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        sut = new TextFileDAO();
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * 開くファイルが存在しない場合にFileNotFoundExceptionがスローされることを確認する
     * 
     * @throws FileNotFoundException 
     */
    @Test(expected = FileNotFoundException.class)
    public void testOpenFile_ファイルが無い場合に例外がスローされる() throws FileNotFoundException {
        sut.openFile("NoExsistFile.txt");
    }

    /**
     * 開くファイルが存在する合にFileNotFoundExceptionがスローされないことを確認する
     * 
     */
    @Test
    public void testOpenFile_ファイルがある場合は例外がスローされない() {
        try {
            sut.openFile("/home/vagrant/workspace/BookManagementSystem/test/infrastructure/SingleLineFile.txt");
        }
        catch(FileNotFoundException e) {
            fail(e.toString());
        }
    }
    
//    /**
//     * @throws IOException
//     */
//    @Test(expected = IOException.class)
//    public void testCloseFile() throws IOException {
////        sut.openFile("/home/vagrant/workspace/BookManagementSystem/test/infrastructure/SingleLineFile.txt");
//        sut.closeFile();
//        
//    }

    /**
     * 
     */
    @Test
    public void testReadLine_1行しかないファイルから1行読み込み() {
        try {
            sut.openFile("/home/vagrant/workspace/BookManagementSystem/test/infrastructure/SingleLineFile.txt");
        
            assertThat(sut.readLine(), is("Single Line"));
            
            sut.closeFile();
        }
        catch(FileNotFoundException e) {
            fail(e.toString());
        }
        catch(IOException e) {
            fail(e.toString());
        }
    }

    /**
     * 
     */
    @Test
    public void testReadLine_1行しかないファイルから2行読み込み() {
        try {
            sut.openFile("/home/vagrant/workspace/BookManagementSystem/test/infrastructure/SingleLineFile.txt");
        
            sut.readLine();
            assertThat(sut.readLine(), is(nullValue()));
            
            sut.closeFile();
        }
        catch(FileNotFoundException e) {
            fail(e.toString());
        }
        catch(IOException e) {
            fail(e.toString());
        }
    }
}
