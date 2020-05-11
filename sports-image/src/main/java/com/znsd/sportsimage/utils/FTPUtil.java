package com.znsd.sportsimage.utils;

import java.io.*;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;

public class FTPUtil {

    private static Logger log = Logger.getLogger("FTPUtil.class");

    private String host;
    private int port;
    private String username;
    private String password;

    public FTPUtil(String host, String port, String username, String password) {
        this.host = host;
        this.port = Integer.parseInt(port);
        this.username = username;
        this.password = password;
    }

    public File downloadFile(String remotePath, String remoteFileName, String localPath, String localFileName) {
        FTPClient ftpClient = new FTPClient();
        FileOutputStream outputStream = null;
        File file = null;
        try {
            log.info(">>>>>>>>FTP-->downloadFile--登录开始>>>>>>>>>>>>>");

            ftpClient.connect(host, port);
            //设置ftp连接模式 被动模式
            ftpClient.enterLocalPassiveMode();

            boolean login = ftpClient.login(username, password);

            if (login) {
                log.info(">>>>>>>>FTP-->downloadFile--登录成功>>>>>>>>>>>>>");
            } else {
                log.info(">>>>>>>>FTP-->downloadFile--登录失败>>>>>>>>>>>>>");
                throw new RuntimeException("FTP登陆失败,请检查用户信息！");
            }

            boolean isDownload = false;

            file = new File(localPath + localFileName);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            //切换文件路径
            ftpClient.makeDirectory(remotePath);
            ftpClient.changeWorkingDirectory(remotePath);

            FTPFile[] ftpFiles = ftpClient.listFiles();
            for (FTPFile ftpFile : ftpFiles) {
                if (ftpFile.getName().equals(remoteFileName)) {
                    outputStream = new FileOutputStream(file);
                    isDownload = ftpClient.retrieveFile(ftpFile.getName(), outputStream);
                }
            }

            if (isDownload) {
                log.info(">>>>>>>>FTP-->downloadFile--文件下载成功！本地路径：" + file);
            } else {
                throw new RuntimeException("FTP-->downloadFile--文件下载失败！请检查！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public void uploadFile(String remotePath, String remoteFileName, String localPath, String localFileName) {
        FTPClient ftpClient = new FTPClient();
        FileInputStream inputStream = null;
        log.info(">>>>>>>>FTP-->uploadFile--登录开始>>>>>>>>>>>>>");

        ftpClient.enterLocalPassiveMode();//设置成被动FTP模式
        try {
            boolean login = ftpClient.login(username, password);
            if (login) {
                log.info(">>>>>>>>FTP-->uploadFile--登录成功>>>>>>>>>>>>>");
            } else {
                log.info(">>>>>>>>FTP-->uploadFile--登录失败>>>>>>>>>>>>>");
                throw new RuntimeException("FTP登陆失败,请检查用户信息！");
            }

            //切换文件路径
            ftpClient.makeDirectory(remotePath);
            ftpClient.changeWorkingDirectory(remotePath);
            inputStream = new FileInputStream(new File(localPath + localFileName));
            //可上传多文件
            boolean isUpload = ftpClient.storeFile(remoteFileName, inputStream);

            if (isUpload) {
                log.info(">>>>>>>>FTP-->uploadFile--文件上传成功!");
            } else {
                log.info(">>>>>>>>FTP-->uploadFile--文件上传失败!");
                throw new RuntimeException("文件上传失败!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void uploadFile(String remotePath, String remoteFileName, InputStream inputStream) {
        FTPClient ftpClient = new FTPClient();
        System.out.println(">>>>>>>>FTP-->uploadFile--登录开始>>>>>>>>>>>>>");

        ftpClient.enterLocalPassiveMode();//设置成被动FTP模式
        try {
            ftpClient.connect(host, port);
            boolean login = ftpClient.login(username, password);
            if (login) {
                System.out.println(">>>>>>>>FTP-->uploadFile--登录成功>>>>>>>>>>>>>");
            } else {
                System.out.println(">>>>>>>>FTP-->uploadFile--登录失败>>>>>>>>>>>>>");
                throw new RuntimeException("FTP登陆失败,请检查用户信息！");
            }

            //切换文件路径
            ftpClient.makeDirectory(remotePath);
            ftpClient.changeWorkingDirectory(remotePath);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            //可上传多文件
            boolean isUpload = ftpClient.storeFile(remoteFileName, inputStream);
            ftpClient.setControlEncoding("utf8");
            ftpClient.setAutodetectUTF8(true);
            if (isUpload) {
                System.out.println(">>>>>>>>FTP-->uploadFile--文件上传成功!");
            } else {
                System.out.println(">>>>>>>>FTP-->uploadFile--文件上传失败!");
                throw new RuntimeException("文件上传失败!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}