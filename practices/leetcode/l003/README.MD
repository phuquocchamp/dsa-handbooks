## LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS - SOLUTION

[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)  
[Vietnamese LeetCode Solution]()

### Approach

#### About Set Collections & HashSet In Java
Set Collection Hierachy.
- Nói sơ qua về phần này.


Chi phí : 
- add : O(1).
- remove : O(1).
- contains : O(1).

#### Idea

- Ý tưởng của bài toán là sử dụng **Sliding Window - Slow & Fast**
- Ta sử dụng 2 con trỏ left = 0, right = 0, result = 0, HashSet để lưu các kí tự. Ta cho con trỏ right duyệt từ 0 -> s.length(), và kiểm tra xem kí tự tại vị trí s[right] đã có trong HashSet chưa:
    - Nếu kí tự s[right] chưa có trong HashSet:
        - Thêm kí tự này vào HashSet.
        - Cập nhật biến result.
    - Nếu kí tự s[right] đã có trong HashSet:
        - lặp lại việc xóa kí tự trong HashSet cho đến khi gặp kí tự trùng với kí tự s[right].
        - Thêm kí tự s[right] vào HashSet. 
- Ở đây có một số bạn thắc mắc là tại sao lại sử dụng HashSet:
    - Thứ nhất, sau khi đọc Idea trên thì ta cần một kiểu dữ liệu để việc **(thêm/xóa/kiểm tra phần tử)** trong một danh sách với chi phí tối ưu - O(1) => HashSet là một implementation của Set Interface trong Java có thể đáp ứng các công việc trên.


Tham khảo : https://hackmd.io/@vuquelam28/HJrCyQE2_  


### Time Complexity:

- O(n) : Ta thấy rằng solution chỉ chạy đúng duy nhất một vòng for và trong vòng for này gồm cặp lệnh if-else nên trường hợp xấu nhất là chuỗi s gồm tất cả các kí tự không lặp lại => O(n).

### Space Complexity:

- O(n) : Tương tự như trên, ở đây ta thấy các methods (add, remove) có chi phí là O(1) nên trong trường hợp xấu nhất thì "độ phức tạp không gian lưu trữ" chiếm O(n).

### Code

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> container = new HashSet<>();
        int left = 0, result = 0;

        for(int right = 0; right < s.length(); right++){
            if(!container.contains(s.charAt(right))){
                container.add(s.charAt(right));
                result = Math.max(result, right - left + 1);
            }else{
                while(container.contains(s.charAt(right))){
                    container.remove(s.charAt(left));
                    left++;
                }
                container.add(s.charAt(right));
            }
        }
        
        return result;
    }
}
```
