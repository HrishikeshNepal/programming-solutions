class DecodeString{
    public static void main(String[] args){
        String s = "3[a]2[bc]";
        s = decodeString(s);
        System.out.println(s);
    }

    public static String decodeString(String s) {
        String pattern = "[\\[\\]]";
        if(s.matches(pattern))
                return "true";
        return "false";
    }
}
