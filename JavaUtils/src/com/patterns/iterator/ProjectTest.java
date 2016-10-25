package com.patterns.iterator;

/**
 *
 * @author zhaocc
 * @time 2016年10月25日 下午3:27:52
 */
public class ProjectTest {
	public static void main(String[] args) {
		IProject project = new Project();

		project.add("xxx", 5, 10000);
		project.add("yyy", 10, 10000);
		project.add("zzz", 15, 10000);
		for (int i = 4; i < 104; i++) {
			project.add("项目" + i, i * 5, i * 10000);
		}

		IProjectIterator iterator = project.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getProjectInfo());
		}
	}
}
