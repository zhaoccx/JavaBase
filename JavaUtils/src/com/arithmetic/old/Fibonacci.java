/**
 * Fibonacci为1200年代的欧洲数学家，在他的著 ​​作中曾经提到：
 * 「若有一只免子每个月生一只小免子，一个月后小免子也开始生产。
 * 起初只有一只免子，一个月后就有两只免子，二个月后有三只免子，三个月后有五只免子（小免子投入生产）......」。
 *  如果不太理解这个例子的话，举个图就知道了，注意新生的小免子需一个月成长期才会投入生产，
 *  类似的道理也可以用于植物的生长，这就是Fibonacci数列，一般习惯称之为费氏数列，
 *  例如以下： 1、1 、2、3、5、8、13、21、34、55、89...... 

 */
package com.arithmetic.old;

/**
 * @author zhaocc 如果免子不只生一只小免子的话怎么办？像这种问题，我们可以将费氏数列加以扩充，称之为扩充费氏数列： fn = X * fn-1
 *         + Y * fn-2 if n > 1 fn = 1 if n = 0, 1 当X、Y等于1时，自然就是一般的费氏数列了。
 */
public class Fibonacci {
	public static void main(String[] args) {
		int[] fib = new int[20];

		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i < fib.length; i++)
			fib[i] = fib[i - 1] + fib[i - 2];

		for (int i = 0; i < fib.length; i++)
			System.out.print(fib[i] + " ");
		System.out.println();
	}
}
