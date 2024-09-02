public class erfenfa {

    //找到返回下标，没找到返回-1
    public static int erfen(int[] a, int target){
        int i = 0, j = a.length - 1;
        while(i <= j){
            int m = (i + j) / 2;
            if(target < a[m]){
                j = m - 1;
            } else if(target > a[m]){
                i = m + 1;
            }else{
                return m;
            }
        }
        return -1;
    }

    //如果数组中有相同的值，那么返回最左侧该值的索引
    public static int erfenLeftmost(int[] a, int target){
        int i = 0, j = a.length - 1;
        int candidate = -1; //候选值的索引，找到与目标值相同的值之后，先不急，把下标给候选值，看看左边还有没有目标值。
        while (i <= j){
            int m = (i + j) >>> 1;
            if (target < a[m]){
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            }else {
                candidate = m; //找到目标值先别急着return，先把下标给候选值，然后继续向左查找。
                j = m - 1;  //如果要找最右边目标值的下标，只需要把这一句改为 i = m + 1;
            }
        }
        return candidate; //没找到返回-1，找到就返回candidate
    }

    public static void main(String[] args) {
        int[] a = {5, 8, 10, 12, 15, 25, 36};
        int b = 5;
        System.out.println(erfen(a, b));

        int[] a2 = {1, 4, 4, 4, 4, 6, 9, 10};
        int b2 = 4;
        System.out.println(erfenLeftmost(a2, b2));
    }
}
