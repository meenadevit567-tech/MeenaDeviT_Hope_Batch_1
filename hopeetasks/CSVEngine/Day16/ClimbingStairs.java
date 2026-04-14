package Day16;
class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int n1=1;
        int n2=2;
        int n3=n1+n2;
        while(n>2){
            n3=n1+n2;
            n1=n2;
            n2=n3;
            n--;
        }
        return n3;
    }
}