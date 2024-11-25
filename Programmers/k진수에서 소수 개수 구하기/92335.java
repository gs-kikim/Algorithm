import java.util.*;


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
        // Step 1: Handle edge cases
        if (n <= 1) return false;  // 1 이하의 숫자는 소수가 아님
        if (n <= 3) return true;   // 2와 3은 소수
        if (n % 2 == 0 || n % 3 == 0) return false; // 2와 3을 제외한 짝수 및 3의 배수는 소수가 아님
    
        // Step 2: Check divisors up to sqrt(n)
        for (long i = 5; i * i <= n; i += 6) { 
            if (n % i == 0 || n % (i + 2) == 0) return false; // i와 i+2로 나누어지는 경우 소수가 아님
        }
    
        // Step 3: If no divisors found, n is prime
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

