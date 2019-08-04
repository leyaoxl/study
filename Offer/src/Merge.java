import java.util.List;

public class Merge {
    // 递归法
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    // 迭代法
    // public ListNode Merge(ListNode list1,ListNode list2) {
    //     if (list1 == null) return list2;
    //     if (list2 == null) return list1;
    //     ListNode tmp = null;
    //     ListNode result = null;
    //     while (list1 != null && list2 != null) {
    //         if (list1.val <= list2.val) {
    //             if (result == null) {
    //                 tmp = list1;
    //                 result = tmp;
    //             } else {
    //                 tmp.next = list1;
    //                 tmp = tmp.next;
    //             }
    //             list1 = list1.next;
    //         } else {
    //             if (result == null) {
    //                 tmp = list2;
    //                 result = tmp;
    //             } else {
    //                 tmp.next = list2;
    //                 tmp = tmp.next;
    //             }
    //             list2 = list2.next;
    //         }
    //     }
    //     if (list1 == null) tmp.next = list2;
    //     if (list2 == null) tmp.next = list1;
    //     return result;
    // }
}
