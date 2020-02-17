package tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/2/13 23:31
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务器端，服务端接受并输出到控制台
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client(){
        Socket socket= null;
        OutputStream ops= null;
        try {
            //1.创建客户端的socket对象,指明服务器端的ip和端口号
            InetAddress ip1 = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ip1,8899);
            //2.获取输出流
            ops = socket.getOutputStream();
            //3.操作数据

            ops.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            if (ops != null) {
                try {
                    ops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //服务器端
    @Test
    public void server(){

        ServerSocket serverSocket= null;
        InputStream is = null;
        Socket socket=null;
        ByteArrayOutputStream bos = null;

      //  FileInputStream fis=null;
        try {
            //1.创建一个服务器端的socket对象，并指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2.accept(),表示接受来自客户端的socket
            socket = serverSocket.accept();

            //3.获取输入流，读取数据
            is=socket.getInputStream();
            //4.操作数据
            //不建议这样写
//        byte[] bytes=new byte[1024];
//        int len;
//        while((len=is.read(bytes))!=-1){
//            String str=new String(bytes,0,len);
//            System.out.println(str);
//        }
            bos = new ByteArrayOutputStream();
            byte[] bytes=new byte[5];
            int len;
            while((len=is.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            System.out.println(bos.toString());
            System.out.println("收到"+socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
