package jvm.image;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: laizc
 * @date: 2026/3/19
 * @desc: 读取图片导致内存溢出
 */
public class ThumbnaiImage {

    //1m
    String _1MB_URL = "https://unify-test-meeting-1321732912.cos.ap-guangzhou.myqcloud.com/202603191112163858563.jpg";

    //10m
    String _10MB_URL = "https://unify-test-meeting-1321732912.cos.ap-guangzhou.myqcloud.com/202603191113538681533.jpg";

    //30m
    String _30MB_URL = "https://unify-test-meeting-1321732912.cos.ap-guangzhou.myqcloud.com/202603191131519767146.jpg";

    /**
     *  jvm 内存限制一个图片的大小，导致内存溢出
     * -Xms512m -Xmx768m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./heapdump.hprof
     *
     *
     */

    @Test
    public void readImage() throws IOException {
        List<BufferedImage> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            BufferedImage img = Thumbnails.of(new URL(_30MB_URL))
                    .scale(1.0)
                    .asBufferedImage();
            list.add(img);
            System.out.println(i);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                ImageIO.write(img, "jpg", os);
            } catch (IOException e) {
                System.out.println("图片过大，无法写入内存");
                continue;
            }
            ByteArrayInputStream inputStream = new ByteArrayInputStream(os.toByteArray());
            System.out.println("正常处理第" + i + "张图片");
        }
    }


}
