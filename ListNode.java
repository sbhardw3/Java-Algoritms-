
public class ListNode {
    int data;
    ListNode next;
    public ListNode(int dataIn, ListNode nextIn){
        this.data = dataIn;
        this.next = nextIn;
    }

    public static ListNode subproblem1(){
        ListNode list = null;
        ListNode node4 = new ListNode(10,null);
        ListNode node5 = new ListNode(20,null);
        node4.next = node5;
        ListNode node6 = new ListNode(30,null);
        node5.next = node6;

        return node4;
    }

    public static ListNode subproblem2(){
        ListNode list = null;
        ListNode node1 = new ListNode(10,null);
        ListNode node2 = new ListNode(20,null);
        node1.next = node2;
        ListNode node3 = new ListNode(30,node1);

        return node3;
    }

    public static ListNode subproblem3(){
        ListNode list = null;
        ListNode node1 = new ListNode(10,null);
        ListNode node2 = new ListNode(20,null);
        node1.next = node2;
        
        ListNode node3 = new ListNode(30,null);
        ListNode node4 = new ListNode(40,null);
        node3.next = node4;
        
        node1.next = node3;
        node3.next = node2;

        return node1;
    }

    public static ListNode subproblem4(){
        int max = 290;
        
        ListNode node1 = null;
        
        
        for(int i = 1; i <= 29; i++){
             node1 = new ListNode(i*10, null);
             ListNode list = node1;
             
             System.out.print(list.data + " " );
        
           }
           ListNode node2 = new ListNode(300,null);
           node1.next = node2;
           ListNode list1 = node2;
           System.out.println(list1.data);
           
           
       
         
           return null;
    }

    public static void printList(ListNode list){
        ListNode tmp = list;
        String listStr = "";
        while (tmp != null){
            listStr = listStr + tmp.data + " ";
            tmp = tmp.next;
        }
        System.out.println(listStr);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(42, null);
        ListNode node2 = new ListNode(-3, null);
        node1.next = node2;
        ListNode node3 = new ListNode(17, null);
        node2.next = node3;
  
        ListNode list = node1;
        
        
      
        System.out.println(list.data + " " + list.next.data
                           + " " + list.next.next.data);
       
      
                           
        ListNode list1 = subproblem1();
        printList(list1);
        ListNode list2 = subproblem2();
        printList(list2);
        ListNode list3 = subproblem3();
        printList(list3);
        ListNode list4 = subproblem4();
        printList(list4);
        
        
        
   }
}
