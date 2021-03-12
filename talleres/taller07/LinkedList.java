

public class LinkedList{

    private Node head; 
    private int size = 0;

    public void appedFirst(int data){

        Node newNode = new Node(data);
        newNode.setNext(this.head);
        this.head = newNode;
        size++;

    }

    public int size(){
        return this.size;
    }

    public int getElemet(int index){
        
        LinkedList.chekBounds(index,this.size());

        Node currectNode = this.head;

        for(int tt = 0; tt < this.size;tt++){

         
            if(tt == index){
                return currectNode.getData();
            }
            currectNode = currectNode.getNext();
        }


        return -1;

    }

    public boolean contains(int data){
        Node currectNode = this.head;

        for(int tt = 0; tt < this.size;tt++){
            if(currectNode.getData() == data){
                return true;
            }
            currectNode = currectNode.getNext();
        }

        return false;

    }

    public void remove(int index){

        LinkedList.chekBounds(index,this.size());

        if(index == 0){
            this.head = this.head.getNext();
            this.size--;
            return;
        }
        Node currect = this.head;
       for(int tt = 0;tt<this.size;tt++){
           if(tt-1 == index-1){
                currect.setNext(currect.getNext());
                this.size--;
                return;
           }
           currect = currect.getNext();

       }


    }

    public void insert(int data,int index){

        LinkedList.chekBounds(index,this.size());
        

        if(index == 0){
            this.appedFirst(data);
            return;
        }
        
        Node currectNode = this.head;
        for(int tt = 0;tt<this.size;tt++){
            if(tt-1 == index-1){
                Node newNode = new Node(data);
                newNode.setNext(currectNode.getNext());
                currectNode.setNext(newNode);
                this.size++;
            }
        }

    }

   

    public static void chekBounds(int index, int size){

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

    }

    
    
}
