package tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送图片个服务器端，服务器端接受并保存，
 * 再给客户端回复
 * @author zhaomin
 * @date 2020/2/14 16:00
 */
public class TCPTest3 {
    @Test
    public void client() throws IOException {
        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);
        File file=new File("src\\1.jpg");
        FileInputStream fis=new FileInputStream(file);
        OutputStream os = socket.getOutputStream();
        byte[] buff=new byte[1024];
        int len;
        while((len=fis.read(buff))!=-1){
            os.write(buff);
        }
        //read()方法是一个阻塞式方法
        //关闭数据的输出
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        byte[] bytes=new byte[20];
        int len1;
        while((len1=is.read(bytes))!=-1){
            bos.write(bytes,0,len1);
        }
        System.out.println(bos.toString());
        os.close();
        fis.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket=new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        File file=new File("3.jpg");
        FileOutputStream fos=new FileOutputStream(file);
        byte[] buff=new byte[1024];
        int len;
        while ((len = is.read(buff)) != -1) {
            fos.write(buff,0,len);
        }

        OutputStream os = socket.getOutputStream();
        os.write("照片已经接收到了".getBytes());

        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
