package com.mailxifan.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhangqilin
 * email:mailxifan@126.com
 * date:2017/8/23
 */

public class FileUtils {
    /**
     * save file
     *
     * @param dic      path
     * @param fileName name
     * @param obj      Object
     */
    public static void saveFile(String dic, String fileName, Object obj) {
        try {
            File file = new File(dic);
            if (!file.exists()) {
                file.mkdirs();
            }
            File newFile = new File(dic + fileName);
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(newFile));
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get file
     * @param fileName
     * @return
     */
    public static Object getFile(String fileName) {
        Object obj = null;
        try {
            File file = new File(fileName);
            if (file.exists() && !file.isDirectory()) {
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(file));
                obj = ois.readObject();
                ois.close();
                return obj;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
