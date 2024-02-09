//class DecodeString {
//    public static void main(String[] args) {
//        String str = "3[a2[c]][d]3[a]2[bc]4[abcd]ab";
//        //decodeString(s);
//        System.out.println("str".indexOf('['));
//        System.out.println(str.indexOf('['));
//        System.out.println(str.lastIndexOf(']'));
//
//        String bracketsPattern = ".*[\\[\\]]";
//        System.out.println("avcsa[vdad]asfd]".matches(bracketsPattern));
//        String str1 = "a266";
//        String alphaNumeric = "[0-9]+";
//        System.out.println(str1.matches(alphaNumeric));
//        String pattern = "[a-zA-z]+";
//        String[] array;
//        array = str1.split(pattern);
//        for(String s: array)
//            System.out.print(s+ " ");
//
//
//    }
//
//    public static String decodeString(String str) {
//        /*
//        cases:
//        1) every closing bracket has an open bracket
//        2) find the numerical value just before the opening brackets
//        3) in case of nested brackets, solve the inner brackets before outer
//         */
//        String bracketsPattern = ".*[\\[\\]]";
//        if (!str.matches(bracketsPattern))
//            return str;
//
//        while (str.matches(bracketsPattern)) {
//            int i = str.indexOf('[');
//            int j = str.indexOf(']');
//            str = str.substring(i, j);
//        }
//        return str;
//    }
//}
