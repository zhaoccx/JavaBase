package com.zcc.test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileOuputTest {
	public static void main(String args[]) {

		byte[] c = new byte[20];
		FileInputStream d;
		try {
			d = new FileInputStream("D:\\456.txt");
			DataInputStream e = new DataInputStream(d);
			int m = e.read(c);
			while (m != -1) {
				for (int j = 0; j < 20; j++)
					System.out.print(" " + c[j]);
				m = e.read(c);
			}
			e.close();
			d.close();
		} catch (FileNotFoundException e1) {
			System.err.println("没有找到文件");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.err.println("读入数据流异常");
			e1.printStackTrace();
		}
	}
}
