package com.lee.learn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputStreamBufferLearn {

	public static void main(String args[]) throws Exception {
		// 先向文件中写入数据，以便下面进行读取
		File f1 = new File("e:" + File.separator + "test.doc");
		OutputStream out = new FileOutputStream(f1, true);
		String message2 = "rn浙江师范大学行知学院";
		byte[] b2 = message2.getBytes();
		for (int i = 0; i < b2.length; i++) {
			out.write(b2[i]);
		}
		out.close();// 数据写入完成，关闭输出流。
		// 下面开始从文件中读取数据
		InputStream in = new FileInputStream(f1);
		byte[] b = new byte[1024];// 开辟了1024个字节的内存空间，不足就用空格补足
		in.read(b);
		System.out.println("读取内容如下：" + new String(b));
		in.close();
		
		test2();
		test3();
		test4();
	}

	/*
	 * 因为开辟了1024字节的内存空间，但是写入的数据量显然没有1024字节。因此要是将这个1024大小的字节数组重新构建成字符串，
	 * 这个字符串的长度或者说大小也将是1024字节。那么其中的多余字节就是由空格占位形成的。 运行效果如下：
	 * 
	 * 显然我们并不希望看到这样的结果。那么如何解决？ 修改如下：
	 */

	public static void test2() throws Exception {
		File f1 = new File("e:" + File.separator + "test.doc");
		OutputStream out = new FileOutputStream(f1, true);
		String message2 = "rn浙江师范大学行知学院";
		byte[] b2 = message2.getBytes();
		for (int i = 0; i < b2.length; i++) {
			out.write(b2[i]);
		}
		out.close();
		InputStream in = new FileInputStream(f1);
		byte[] b = new byte[1024];// 开辟1024空间大小的内存空间
		int len = in.read(b);// len存储着返回读入缓冲区的字节总数
		System.out.println("读取内容的字节总数:" + len);
		// 根据字节数组，构造从0开始的长度为len的新字符串
		System.out.println("读取内容如下：" + new String(b, 0, len));
		in.close();
	}

	/*
	 * 因为在重新构造字符串时是依据实际读取的字节大小构建的，因此新的字符串将不会有空格占位的情况。
	 * 上面的程序虽然解决了部分的问题，但在构建字节数组用于存储读取内容是开辟的内存空间是固定不变的，这样的设计极不合理。
	 * 因为假如需要读取的数据量大于1024字节，这样1024字节之后的数据将无法读取。那么能不能按照文件大小构建字节数组呢？能！ 实例3：
	 */
	public static void test3() throws Exception {
		File f1 = new File("e:" + File.separator + "test.doc");
		OutputStream out = new FileOutputStream(f1, true);
		String message2 = "rn浙江师范大学行知学院";
		byte[] b2 = message2.getBytes();
		for (int i = 0; i < b2.length; i++) {
			out.write(b2[i]);
		}
		out.close();
		InputStream in = new FileInputStream(f1);
		byte[] b = new byte[(int) f1.length()];// 根据文件大小给字节数组分配内存空间
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) in.read();// 每次只读取1个字节
		}
		System.out.println("读取内容如下：" + new String(b));
		in.close();
	}

	/*
	 * 这样的修改就能使内存资源得到最大限度的利用。 下面使用另一种读取数据的方式。 实例4：
	 */
	public static void test4() throws Exception {
		File f1          = new File("e:" + File.separator + "test.doc");
		OutputStream out = new FileOutputStream(f1, true);
		String message2  = "rn浙江师范大学行知学院";
		byte[] b2 = message2.getBytes();
		for (int i = 0; i < b2.length; i++) {
			out.write(b2[i]);
		}
		out.close();
		InputStream in = new FileInputStream(f1);
		byte[] b       = new byte[(int) f1.length()];/*实际意义并不大，只限于file的流，对于网络流不合适，无法取到length*/
		int index      = 0;
		int temp       = 0;
		while ((temp = in.read()) != -1) {// 表示没有读取到文件末尾。
			b[index] = (byte) temp;
			index++;
		}
		System.out.println("读取的文件内容：" + new String(b));
		in.close();// 资源类操作的结尾一定要关闭。
	}
	
}