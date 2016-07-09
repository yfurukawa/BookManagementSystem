/**
 * 
 */
package view;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * @author vagrant
 *
 */
@ManagedBean
@RequestScoped
public class FileDownloadView implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private StreamedContent file;
    private List<String> tsvStringOfRecord;
    int maxNumberOfRecordsInFile = 100;
    String outputDirectory = "/home/vagrant/git/BookManagementSystem/WebContent/resources/output/";
    String outputFilename;
    String zippedFilename;
    String createdFilename;
    String mimeType;
    /**
     * 
     */
    public void exportFile() {
        
    }
    
    /**
     * 
     */
    public FileDownloadView() {

    }
    
    /**
     * @return file
     */
    public StreamedContent getFile() {
        prepareSampleData();
        createExportFile();
        prepareDownloadFile();
        return file;
    }

    private void prepareDownloadFile() {
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/output/" + createdFilename);
        file = new DefaultStreamedContent(stream, mimeType, createdFilename);
    }
    

    private void createExportFile() {
        List<File> outputFiles = new ArrayList<File>();
        if( tsvStringOfRecord.size() > maxNumberOfRecordsInFile ) {
            for(int fileNumber = 1; fileNumber <= calculateMaxFuleNumber(); ++fileNumber) {
                List<String> tmpRecord = new ArrayList<String>();
                int startIndex = maxNumberOfRecordsInFile * (fileNumber - 1);
                int endIndex = startIndex + maxNumberOfRecordsInFile;
                for(int index = startIndex; index < endIndex && index < tsvStringOfRecord.size(); ++ index) {
                    tmpRecord.add(tsvStringOfRecord.get(index));
                }
                outputFilename = outputDirectory + "test_" + String.valueOf(fileNumber) + ".tsv";
                // ファイルオブジェクトの生成
                File outputFile = new File(outputFilename);
                outputFiles.add(outputFile);
                createSingleTsvFile( outputFile, tmpRecord );
            }
            
            try {
                createdFilename = "test.zip";
                mimeType = "application/x-zip-compressed";
                createZip(outputFiles, outputDirectory + createdFilename);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        else {
            createdFilename = "test.tsv";
            // ファイルオブジェクトの生成
            File outputFile = new File(outputDirectory + createdFilename);
            mimeType = "text/tab-separated-values";
            createSingleTsvFile( outputFile, tsvStringOfRecord );
        }
    }

    /**
     * @return
     */
    private int calculateMaxFuleNumber() {
        if(tsvStringOfRecord.size() % maxNumberOfRecordsInFile != 0) {
            return tsvStringOfRecord.size() / maxNumberOfRecordsInFile + 1;
        }
        else {
            return tsvStringOfRecord.size() / maxNumberOfRecordsInFile;
        }
    }

    /**
     * 
     */
    private void createSingleTsvFile( File outputFile, List<String> outputDatas ) {
        
        try {
          // 出力ストリームの生成
          FileOutputStream fos = new FileOutputStream(outputFile);
          OutputStreamWriter osw = new OutputStreamWriter(fos);
          PrintWriter pw = new PrintWriter(osw);
          // ファイルへの書き込み
          for(String str: outputDatas) {
              pw.println(str);
          }
          // 後始末
          pw.close();
        // エラーがあった場合は、スタックトレースを出力
        } catch(Exception e) {
          e.printStackTrace();
        }
    }
    
    
    //渡されたファイル群をZipに圧縮するメソッド
    // http://techblog.recochoku.jp/%E6%9C%AA%E5%88%86%E9%A1%9E/java%E3%81%A7zip%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%82%92%E4%BD%9C%E6%88%90%E3%81%99%E3%82%8B
    private void createZip(List<File> fileList, String zipFilename) throws IOException {
      if(fileList.size() > 0){
   
        //test.zipという名前のZipファイルを作成する
        File zipFile = new File(zipFilename);
        try(ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)))){
          for (File file : fileList) {
            try(InputStream is = new BufferedInputStream(new FileInputStream(file))){
              ZipEntry entry = new ZipEntry(file.getName());
              zos.putNextEntry(entry);
              int len = 0;
              byte[] buf = new byte[1024];
              while ((len = is.read(buf)) != -1) {
                zos.write(buf, 0, len);
              }
              if(entry != null){
                zos.closeEntry();
              }
            }
          }
          zos.finish();
        }
      }
    }
    private void prepareSampleData() {
        int count = 0;
        tsvStringOfRecord = new ArrayList<String>();
        for(count = 0; count < 100; ++count) {
            tsvStringOfRecord.add(String.valueOf(count));
        }
        
    }
}
