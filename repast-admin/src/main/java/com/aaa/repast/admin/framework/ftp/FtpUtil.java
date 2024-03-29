package com.aaa.repast.admin.framework.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

public class FtpUtil {
    public  static  boolean uploadFile(String host, Integer port, String username, String password, String basePath, String filePath, String fileName, InputStream inputStream){
        // FtpClinet:commons-http包所提供的一个操作ftp的类，根据这个类所提供的的方法可以对ftp服务进行操作(上传，下载)
        // 1.创建临时路径变量
        String tempPath="";
        // 2.常见FtpClinet类的对象
        FTPClient ftp  = new FTPClient();
        try {
            // 3.定义返回码
            int reply;
            // 4.连接ftp服务器
            ftp.connect(host, port);
            // 5.登录ftp
            ftp.login(username, password);
            // 6.需要判断是否登录成功，需要接收返回码
            // 如果连接成功并且登录成功，返回的状态码为230(200-300)，如果失败，返回的状态码为503(500-600)
            reply = ftp.getReplyCode();
            // 7.判断是否登录成功
            // 返回为true:代表登录成功，否则返回false
            if(!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return false;
            }

            if(!ftp.changeWorkingDirectory(basePath +"/"+ filePath)){
                // 该目录不存在
                String[] filePathArray = filePath.split("/");
                tempPath = basePath;
                //10.循环分割后的数据
                // 13.创建该目录
                // 返回值为boolean类型，如果为true说明创建文件夹成功，如果为false则说明创建失败
                for(String dir :filePathArray){
                    // 第一次循环获取的数据是2019
                    // 第二次循环获取的数据是11
                    // 11.判断获取dir是否为null，或者是否为""
                    if("".equals(dir) || null == dir) {
                        continue;
                    }
                    // 12.再次判断2019这个目录是否存在
                    // 第二次判断需要判断2019/11是否存在
                    // home/ftp/www
                    // tempPath=/2019--->/home/ftp/www/2019
                    tempPath += "/" + dir;
                    if(!ftp.makeDirectory(tempPath)){
                        // 再次判断2019这个目录是否存在
                        // 13.创建该目录
                        // 返回值为boolean类型，如果为true说明创建文件夹成功，如果为false则说明创建失败
                        if(!ftp.makeDirectory(tempPath)) {
                            return false;
                        } else {
                            // 14.说明创建成功，再次判断该目录是否存在(double check)
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            // 15.开启以二进制流的形式上传(因为上传的速度会比普通的IO要快)
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 16.这里才是真正的上传,判断是否上传成功
            // 返回值为Boolean类型，true代表上传成功，false代表上传失败
            if(!ftp.storeFile(fileName, inputStream)) {
                return false;
            }
            // 17.关闭输入流
            inputStream.close();
            // 18.退出ftp用户
            ftp.logout();
        }catch ( IOException e){
            e.printStackTrace();
        }finally {
            if(ftp.isConnected()){
                // 断开连接
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }





}
