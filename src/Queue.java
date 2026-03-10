public class Queue {
    private QueueRecord head, tail;

    public void enqueue(Alert al){
        QueueRecord qr = new QueueRecord(al);
        if(tail == null){
            tail = qr;
            head = qr;
        } else {
            tail.next = qr;
            tail = qr;
        }
    }

    public Alert dequeue(){

    }

    public Alert peek(){ return head.alert; }

    public int count(){

    }

    private class QueueRecord{
        public QueueRecord next;
        public Alert alert;

        public QueueRecord(Alert alr){
            alert = alr;
        }
    }
}

