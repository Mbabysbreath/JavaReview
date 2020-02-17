package tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhaomin
 * @date 2020/2/13 21:37
 * 一、网络编程主要的两个问题：
（1）要怎样准确的定位网络中的一台或多台主机，定位主机上特定的应用
（2）找到主机后如何高效可靠的传输数据
   二、网络编程的两个要素
    1.通信双方的地址
    (1)IP
   （2）端口号
   2.一定的规则（网络通信协议）---有两套参考模型
   （1）OSI参考模型--理想--不能推广
   （2）TCP/IP参考模型（TCP/IP协议）--国际标准
       应用层、传输层、网络层、物理+数据链路层


    三、通信要素一：IP和端口
     1.IP:唯一标识Internet上的计算机（通信实体）
     2.在java中使用InetAddress类来代表IP
     3.IP的两种分类方式：
    （1）IPv4和IPv6
    (2)万维网（广域网）和局域网
     4.域名：www.baidu.com
           本机回路地址：127.0.0.1----localhost
     5.如何实例化：
        （1）Inetaddress.getByName("IP地址、域名");
         (2)InetAddress.getLocalHost();
 -------两个常用方法：getHostName()/getHostAddress()

1.端口号： 0--65535 16位的整数
唯一标识计算机中的进程
正在计算上允许的程序
要求：不同的进程要有不同的端口号
2.端口的分类：
公认端口：0~1023：被预先定义的服务器通信占用:  HTTP--80  FTP--21 TeInet--23
注册端口：1024~49151：分配给用户应用进程或应用程序：Tomcat--8080 ; MySQL--3306
动态/私有端口：49151~65535
3.端口号+IP--构成网络套接字Socket：

 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            //获取实例对象ip1--IP3都可以进行对本机ip的获取
            InetAddress ip1 = InetAddress.getByName("127.0.0.1");
            InetAddress ip2 = InetAddress.getByName("localhost");
            InetAddress ip3 = InetAddress.getLocalHost();
            InetAddress ip4 = InetAddress.getByName("www.baidu.com");
            System.out.println(ip1);
            System.out.println(ip2);
            System.out.println(ip3);
            System.out.println(ip4);
            //获取域名和IP地址
            String s1 = ip4.getHostName();
            String s2=ip4.getHostAddress();
            System.out.println(s1);
            System.out.println(s2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
