package com.wk;

/**
 * Created by wangkang04 on 2018/11/16
 **/
public class LCS {

	public static void lcs(int[] a,int[] b){
		int[][] c = new int[a.length][b.length];
		int min = a.length > b.length ? b.length : a.length;
		int[] r = new int[min];
		int index = 0;
		c[0][0] = a[0] == b[0] ? 1 : 0;
		if (a[0] == b[0]){
			r[index++] = a[0];
		}
		for (int i=1 ;i < a.length ;i++){
			for (int j=1;j < b.length;j++){
				if (a[i] == b[j]){
					c[i][j] = c[i-1][j-1] + 1;
					r[index++] = a[i];
				}else if (c[i-1][j] >= c[i][j-1]){
					c[i][j] = c[i-1][j];
				}else {
					c[i][j] = c[i][j-1];
				}
			}

		}

		for (int i=0;i<a.length;i++){
			for (int j=0;j<b.length;j++){
				System.out.print(c[i][j] + ",");
			}
			System.out.println();
		}

		System.out.println();

		for (int i=0;i<r.length;i++){
			System.out.print(r[i] + ",");
		}
	}

	public static void main(String[] args) {
		int[] a = {2,4,1,5,8};
		int[] b = {4,1,6,2,7,8};
		lcs(a,b);
		System.exit(0);
	}
}
