import java.util.Arrays;
import java.util.HashMap;

public class validAnagram {


    public static boolean isValidAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        String s1 =  new String(a);
        String s2 = new String(b);
        System.out.println(s1 + " " + s2);
        return s1.equals(s2);
    }

    public static boolean isValidMethod1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!hmap.containsKey(s.charAt(i))) {
                hmap.put(s.charAt(i), 1);
            }else {
                hmap.put(s.charAt(i), hmap.get(s.charAt(i)) + 1);
            }
        }
        for(int i = 0 ; i < s.length(); i++) {
            if(hmap.containsKey(t.charAt(i)) && (hmap.get(t.charAt(i)) >= 0)) {
                hmap.put(t.charAt(i), hmap.get(t.charAt(i)) - 1);
                if(hmap.get(t.charAt(i)) < 0) return false;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidMethod2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        // Adding and subtracting at the same time based on the values
        // and finally checking at the last whether all values are zero or not
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            System.out.println(s.charAt(i) - 'a');
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isValidAnagram(s, t));
        System.out.println(isValidMethod1(s, t));
        System.out.println(isValidMethod2(s, t));

    }
}
