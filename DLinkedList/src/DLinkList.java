
public class DLinkList {
	Node head;
	Node tail;
	public DLinkList() {
		
		this.head = null;
		this.tail = null;
	}
	public void insert(int val) {
		Node tmp = new Node(val);
		if(head == null) {
			head = tmp;
			tail = tmp;
		}else {
			head.prev = tmp;
			tmp.next = head;
			head = tmp;
		}
	}
	public void append(int val) {
		Node tmp = new Node(val);
		if(head == null) {
			head = tmp;
			tail = tmp;
		}else {
			tail.next = tmp;
			tmp.prev = tail;
			tail = tmp;
		}
	}
	public void insertAtPos(int value, int pos) {
		int noOfNodes = findNoOfNodes();
		if(pos == 0) {
			insert(value);
		}else if(noOfNodes+1 == pos) {
			append(value);
		}else if(pos > 1 && pos < noOfNodes+1) {
			Node it = this.head;
			int x = pos;
			while(x != 0) {
				it = it.next;
				x--;
			}
			Node tmp = new Node(value);
			tmp.next = it.next;
			tmp.prev = it;
			it.next.prev = tmp;
			it.next = tmp;
			
			
		}else {
			System.out.println("INVALID POSITION");
		}
	}
	
	
	
	private int findNoOfNodes() {
		Node it = this.head;
		int counter = 0;
		while(it != null) {
			it = it.next;
			counter ++;
		}
		return counter;
	}
	public void deleteFirst() {
		
		if(head != null) {
			if(head == tail) {
				head = null;
				tail = null;
			}else {
				Node tmp = head;
				head = tmp.next;
				head.prev = null;
				tmp.next = null;
				tmp =null;
			}	
			
		}
	}
		public void deleteLast() {
			
			if(head != null) {
				if(head == tail) {
					head = null;
					tail = null;
				}else {
					Node tmp = tail;
					tail = tmp.prev;
					tail.next = null;
					tmp.prev = null;
					tmp =null;
					
				}
			}
			
	}
		public void deleteAtPos( int pos) {
			int noOfNodes = findNoOfNodes();
			if(pos == 0) {
				deleteFirst();
			}else if(noOfNodes+1 == pos) {
				deleteLast();
			}else if(pos > 1 && pos < noOfNodes+1) {
				Node it = this.head;
				int x = pos;
				while(x != 0) {
					it = it.next;
					x--;
				}
				Node tmp = it.next;
				it.next = tmp.next;
				tmp.next.prev = it;
				tmp.next = null;
				tmp.prev = null;
				tmp = null;
		
			}else {
				System.out.println("INVALID POSITION");
			}
		}
		
	public void reverse() {
		Node it = head;
		while(it != null) {
			Node t = it.prev;
			it.prev = it.next;
			it.next = t;
			
			it =it.prev;
		}
		Node tmp = head;
		head = tail;
		tail = tmp;
	}
	public String toString() {
		String str = "";
		if(head == null) {
			str += "DLL is empty";
		}else {
			Node it = head;
			while(it.next != null) {
				str += " " + it.data + "<--->";
			}
			str += "\n";
		}
		return str;
	}
}
