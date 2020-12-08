package study.ss.book.algs4.sort;


import study.ss.book.algs4.struct.Stack;

class Solution extends SortBase{
    static class ListNode {
        Comparable val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }




    public ListNode arrToListNode(Comparable[] arr) {
        ListNode head = new ListNode();
        head.val = arr[0];

        ListNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode listNode = new ListNode();
            listNode.val = arr[i];
            if (prev != null) {
                prev.next = listNode;
            }
            prev = listNode;
        }
        return head;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<Integer>();
        Solution solution = new Solution();
        solution.get(10);
    }

    public void printNode(ListNode listNode) {
        while (listNode != null) {
            System.out.printf(listNode.val + "");
            listNode = listNode.next;
            if (listNode != null) {
                System.out.printf("->");
            }
        }
        System.out.println("");
    }

    /**
     * 合并两个有序链表,正序排序
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val.compareTo(l2.val) < 0) {
            l1.next = this.mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = this.mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        Stack<Comparable> s = new Stack<Comparable>();
        while (l1 != null && l2 != null) {
            if (l1.val.compareTo(l2.val) < 0) {
                s.push(l1.val);
                l1 = l1.next;
            }else{
                s.push(l2.val);
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            appendListNode(s,l1);
        }
        if (l2 != null) {
            appendListNode(s,l2);
        }
        return stackToListNode(s);
    }

    public void appendListNode(Stack stack, ListNode node) {
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
    }


    public ListNode stackToListNode(Stack<Comparable> s) {
        Comparable c = s.pop();
        ListNode head = null;
        do {
            ListNode listNode = new ListNode();
            listNode.val = c;
            if (head != null) {
                listNode.next = head;
            }
            head = listNode;
            c = s.pop();
            printNode(head);
        } while (c != null);
        return head;
    }

    public int get(int x) {
        System.out.println(Integer.toBinaryString(x));
        int max = 0;
        while (x != 0) {
            max += x %2;
            x = x >> 1;
        }
        System.out.println(max);
        return max;
    }

    public void swapi(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
