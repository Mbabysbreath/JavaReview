package url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zhaomin
 * @date 2020/2/14 21:32
 */
public class URLTest2 {

    public static void main(String[] args) {
        HttpURLConnection urlConnection = null;
        InputStream is= null;
        FileOutputStream fos= null;
        try {
            URL url = new URL("http://localhost:8080/examples/index.html");
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("index2.html");
            byte[] bytes=new byte[20];
            int len;
            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if(is!=null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(urlConnection!=null)
            urlConnection.disconnect();
        }

    }
}
