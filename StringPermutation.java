class StringPermutation{
    public static void main(String[] args){
        String str = "JESUS";
        permute("", str);
    }

    public static void permute(String prefix, String str){
        int n = str.length();
        if(n==0)
            System.out.println(prefix);

        for(int i = 0; i<str.length(); i++){
            permute(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1, n));
        }
    }
}
