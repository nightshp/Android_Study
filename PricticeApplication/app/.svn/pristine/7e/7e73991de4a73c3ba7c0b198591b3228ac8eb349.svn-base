package lunzn.com.pricticeapplication.biz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc: 线程池
 * <p>
 * Author: suhongpeng
 * PackageName: lunzn.com.pricticeapplication.biz
 * ProjectName: PricticeApplication
 * Date: 2019/1/29 10:04
 */
public class ExcutorService {

    private static ExecutorService sExecutorService;

    public static ExecutorService getInstance() {
        if (sExecutorService == null) {
            synchronized (ExecutorService.class) {
                if (sExecutorService == null) {
                    sExecutorService = Executors.newFixedThreadPool(2);
                }
            }
        }
        return sExecutorService;
    }
}
