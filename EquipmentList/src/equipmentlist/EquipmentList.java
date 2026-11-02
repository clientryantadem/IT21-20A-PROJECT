
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

        public void add(Equipment equipment) {
            Node newNode = new Node(equipment);

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }

            size++;
        }
        
          public Equipment searchByID(String equipmentID) {
            Node current = head;

            while (current != null) {
                if (current.data.getEquipmentID().equalsIgnoreCase(equipmentID)) {
                    return current.data;
                }
                current = current.next;
            }

            return null;
            
            
    public static void main(String[] args) {
      
    }
    
}
