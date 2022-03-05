package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;

public class Test {
    public static void main(String[] args) {
        for (int i = 1000; i <= 64000; i = i * 2) {
            Helper<Integer> helper = new BaseHelper<>("InsertionSort", i,null);
            helper.init(i);
            SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
            int finalI = i;
            Integer[] xs = helper.random(Integer.class, r -> r.nextInt(finalI));
            Benchmark<Boolean> bm = new Benchmark_Timer<>(
                    "InsertionSortBenchmark",null, b -> sorter.sort(xs),null);
            double x = bm.run(true, 10);
            System.out.println("The time cost for sorting " + i + " integers is: " + x);
        }
    }
}
