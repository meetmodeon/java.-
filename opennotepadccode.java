public class ExecDemo {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();
        Process p=null;
        int i=1;
        try{
            while(i!=5){
                p=r.exec("notepad");
                i++;
            }
        }catch (Exception e){
            System.out.println("Error executing notepad.");
        }
    }
}
