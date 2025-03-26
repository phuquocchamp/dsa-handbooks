## TWO SUM - SOLUTION

[Two Sum Link](https://leetcode.com/problems/two-sum)  
[Vietnamese LeetCode Solution](https://leetcode.com/problems/two-sum/solutions/5842982/phuquocchamp-s-java-solution/)

### Approach

- Mục tiêu của bài toán là tìm hai số trong một mảng sao cho tổng của chúng bằng một giá trị mục tiêu (target). Chúng ta cần trả về chỉ số của hai số đó.
- Sử dụng một bảng băm (HashMap) để lưu trữ các phần tử đã duyệt qua và chỉ số tương ứng của chúng.
- Khi duyệt qua từng phần tử của mảng, ta kiểm tra xem hiệu của giá trị mục tiêu và phần tử hiện tại (target - nums[i]) có tồn tại trong bảng băm hay không. Nếu tồn tại, ta đã tìm thấy cặp số cần tìm.
- Nếu không, ta lưu phần tử hiện tại và chỉ số của nó vào bảng băm để tiếp tục kiểm tra trong các lần lặp tiếp theo.

### Time Complexity:

- O(n), trong đó n là độ dài của mảng. Ta chỉ duyệt qua mảng một lần và mỗi thao tác tìm kiếm hoặc thêm vào bảng băm mất trung bình O(1) thời gian.

### Space Complexity:

- O(n), bởi vì ta sử dụng một bảng băm để lưu trữ các phần tử đã duyệt qua.

### Code

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null; // No valid pair found
    }
}
```
