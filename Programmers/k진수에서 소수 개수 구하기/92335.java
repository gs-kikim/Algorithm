import java.util.*;

/* 
https://school.programmers.co.kr/learn/courses/30/lessons/92335
*/
class Solution {
    public int solution(int n, int k) {
        return count(divide(n,k));
    }

    public static int count(String n){
        return (int) Arrays.stream(n.split("0"))
        .map(Long::parseLong)
        .filter(Solution::isPrime)
        .count();
    }

    public static boolean isPrime(Long n) {
        if (n <= 1) return false;  
        if (n <= 3) return true;          
        if (n % 2 == 0 || n % 3 == 0) return false; 
    
        for (long i = 5; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static String divide(int n, int k){
        StringBuilder result=new StringBuilder();
        while(n>k){
            result.append(n%k);
            n = n/k;
        }
        result.append(n);
        return result.reverse().toString();
    }
}

