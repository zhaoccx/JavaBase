/**
    ┏┓　　    ┏┓
┏┛┗━━━┛┗┓
┃　　　　　　　┃
┃　　　━　　　┃
┃　┳┛　┗┳　┃
┃　　　　　　　┃
┃　　　┻　　　┃
┃　　　　　　　┃
┗━┓　　　┏━┛
          ┃　　　┃   神兽保佑
          ┃　　　┃   代码无BUG！
          ┃　　　┗━━━┓
          ┃　　　　　　　┗┓
          ┃　　　　　　　┏┛
          ┗┓┓┏━┳┓┏┛
              ┃┫┫    ┃┫┫
              ┗┻┛　┗┻┛ 
 */
package com.zcc.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author Andy
 */
public class IvoCodeFind {
	public List<String> getListFormReplace(List<String> listinit, String source) {
		if (listinit == null || listinit.size() <= 0) {
			return null;
		}
		List<String> listSet = new ArrayList<String>();

		String[] se = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

		for (String string : listinit) {
			String temp = "";
			for (int i = 0; i < se.length; i++) {
				temp = new String(string);
				listSet.add(temp.replace(source, se[i]));
			}
		}
		return listinit;
	}

	public List<String> getListFromStringChange(String source, String split) {

		return null;
	}

	/**
	 * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现全排列
	 *
	 * @param datas
	 * @param target
	 */
	private List<String> sort(List<String> datas, List<String> target, int NUM, Vector<String> targets) {

		if (target.size() == NUM) {
			String temp = "";
			for (Object obj : target) {
				System.out.print(obj);
				temp += obj;
			}
			boolean flag = true;
			for (int index = 0; index < targets.size(); index++) {
				if (temp.equals(targets.get(index))) {
					flag = false;
					break;
				}
			}
			if (flag) {
				targets.add(temp);
			}
			System.out.println();
			System.out.println();
		}
		for (int i = 0; i < datas.size(); i++) {
			List<String> newDatas = new ArrayList<String>(datas);
			List<String> newTarget = new ArrayList<String>(target);
			newTarget.add(newDatas.get(i));
			newDatas.remove(i);
			sort(newDatas, newTarget, NUM, targets);
		}
		return targets;
	}

	public static void main(String[] args) {
		String[] datas = "8621 618c a587 228f".split(" ");
		System.out.println(datas);
		List<String> list = new IvoCodeFind().sort(Arrays.asList(datas), new ArrayList<String>(), 4, new Vector<String>());
		System.out.println(list);
		System.out.println(list.size());
	}

}
