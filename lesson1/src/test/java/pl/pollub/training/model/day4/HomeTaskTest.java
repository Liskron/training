package pl.pollub.training.model.day4;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * Created by Wlad on 27.04.2016.
 */
public class HomeTaskTest {
    @Test
    public void createFolder() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("https://hsto.org/storage1/cf1a57bd/e7cc2b34/b9d6fc1d/0a19729c.jpg");
        list.add("http://img.relax.ru/106095/9513376405064810_3d9fbf87.jpg");
        list.add("https://vlast.kz/media/pages/xf/1437560773dlfti_1000x768.jpg");
        list.add("http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg");
        list.add("http://www.bmw.by/_common/shared/newvehicles/x/x5/2013/showroom/gallery/_img/background.jpg");
        HomeTask task = new HomeTask(list);

        System.out.println(new Date());
        task.doOneThread();
        System.out.println(new Date());
        HomeTask task2 = new HomeTask(list);
        System.out.println(new Date());
        downloadAndSave(5,task2);
        System.out.println(new Date());
    }

    public void downloadAndSave(int threads, HomeTask task) {
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        for (int i = 0 ; i < threads; i++) {
            executor.execute(getRunnable(task));
        }
        executor.shutdown();
        while (!executor.isTerminated()){
        }
    }

    private Runnable getRunnable(HomeTask task) {
        return () -> {
            while (task.index < task.list.size()){
                task.downloadAndSave(task.list.get(task.index));
            }
        };
    }

}