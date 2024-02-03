public class Test1 {
    // Driver code
    public static void main(String[] args)
    {
        String str = "MyNameIs Hrishikesh Nepal";
        str = str.strip().replaceAll("\\s", "");
        System.out.println(str);
        String[] array = str.split("(?=[A-Z])");
        for(String element : array)
        	System.out.println(element);
        
        String str2 = "hello9909";
        System.out.println(str2.matches("[a-zA-Z0-9]+")); //to check alphanumeric
    }
}
