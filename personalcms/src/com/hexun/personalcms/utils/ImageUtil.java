package com.hexun.personalcms.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
/**
 * 图片压缩
 * @author zhoudong
 *
 */
public class ImageUtil {

	/**
	 * 压缩系数常量：长宽尺寸以400px为基准
	 */
	private static final int DIMISION = 400;

	/**
	 * 图标大小的缩略图尺寸
	 */
	private static final int ICON_WIDTH = 450;
	private static final int ICON_HEIGHT = 450;

	/**
	 * @title 指定尺寸压缩图片
	 */
	private static void generateImg(String imgSource, String imgTarget, int widthdist, int heightdist) {
		try {
			File srcfile = new File(imgSource);
			Image src = ImageIO.read(srcfile);
			BufferedImage tag = new BufferedImage(widthdist, heightdist, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);
			FileOutputStream out = new FileOutputStream(imgTarget);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @title 添加图片时自动等比压缩缩略图
	 * @describe 压缩后尺寸大概为200px左右
	 */
	public static Integer[] generateSmallImg(String imgSource, String imgTarget) {
		try {
			File srcfile = new File(imgSource);
			if (!srcfile.exists()) {
				return new Integer[] { 0, 0 };
			}
			Image src = ImageIO.read(srcfile);
			int imgWidth = src.getWidth(null);
			int imgHeight = src.getHeight(null);
			// 1、得到合适的压缩大小，按比例。
			if(imgWidth > 700 || imgHeight > 700){
				if (imgWidth >= imgHeight) {
					// 1.1、如果是宽图
					imgHeight = Math.round(imgHeight * DIMISION / imgWidth);
					imgWidth = DIMISION;
				} else {
					// 1.2、如果是长图
					imgWidth = Math.round(imgWidth * DIMISION / imgHeight);
					imgHeight = DIMISION;
				}
			}
			// 计算压缩后大小
			int newWidth = imgWidth;
			int newHeight = imgHeight;
			generateImg(imgSource, imgTarget, newWidth, newHeight);
			return new Integer[] { newWidth, newHeight };
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return new Integer[] { 0, 0 };
	}

	/**
	 * @title 压缩成图标大小
	 * @describe 压缩后的尺寸为(54 x 54)
	 */
	public static void generateIconImg(String imgSource, String imgTarget) {
		generateImg(imgSource, imgTarget, ICON_WIDTH, ICON_HEIGHT);
	}

	public static void main(String[] args) {
		generateSmallImg("C:/Documents and Settings/Administrator/My Documents/My Pictures/test2.jpg", "c:/output/123.png");
	}
	
	/// 
	/** 
	  * byte数组转换成16进制字符串 
	  * @param src 
	  * @return 
	  */  
	 public static String bytesToHexString(byte[] src){      
	        StringBuilder stringBuilder = new StringBuilder();      
	        if (src == null || src.length <= 0) {      
	            return null;      
	        }      
	        for (int i = 0; i < src.length; i++) {      
	            int v = src[i] & 0xFF;      
	            String hv = Integer.toHexString(v);      
	            if (hv.length() < 2) {      
	                stringBuilder.append(0);      
	            }      
	            stringBuilder.append(hv);      
	        }      
	        return stringBuilder.toString();      
	    }  
	   
	 /** 
	  * 根据文件流读取图片文件真实类型 
	  * @param is 
	  * @return 
	  */  
	 public static String getTypeByStream(File file){  
		 FileInputStream is = null;
		 String type = null;
		try {
			is = new FileInputStream(file);
			 byte[] b = new byte[4];   
		    is.read(b, 0, b.length);  
	        type = bytesToHexString(b).toUpperCase();  
	        if(type.startsWith("FFD8FF")){  
	         return "jpg";  
	        }else if(type.startsWith("89504E47")){  
	         return "png";  
	        }else if(type.startsWith("47494638")){  
	         return "gif";  
	        }else if(type.startsWith("49492A00")){  
	         return "tif";  
	        }else if(type.startsWith("424D")){  
	         return "bmp";  
	        }  
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			IOUtils.closeQuietly(is);
		}
		
		return type;
	 }
}