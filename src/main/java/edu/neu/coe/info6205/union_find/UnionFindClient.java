package edu.neu.coe.info6205.union_find;
import java.util.Random;

public class UnionFindClient {
	public static int count(int n)
	{
		int ufcon = 0;
		UF_HWQUPC uf_hwqupc = new UF_HWQUPC(n);
		Random ran = new Random();
		while(uf_hwqupc.components()>1) 
		{
			int i = ran.nextInt(n);
			int j = ran.nextInt(n);
			uf_hwqupc.connect(i, j);
			ufcon++;
		}
		return ufcon;
	}
	
	public static void main(String[] args) {
		int n[] = new int[] {100,200,300,400,500,600,700,800,900,1000};
		int m = 100;
		for(int i = 0;i<n.length;i++)
		{
			double sum = 0;
			for(int j=0;j<m;j++) {
				int operation = count(n[i]);
				sum+=operation;
			}
			double average = sum/m;
			System.out.println("Integer value: "+n[i]+", number of sites: "+average+" expected value "+0.53 *n[i]*Math.log(n[i])+" ratio "+ average/(0.53*n[i]*Math.log(n[i])));
		}
	}

}
