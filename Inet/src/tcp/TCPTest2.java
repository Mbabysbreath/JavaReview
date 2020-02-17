package tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhaomin
 * @date 2020/2/14 11:44
 */

/**
 * 从客户端发出一张图片文件，服务器端接受并保存
 */
public class TCPTest2 {

    @Test
    public void socket() throws IOException {

        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);
        File file=new File("src\\1.jpg");
        FileInputStream fis=new FileInputStream(file);
        OutputStream os = socket.getOutputStream();
        byte[] buff=new byte[1024];
        int len;
        while((len=fis.read(buff))!=-1){
            os.write(buff,0,len);
        }
        os.close();
        fis.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {

        ServerSocket serverSocket=new ServerSocket(9090);
        Socket socket1 = serverSocket.accept();

        File file=new File("2.jpg");
        FileOutputStream fos=new FileOutputStream(file);
        InputStream is = socket1.getInputStream();

        byte[] buff=new byte[1024];
        int len;
        while ((len = is.read(buff)) != -1) {
            fos.write(buff,0,len);
        }

        fos.close();
        is.close();
        socket1.close();
        serverSocket.close();

    }
}
