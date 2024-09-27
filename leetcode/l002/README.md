## ADD TWO NUMBERS - SOLUTION

[Add Two Numbers Link](https://leetcode.com/problems/add-two-numbers)  
[Vietnamese LeetCode Solution](https://leetcode.com/problems/add-two-numbers/solutions/5838178/add-two-numbers-phuquocchamp-s-java-solution-vietnamese/)

### Approach

- Mục tiêu của bài toán là thực hiện cộng hai số nguyên không âm, trong đó các chữ số được lưu theo thứ tự ngược trong hai danh sách liên kết. Mỗi nút chứa một chữ số duy nhất.
- Ta sẽ duyệt cả hai danh sách liên kết đồng thời, tính tổng các chữ số tương ứng cùng với phần dư từ phép cộng trước đó. Nếu một danh sách ngắn hơn danh sách kia, giá trị của nút đó sẽ được coi là 0.
- Tổng của hai chữ số được tính và một nút mới được tạo để lưu kết quả là sum % 10. Phần dư (carry) sẽ được sử dụng cho lần lặp tiếp theo.
- Quá trình tiếp tục cho đến khi cả hai danh sách đã được duyệt hết và không còn dư.

### Time Complexity:

- O(max(m, n)), trong đó m và n là độ dài của hai danh sách liên kết. Ta duyệt từng nút của cả hai danh sách một lần để cộng chúng.

### Space Complexity:

- O(max(m, n)) bởi vì kích thước của danh sách kết quả tỷ lệ với độ dài lớn nhất của hai danh sách đầu vào. Một nút mới được tạo cho mỗi chữ số kết quả.

### Code

```java
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return head.next;
    }
}
```
