
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
          }
            
        public boolean containsID(String equipmentID) {
            return searchByID(equipmentID) != null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }
        public Equipment[] toArray() {
            Equipment[] records = new Equipment[size];
            Node current = head;
            int index = 0;

            while (current != null) {
                records[index] = current.data;
                index++;
                current = current.next;
            }

            return records;
        }
    }
  
