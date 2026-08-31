import java.util.*;
public class Solution{
    public static int GCD(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return GCD(b,a%b);
    }
    public static int minOperations(int[]nums,int[]numsdivide)
    {
        Arrays.sort(nums);
        int g=numsdivide[0];
        for(int i=1;i<numsdivide.length;i++)
        {
            g=GCD(g,numsdivide[i]);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(g%nums[i]==0)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size1=sc.nextInt();
        int[] nums=new int[size1];
        for(int i=0;i<size1;i++)
        {
            nums[i]=sc.nextInt();
        }
        int size2=sc.nextInt();
        int[] numsdivide=new int[size2];
        for(int i=0;i<size2;i++)
        {
            numsdivide[i]=sc.nextInt();
        }
        System.out.print(minOperations(nums,numsdivide));
    }
}