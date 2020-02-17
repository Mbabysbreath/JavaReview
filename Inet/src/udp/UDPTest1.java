package udp;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author zhaomin
 * @date 2020/2/14 17:44
 */
public class UDPTest1 {

    //发送方
    @Test
    public void sender() throws IOException {
        DatagramSocket socket=new DatagramSocket();

            String str="我是发送方";
            byte[] bytes=str.getBytes();
        InetAddress ip=InetAddress.getLocalHost();
        //发送方可以指明接收方的地址和端口号
       DatagramPacket packet=new DatagramPacket(bytes,0,bytes.length,ip,9090);

       socket.send(packet);
       socket.close();
    }

    //接收方
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] bytes = new byte[100];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}
