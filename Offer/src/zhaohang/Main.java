package zhaohang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
            }
            System.out.println(minD(a,b));
        }
    }
    /* * 求最小代价 */
    public static int minD(int[] arr,int[] arr2){
        Map<Integer,List<Integer>> mp=new HashMap<Integer,List<Integer>>();
        for(int i=0;i<arr.length;i++){
            if(!mp.containsKey(arr[i])){
                List<Integer> lst=new ArrayList<Integer>();
                mp.put(arr[i], lst);
            }
            mp.get(arr[i]).add(i);
        }
        Iterator<Integer> it = mp.keySet().iterator();
        int arr3[]=new int[mp.keySet().size()];
        int tmp0=0;
        while(it.hasNext()){
            arr3[tmp0++]=it.next();
        }
        shellsort(arr3);
        int[] sum=new int[arr3.length];
        int all=0;
        for(int i=0;i<arr.length;i++){
            all+=arr2[i];
        }
        List<Integer> lst=new ArrayList<Integer>();
        for(int j=arr3.length-1;j>=0;j--){
            List<Integer> list=mp.get(arr3[j]);
            int[] arr5=new int[arr2.length-lst.size()];
            int j_sum=0;
            for(int k=0;k<list.size();k++){
                j_sum+=arr2[list.get(k)];
                lst.add(list.get(k));
            }
            int tmp=0;
            for(int k=0;k<arr2.length;k++){
                if(!lst.contains(k)) arr5[tmp++]=arr2[k];
            }
            int other=0;
            if(arr5.length>list.size()-1)
                other= shellToSum(arr5,list.size()-1);
            sum[j]=all-j_sum-other;
        }
        return min(sum);
    }
    public static void shellsort( int[] arr3 ) {
        int j;
        for( int gap = arr3.length / 2; gap > 0; gap /= 2 ) {
            for( int i = gap; i < arr3.length; i++ ) {
                Integer tmp = arr3[i];
                for (j = i; j >= gap && tmp.compareTo(arr3[j - gap]) < 0; j -= gap)
                    arr3[j] = arr3[j - gap];
                arr3[j] = tmp;
            }
        }
    }

    public static int shellToSum(int[] a,int size){
        int[] b=a;
        shellsort(a);
        int sum=0;
        for(int i=0;i<size;i++){
            sum+=b[b.length-1-i];
        }
        return sum;
    }
    public static int min(int[] a){
        int[] b=a;
        shellsort(b);
        return b[0];
    }
}