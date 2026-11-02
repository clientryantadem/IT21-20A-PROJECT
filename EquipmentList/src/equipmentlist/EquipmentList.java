
package equipmentlist;


public class EquipmentList {

  
        private class Node {
            Equipment data;
            Node next;

            Node(Equipment data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node head;
        private int size;

        public EquipmentList() {
            this.head = null;
            this.size = 0;
        }

    public static void main(String[] args) {
      
    }
    
}
