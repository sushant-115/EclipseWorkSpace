package test;

public class GetHeapSize {
    public static void main(String[]args){

        //Get the jvm heap size.
        long heapSize = Runtime.getRuntime().totalMemory();
   long size=heapSize/1024;
        //Print the jvm heap size.
        System.out.println("Heap Size = " + (size/1024));
    }
}