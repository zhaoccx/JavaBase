package cn.itcast.day2;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyClassLoader extends ClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String srcPath = args[0];
		String destDir = args[1];
		FileInputStream fis = new FileInputStream(srcPath);
		String destFileName = srcPath.substring(srcPath.lastIndexOf('\\') + 1);
		String destPath = destDir + "\\" + destFileName;
		FileOutputStream fos = new FileOutputStream(destPath);
		cypher(fis, fos);
		fis.close();
		fos.close();
	}

	private static void cypher(InputStream ips, OutputStream ops) throws Exception {
		int b = -1;
		while ((b = ips.read()) != -1) {
			ops.write(b ^ 0xff);
		}
	}

	private String classDir;

	@SuppressWarnings("deprecation")
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classFileName = classDir + "\\" + name.substring(name.lastIndexOf('.') + 1) + ".class";
		try {
			FileInputStream fis = new FileInputStream(classFileName);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			cypher(fis, bos);
			fis.close();
			System.out.println("aaa");
			byte[] bytes = bos.toByteArray();
			return defineClass(bytes, 0, bytes.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public MyClassLoader() {

	}

	public MyClassLoader(String classDir) {
		this.classDir = classDir;
	}
}
