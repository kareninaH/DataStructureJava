package com.kareninah.sparseArray;


import java.io.*;

/**
 * @FileName DataStructure.sparseArray.FileTest
 * @Description TODO
 * @Author hgy
 * @Date 2022/10/14:12:44
 * @Version V1.0
 */
public class FileIO {

    private static final File file = new File(System.getProperty("user.dir"),"fileout/sparsearray.data");

    /**
     * 将稀疏数组序列化保存
     * @param sparseArray
     * @throws IOException
     */
    public static void save(int[][] sparseArray) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(sparseArray);
        oos.close();
    }

    /**
     * 反序列化稀疏数组
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static int[][] upload() throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        return (int[][])ois.readObject();
    }
}
