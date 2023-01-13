package test.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class IOTest {

    /**
     * 定义文件路径时，注意：可以用“/”或者“\”。
     * 在写入一个文件时，如果使用构造器FileOutputStream(file)，则目录下有同名文件将被覆盖。
     * 如果使用构造器FileOutputStream(file,true)，则目录下的同名文件不会被覆盖，在文件内容末尾追加内容。
     * 在读取文件时，必须保证该文件已存在，否则报异常。
     * 字节流操作字节，比如：.mp3，.avi，.rmvb，mp4，.jpg，.doc，.ppt
     * 字符流操作字符，只能操作普通文本文件。最常见的文本文件：.txt，.java，.c，.cpp 等语言的源代码。尤其注意.doc,excel,ppt这些不是文本文件
     */

    //File类的使用
    /*1.创建功能
      2.获取功能
      3，删除功能
      4.重命名功能
    * */
    @Test
    public void test1(){

        File file = new File("D://file.txt");
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(File.separator);
        if (file.exists()){
            boolean b = file.renameTo(new File("D:\\filetest.txt"));
            System.out.println(b);
        }
        System.out.println(file.getName());
    }

    //字符，字节输入流；try-with-resourses语法糖，自动关闭资源
    @Test
    public void test2(){
        String filepath = "D:\\filetest.txt";

        File file = new File(filepath);
        //字符输入
        try(FileReader fileReader = new FileReader(file);){
            char[] chars = new char[2];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = fileReader.read(chars)) != -1 ){
                String s = new String(chars,0,len);
                sb.append(s);
                System.out.println("字符输入打印:"+s);
            }
            System.out.println(sb);
        }catch (Exception e){

        }
        //字节输入
        /*try(FileInputStream fileInputStream = new FileInputStream(file);
            DoOpenCloseResourse resourse = new DoOpenCloseResourse("字节输入流");){
            resourse.open();
            byte[] buffer =  new byte[5];
           int len;
            StringBuilder sb = new StringBuilder();
            while ((len=fileInputStream.read(buffer) )!= -1){
               String s = new String(buffer,0,buffer.length);
               sb.append(s);
               System.out.println("字节输入打印:"+s);
           }
            System.out.println(sb);
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }
    //字符字节输出流
    @Test
    public void test3(){

        String filepath = "D:\\filetest.txt";

        File file = new File(filepath);

        //字符输出
        /*try (FileWriter fileWriter = new FileWriter(file,true);) {
            fileWriter.write("昨天今天明天");
        }catch (Exception e){

        }*/

        //字节输出
        try (FileOutputStream fileOutputStream = new FileOutputStream(file,true)) {
            byte[] bytes = "abc".getBytes();
            fileOutputStream.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //一边输入一边输出
    @Test
    public void test4(){
        String fileSrc = "D:\\fileSrc.txt";
        String fileDest = "D:\\fileDest.txt";

        //字符流
        /*try (
                FileReader fr = new FileReader(fileSrc);
                FileWriter fw = new FileWriter(fileDest)
        ) {

            char[] chars = new char[5];
            int len;
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars,0,len);
                System.out.println(new String(chars,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //字节流
        try (
                FileInputStream fis = new FileInputStream(fileSrc);
                FileOutputStream fos = new FileOutputStream(fileDest,true)) {

            byte[] bytes = new byte[5];
            int len;
            while ( (len = fis.read(bytes) ) != -1 ){
                fos.write(bytes,0,len);
                System.out.println(new String(bytes,0, len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //字符，字节缓冲流
    @Test
    public void test5(){
        String fileSrc = "D:\\fileSrc.txt";
        String fileDest = "D:\\fileDest.txt";

        //字符流
        /*try (
                FileReader fr = new FileReader(fileSrc);
                FileWriter fw = new FileWriter(fileDest);
                BufferedReader br = new BufferedReader(fr);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {

            char[] chars = new char[5];
            int len;
            while ((len = br.read(chars)) != -1) {
                bw.write(chars,0,len);
                System.out.println(new String(chars,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //字节流
        try (
                FileInputStream fis = new FileInputStream(fileSrc);
                FileOutputStream fos = new FileOutputStream(fileDest,true);
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            byte[] bytes = new byte[5];
            int len;
            while ( (len = bis.read(bytes) ) != -1 ){
                bos.write(bytes,0,len);
                System.out.println(new String(bytes,0, len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //字符，字节转换流
    @Test
    public void test6(){
        String fileSrc = "D:\\fileSrc.txt";
        String fileDest = "D:\\fileDest.txt";

        //字节流转字符流
        try ( FileInputStream fis = new FileInputStream(fileSrc);
              InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8")) {
            char[] chars = new char[5];
            byte[] bytes = new byte[5];
            //用字节读取中文，乱码
            /*int len;
            while ((len = fis.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }*/
            //将字节转字符正常
            int len;
            while ((len = inputStreamReader.read(chars)) != -1){
                System.out.println(new String(chars,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //字符流转字节流
        try(
               FileOutputStream fos =  new FileOutputStream(fileDest);
               OutputStreamWriter ow =  new OutputStreamWriter(fos,"UTF-8");
                ){
               ow.write("大后天");
        }catch (Exception e){
            e.printStackTrace();
        }


        //同时进行
       /* try (
                FileInputStream fis = new FileInputStream(fileSrc);
                FileOutputStream fos = new FileOutputStream(fileDest);
                //字节转字符流
                InputStreamReader ir = new InputStreamReader(fis, StandardCharsets.UTF_8);
                //字符流转字节流
                OutputStreamWriter ow = new OutputStreamWriter(fos, StandardCharsets.UTF_8);) {

            byte[] bytes = new byte[5];
            char[] chars = new char[5];
            int len;
            while ( (len = ir.read(chars) ) != -1 ){
                ow.write(chars,0,len);
                System.out.println(new String(chars,0, len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

    @Test
    public void test7(){

        //控制台打印什么就往文件输入什么，  以下代码要在main中运行才能成功   解决方法：在idea安装目录bin下找到后缀为.vmoptions的文件，在里面加行命令：-Deditable.java.test.console=true
        String fileDest = "D:\\fileDest.txt";
        try (
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileDest))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
