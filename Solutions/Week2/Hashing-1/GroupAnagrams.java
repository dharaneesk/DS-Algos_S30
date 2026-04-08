//TC: O(n*k) -> n is the number of strings and k is avg length of each string
// SC: O(n) -> map creates prime products for each unique string
// Approach: Each character is mapped to a prime number and product of prime numbers are uniquely mapped to each string(abc = bca = 2*3*5). each string is mapped with prime product as its key and anagrams of the string are added to the values.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    
    int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<Double,List<String>> map = new HashMap();

        for(String str:strs){
            Double primeProduct = primeProduct(str);
            if(!map.containsKey(primeProduct))
                map.put(primeProduct, new ArrayList<String>());
            map.get(primeProduct).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private Double primeProduct(String str) {
        Double product=1d;
        for(int i=0;i<str.length();i++){
            product *= primes[str.charAt(i)-'a'];
        }
        return product;
    }
}