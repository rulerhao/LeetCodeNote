// 1. lemonnade 5$
// 2. Order one at a time.
// 3. I am shopkeeper.
// 4. Buy up to 1 for each customer.
// 5. Bill amount: $5, $10, $20
// 6. Give back the change to each customer.
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int change5 = 0;
        int change10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                change5++;
            } else if (bills[i] == 10) {
                if (change5 == 0) return false;
                else {
                    change5--;
                    change10++;
                }
            } else {
                if (change10 == 0) {
                    if (change5 < 3) return false;
                    else change5 = change5 - 3;
                } else {
                    if (change5 == 0) return false;
                    else {
                        change10--;
                        change5--;
                    }
                }
            }
        }
        return true;
    }
}
