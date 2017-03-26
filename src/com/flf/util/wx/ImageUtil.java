package com.flf.util.wx;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/***
 * 图片工具
 * @author joie
 *2015.9.17
 */
public class ImageUtil {
	/***
	 * 保存图片，按尺寸压缩
	 * @param inputBufferedImage 输入图片
	 * @param name 图片名字
	 * @param imgPath 图片路径
	 * @param height 压缩高度
	 * @param width 压缩宽度
	 * @param imgExt 图片后缀
	 */
	public static void saveImage(BufferedImage inputBufferedImage, String name, String imgPath,
			int height, int width,String imgExt) { 

		
			try {
				BufferedImage inputbig = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_BGR);
				Graphics2D g = (Graphics2D) inputbig.getGraphics();
				g.drawImage(inputBufferedImage, 0, 0, width, height, null); 
				g.dispose();
				inputbig.flush();

				File file2 = new File(imgPath); 
				if (file2.exists()) {
					System.out.println("图片已存在");
				} else {
				
					file2.mkdirs();
				}

				ImageIO.write(inputbig, imgExt, new File(imgPath + name + "."+imgExt));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}

}