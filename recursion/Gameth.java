// given a set of coins we have to gain maximum value , we can choose coin from either end(not from in between)

class Gameth{
    public static void main(String[] args) {
        int a[] ={1,2,3,5,200,6};
        System.out.println(
            coinMax(a,0,a.length-1)
        );
    }
    static int coinMax(int[] a,int l,int r){
        //base only 2 coins left so we choose the max one
        if(l+1==r){
            return Math.max(a[l],a[r]);
        }
        /*
        we choose max and we get min left by the other
        choosing from either side l,r leaving the rest for the other to choose after he selects the coin from eother end
        we will be getting the min of rest */
        return Math.max(
            a[l]+Math.min(coinMax(a,l+2,r),coinMax(a,l+1,r-1)),
            a[r]+Math.min(coinMax(a,l+1,r-1),coinMax(a,l,r-2))
        );
    }
}