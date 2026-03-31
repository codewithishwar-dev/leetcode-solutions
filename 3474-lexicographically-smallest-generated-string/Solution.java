import java.util.*;

class Solution {
public String generateString(String str1, String str2) {
int n = str1.length();
int m = str2.length();

```
    char[] res = new char[n + m - 1];
    Arrays.fill(res, '?');

    // Apply 'T'
    for (int i = 0; i < n; i++) {
        if (str1.charAt(i) == 'T') {
            for (int j = 0; j < m; j++) {
                if (res[i + j] == '?' || res[i + j] == str2.charAt(j)) {
                    res[i + j] = str2.charAt(j);
                } else {
                    return "";
                }
            }
        }
    }

    // Early conflict detection
    for (int i = 0; i < n; i++) {
        if (str1.charAt(i) == 'F') {
            boolean match = true;

            for (int j = 0; j < m; j++) {
                if (res[i + j] == '?' || res[i + j] != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) return "";
        }
    }

    // Fill remaining
    for (int i = 0; i < res.length; i++) {
        if (res[i] == '?') {
            for (char c = 'a'; c <= 'z'; c++) {
                res[i] = c;
                if (validAt(res, str1, str2, i)) break;
            }
        }
    }

    return new String(res);
}

private boolean validAt(char[] res, String str1, String str2, int idx) {
    int n = str1.length();
    int m = str2.length();

    int start = Math.max(0, idx - m + 1);
    int end = Math.min(n - 1, idx);

    for (int i = start; i <= end; i++) {
        boolean match = true;

        for (int j = 0; j < m; j++) {
            if (res[i + j] != str2.charAt(j)) {
                match = false;
                break;
            }
        }

        if (str1.charAt(i) == 'T' && !match) return false;
        if (str1.charAt(i) == 'F' && match) return false;
    }

    return true;
}
```

}
