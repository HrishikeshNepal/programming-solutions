class CheckVolels{
    public static void main(String[] args){
        String str = "oaeEWQFAADasf";
        String pattern = ".*[aeiouAEIOU]";
        System.out.println(str.matches(pattern));
    }
}
