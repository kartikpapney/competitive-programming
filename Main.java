import java.io.PipedInputStream;

public class Main {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int ans = 0;
        boolean[] possible = new boolean[target+1];
        possible[0] = true;
        for(int i=1; i<=target; i++) {
            boolean[] previous = possible.clone();
            for(int base : baseCosts) {
                int rem = i-base;
                if(i < 0) continue;
                for(int topping : toppingCosts) {
                    possible[i]|=previous[i];
                    if(topping > rem) continue;
                    possible[i]|=previous[rem-topping];
                    if(2*topping > rem) continue;
                    possible[i]|=previous[rem-2*topping];
                }
            }
            if(possible[i]) ans = i;
        }
        return ans;
    }
}