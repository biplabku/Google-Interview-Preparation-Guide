public class repeatedString {

    public static int repeatedStringMatch(String A, String B) {
        StringBuilder res = new StringBuilder(A);
        System.out.println(res.toString());
        int count = 1;
        System.out.println(res.indexOf(B));
        while(res.indexOf(B) < 0){ // continue until we get a match
            if(res.length() - A.length() > B.length()){
                return -1;
            }
            res.append(A);
            count ++;
        }
        return count;
    }


    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "cdabcdab";
        System.out.println(repeatedStringMatch(str1, str2));
    }
}