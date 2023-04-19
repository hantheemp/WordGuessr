public class WordQueue {
    private NodeLL rear;
    private NodeLL front;

    public WordQueue() {this.front = this.rear = null;}

    public WordQueue(LinkedList a) {
        this.front = a.getFirst();
        this.rear = a.getLast();
    }

    public void addToQueue(NodeLL node) {
        getRear().next = node;
        node.prev = getRear();
        setRear(node);
    }

    public void removeFromQueue() {
        if(getFront() != null) {
            setFront(getFront().next);
            getFront().prev = null;
        }
    }

    //Encapsulation
    public NodeLL getFront() {
        return front;
    }

    public NodeLL getRear() {
        return rear;
    }

    public void setFront(NodeLL front) {
        this.front = front;
    }

    public void setRear(NodeLL rear) {
        this.rear = rear;
    }

}
