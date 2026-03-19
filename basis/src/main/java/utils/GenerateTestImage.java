package utils;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

/**
 * @author: laizc
 * @date: 2026/3/19
 * @desc:
 */
public class GenerateTestImage {

    public static void main(String[] args) throws Exception {
        // 生成指定大小的jpg图片，只生成一次,后续生成再放开
        /*createJpgWithTargetSize("test_1m.jpg", 1 * 1024 * 1024);
        createJpgWithTargetSize("test_10m.jpg", 10 * 1024 * 1024);
        createJpgWithTargetSize("test_30m.jpg", 30 * 1024 * 1024);*/

        //1m
        //https://unify-test-meeting-1321732912.cos.ap-guangzhou.myqcloud.com/202603191112163858563.jpg

        //10m
        //https://unify-test-meeting-1321732912.cos.ap-guangzhou.myqcloud.com/202603191113538681533.jpg

        //30m
        //https://unify-test-meeting-1321732912.cos.ap-guangzhou.myqcloud.com/202603191131519767146.jpg

    }

    public static void createJpgWithTargetSize(String outputPath, long targetBytes) throws Exception {
        int width = 2000;
        int height = 2000;

        BufferedImage image;
        byte[] data;

        while (true) {
            image = createRandomImage(width, height);
            data = compressJpg(image, 1.0f);

            if (data.length >= targetBytes * 0.9) {
                break;
            }

            width += 500;
            height += 500;
        }

        float low = 0.1f;
        float high = 1.0f;
        byte[] best = data;

        for (int i = 0; i < 20; i++) {
            float mid = (low + high) / 2;
            byte[] temp = compressJpg(image, mid);

            if (Math.abs(temp.length - targetBytes) < Math.abs(best.length - targetBytes)) {
                best = temp;
            }

            if (temp.length > targetBytes) {
                high = mid;
            } else {
                low = mid;
            }
        }

        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(best);
        }

        System.out.println(outputPath + " => " + best.length + " bytes");
    }

    private static BufferedImage createRandomImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Random random = new Random();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = random.nextInt(256);
                int g = random.nextInt(256);
                int b = random.nextInt(256);
                int rgb = (r << 16) | (g << 8) | b;
                image.setRGB(x, y, rgb);
            }
        }
        return image;
    }

    private static byte[] compressJpg(BufferedImage image, float quality) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        if (!writers.hasNext()) {
            throw new IllegalStateException("No JPG writer found");
        }

        ImageWriter writer = writers.next();
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);

        try (ImageOutputStream ios = ImageIO.createImageOutputStream(baos)) {
            writer.setOutput(ios);
            writer.write(null, new IIOImage(image, null, null), param);
        } finally {
            writer.dispose();
        }

        return baos.toByteArray();
    }
}
