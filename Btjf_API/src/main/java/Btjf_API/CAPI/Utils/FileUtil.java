package Btjf_API.CAPI.Utils;

import java.io.File;

/**
 * Created by wl on 2017/8/4.
 */
public class FileUtil {

    /**
     * 取log文件夹中，最后生成的且不为空的全部日志的路径
     * @return 返回邮件中日志的路径
     */
    public String getLogPath(){
        String path = "log/";
        File file = new File(path);
        File[] files = file.listFiles();
        long longDate = 0;
        String fileName = "";
        for(File nFile : files){
            if(nFile.length()==0 || nFile.isDirectory()){continue;}
            String nFileName = nFile.getName();
            if(longDate<nFile.lastModified() && !(nFileName.contains("重跑"))){
                fileName = nFileName;
            }
        }
        return fileName;
    }

    /**
     * 取log文件夹中，最后生成的且不为空的失败重跑的日志路径
     * @return
     */
    public String getRetryLogPath(){
        String path = "log/";
        File file = new File(path);
        File[] files = file.listFiles();
        long longDate = 0;
        String fileName = "";
        for(File nFile : files){
            if(nFile.isDirectory()){continue;}
            String nFileName = nFile.getName();
            if(longDate<nFile.lastModified() && nFileName.contains("重跑")){
                fileName = nFileName;
            }
        }
        return fileName;
    }


    public static void main(String[] args){
        new FileUtil().getLogPath();

    }
}
