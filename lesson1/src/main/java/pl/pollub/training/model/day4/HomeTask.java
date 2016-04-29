package pl.pollub.training.model.day4;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Wlad on 27.04.2016.
 */
public class HomeTask {
    private static final String DESKTOP_ADDRESS = "C:\\Users\\afrai\\Desktop\\";
    private String finalFolder;
    public List<String> list;
    public volatile int index = 0;

    public HomeTask(List<String> list) {
        this.createFolder();
        this.list = list;
    }

    private void createFolder() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-YYYY-HH-mm-ss");//dd/MM/yyyy
        Date data = new Date();
        try {
            boolean success = (new File(DESKTOP_ADDRESS + sdfDate.format(data))).mkdirs();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        this.finalFolder = sdfDate.format(data);
    }

    private static String getNameOfFile(String s) {
        String[] arrayStrings = s.split("/");
        return arrayStrings[arrayStrings.length - 1];
    }

    public void downloadAndSave(String link) {
        try {
            URL url = new URL(link);
            InputStream in = new BufferedInputStream(url.openStream());
            OutputStream out =
                    new BufferedOutputStream(
                            new FileOutputStream(DESKTOP_ADDRESS + this.finalFolder + "\\" + getNameOfFile(link)));

            for (int i; (i = in.read()) != -1; ) {
                out.write(i);
            }
            in.close();
            out.close();
            index++;
        } catch (IOException e) {
            System.out.println("Download filed - check error:" + e.getMessage());
        }
    }

    public void doOneThread(){
        for (String s :
                this.list) {
            this.downloadAndSave(s);
        }
    }



}
