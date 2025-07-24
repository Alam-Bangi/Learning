class Main {
    public static void main(String[] args) {
        int printCubeUptoLimit;
        int limit = 90;
        
        int i = 1;
        while(i*i*i<limit) {
            System.out.print(i*i*i +" ");
            i++;
        }
    }
}