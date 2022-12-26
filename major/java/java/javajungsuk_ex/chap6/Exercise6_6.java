public class Exercise6_6 {
    static double getDistance(int x, int y, int x1, int y1){

        return (Math.sqrt(x1-x)*Math.sqrt(y1-y))/2;
    }
    public static void main(String[] args) {
        System.out.println(getDistance(1,1,2,2));
    }
}

