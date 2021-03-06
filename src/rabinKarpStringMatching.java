public class rabinKarpStringMatching {


    public boolean NaiveSearch(String str, String pattern) {
        for(int i = 0; i < (str.length() - pattern.length() + 1); i++) {
            for(int j = 0; j < pattern.length(); j++) {
                if(str.substring(j, i + j -1) == pattern.substring(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Theory of Rabin Karp algorithm
    // rabin karp algorithtm implementation
    // It uses O(m) preprocessing time. Its run time similar to naive
    // complexity - O((n- m + 1)m), where n = length of the string, m =length of the pattern
    // average running time is always better than naive pattern matching

    public int BruteForceAlgo(String text, String pattern) {
        if(pattern.length() > text.length()) return -1;
        for(int i = 0; i < (text.length() - pattern.length() + 1); i++) {
            int j = 0;
            while(j < pattern.length() && (text.charAt(i + j) == pattern.charAt(j))) {
                j++;
            }
            if(j == pattern.length()) {
                return i;
            }
        }
        return -1;
    }

    // Introduction to algorithms
    // String matching algorithms theory and implementation
    // pattern P = abaa , T = abcabaabcabac
    // complexity - O((n- m + 1)m), where n = length of the string, m =length of the pattern
    // substring functionality involves the O(m) time. Depending on the length of the string
    public boolean naiveStringMatch(String text, String pattern) {
        for(int i = 0; i < (text.length() - pattern.length() + 1); i++) {
                if(text.substring(i, pattern.length() + i ).equals(pattern)) {
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String str = "abcabaabcabac";
        String pattern = "abaa";
        rabinKarpStringMatching rs = new rabinKarpStringMatching();
        // System.out.println(rs.NaiveSearch(str, pattern));
        // System.out.println(rs.BruteForceAlgo("abababcdababababd", "abababcdababababd"));
        System.out.println(rs.naiveStringMatch(str, pattern));
    }
}
