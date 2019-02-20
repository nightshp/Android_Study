package com.muti.lesson.biz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc: TODO
 * <p> 线程池
 * Author: Liu Zhongzhu
 * PackageName: com.muti.lesson.biz
 * ProjectName: AndroidStudioProjects
 * Date: 2019/1/25 16:51
 */
public class ExcutorService {

  private static ExecutorService s = null;

   public static ExecutorService getInstance() {
       if(s == null ) {
           synchronized (ExecutorService.class) {
               if(s == null ) {
                   s = Executors.newFixedThreadPool(2);
               }
           }
       }
       return s;
   }

}
