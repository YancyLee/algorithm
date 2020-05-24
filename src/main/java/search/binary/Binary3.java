package search.binary;


/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Binary3 {

    public static void main(String[] args) {

    }

    /**
     * 最少每天都能运走一个，则最小值为所有重量重中最大的
     *
     * 最多一天把所有的都运走，最大值则为所有重量的总和
     */

    private int searchWeight(int[] weights,int days){
        int max = 0;
        int sum = 0;
        for (int i = 0;i<weights.length;i++) {
            sum+=weights[i];
            max = Math.max(weights[i],max);
        }
        int mid=0;

        int low = max;
        int high = sum;
        while (low < high) {
            mid = (low+high) >>> 1;
            if (isOk(weights,days,mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    private boolean isOk(int[] weights,int days,int load) {
        int onceLoad = 0;
        for (int i = 0;i < weights.length; i++) {

            if (onceLoad + weights[i] > load) {
                onceLoad = 0;
                days--;
                if (days < 0) {
                    return false;
                }
            }
            onceLoad += weights[i];
        }
        return days > 0;
    }
}
