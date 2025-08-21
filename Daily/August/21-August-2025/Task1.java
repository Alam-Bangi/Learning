
import java.util.Arrays;

class Task1 {
    String name;
    // name = "Alam";

    public Task1() {
        System.out.println("Creating Task Object ");
        this.name = "Alam";
    }
    public Task1(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        System.out.println("Alam");
        Task1 task = new Task1();
        Task1 task2 = new Task1("Abrar");
        System.out.println(task2.name);
        System.out.println(task2.myName());
        System.out.println(task.name);
        System.out.println(task.myName());
        System.out.println(task.getBooleanDataType());
        System.out.println(task.getByteDataType());
        System.out.println(task.getShortDataType());
        System.out.println(task.getCharDataType());
        System.out.println(task.getIntDataType());
        System.out.println(task.getFloatDataType());
        System.out.println(task.getLongDataType());
        System.out.println(task.getDoubleDataType());
        System.out.println(task.getTaskObject());
        System.out.println(task.getStringDataType());
        System.out.println(Arrays.toString(task.getBooleanArray()));
        System.out.println(Arrays.toString(task.getByteArray()));
        System.out.println(Arrays.toString(task.getShortArray()));
        System.out.println(Arrays.toString(task.getCharArray()));
        System.out.println(Arrays.toString(task.getIntArray()));
        System.out.println(Arrays.toString(task.getFloatArray()));
        System.out.println(Arrays.toString(task.getLongArray()));
        System.out.println(Arrays.toString(task.getDoubleArray()));
        System.out.println(Arrays.toString(task.getStringArray()));
        System.out.println(Arrays.toString(task.getTaskArray()));
    }

  
    public String myName() {
        return this.name;
    }
    public boolean getBooleanDataType() {
        return true;
    }
    public byte getByteDataType() {
        return 0;
    }
    public short getShortDataType() {
        return 0;
    }
    public char getCharDataType() {
        return 'a';
    }
    public int getIntDataType() {
        int a =5;
        return a;
    }
    public float getFloatDataType() {
        return 0.0f;
    }
    public long getLongDataType() {
        return 0;
    }
    public double getDoubleDataType() {
        return 0.0d;
    }
    public boolean[] getBooleanArray() {
        boolean[] booleanArray = new boolean[5];
        return booleanArray;
    }
    public byte[] getByteArray() {
        byte[] byteArray = new byte[5];
        return byteArray;
    }
    public short[] getShortArray() {
        short[] shortArray = new short[5];
        return shortArray;
    }
    public char[] getCharArray() {
        char[] charArray = new char[5];
        return charArray;
    }
    public int[] getIntArray() {
        int[] intArray = new int[5];
        return intArray;
    }
    public float[] getFloatArray() {
        float[] floatArray = new float[5];
        return floatArray;
    }
    public long[] getLongArray() {
        long[] longArray = new long[5];
        return longArray;
    }
    public double[] getDoubleArray() {
        double[] doubleArray = new double[5];
        return doubleArray;
    }
    public String getStringDataType() {
        // String newString = new String("Alam");
        return null;
    }
    public String[] getStringArray() {
        String[] stringArray = new String[5];
        return stringArray;
    }
    public Task1 getTaskObject() {
        Task1 objName = new Task1();
        return objName;
    }
    public Task1[] getTaskArray() {
        Task1[] taskArray = new Task1[5];
        taskArray[0] = this.getTaskObject();
        taskArray[1] = this.getTaskObject();
        taskArray[2] = this.getTaskObject();
        taskArray[3] = this.getTaskObject();
        taskArray[4] = this.getTaskObject();
        return taskArray;
    }

}