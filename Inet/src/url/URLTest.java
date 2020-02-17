package url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zhaomin
 * @date 2020/2/14 18:27
 * 1.URL:统一资源定位符，表示Internet某个资源的地址
   2.基本结构：
     http://localhost:8080/example/woo.jpg#
    传输协议：//主机名：端口号/文件名(资源地址)#片段名？参数列表
    http://192.168.43.1:8080/index/hello.jsp#a?username=zm&password=123
    #片段名：错点，例如：看小说直接定位到某个章节
    参数列表格式：参数名=参数值&参数名=参数值。。。
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url=new URL("http://localhost:8080/examples/beauty.jpg?username=zm");
            /*常见的URL的方法*/

            //public String getProtocal()--获取URL的协议名
            System.out.println(url.getProtocol());
            //public String getHost()--获取URL的主机名
            System.out.println(url.getHost());
            //public String getPort()--获取URL的端口号
            System.out.println(url.getPort());
            //public String getPath()--获取文件路径
            System.out.println(url.getPath());
            //public String getFile()--获取URL的文件名
            System.out.println(url.getFile());
            //public String getQuery()--获取URL的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
