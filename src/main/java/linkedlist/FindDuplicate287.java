package linkedlist;

public class FindDuplicate287 {
    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,4};
        System.out.println(method(nums));

    }
    public static int method(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do  {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        slow = nums[0];

        while (fast !=slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
