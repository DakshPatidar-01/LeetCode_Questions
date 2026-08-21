class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            int num = n;

            while (num != 0) {
                int rem = num % 10;
                num = num / 10;
                sum += rem * rem;
            }

            if (sum == 1) return true;
            if (set.contains(sum)) return false;

            set.add(sum);
            n = sum;
        }
    }
}