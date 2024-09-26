import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    public class Node{
        private Item item;
        private Node front;
        private Node back;
    }


    // construct an empty deque
    public Deque(){
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        if (item == null){throw new IllegalArgumentException();}
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.front = oldNode;
        first.back = null;
        if(isEmpty()){last = first;}
        else{oldNode.back = first;}
        size++;
    }

    // add the item to the back
    public void addLast(Item item){
        if (item == null){throw new IllegalArgumentException();}
        Node oldNode = last;
        last = new Node();
        last.item = item;
        last.front = null;
        last.back = oldNode;
        if(isEmpty()){first = last;}
        else{oldNode.front = last;}
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(isEmpty()){throw new java.util.NoSuchElementException();}
        Item item = first.item;
        first = first.front;
        size--;
        if(isEmpty()){last = first;}
        else{first.back = null;}
        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(isEmpty()){throw new java.util.NoSuchElementException();}
        Item item = last.item;
        last = last.back;
        size--;
        if(isEmpty()){first = last;}
        else{last.front = null;}
        return item;
    }



    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new listIterator();
    }

    // Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
    private class listIterator implements Iterator<Item>{
        Node current = first;
        public boolean hasNext(){return current != null;}
        public Item next(){
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }else{
                Item item = current.item;
                current = current.front;
                return item;
            }
        }

    }

    // unit testing (required)
    public static void main(String[] args){

    }

}
