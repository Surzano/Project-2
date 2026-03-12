import java.lang.reflect.GenericDeclaration;

public class Queue {
    private QueueRecord head, tail;

    public void enqueue(Alert al){
        QueueRecord qr = new QueueRecord(al);
        if(head == null){
            tail = qr;
            head = qr;
        } else {
            tail.next = qr;
            tail = qr;
        }
    }

    public Alert dequeue(){
        Alert toReturn = null;

        if(head != null){
            toReturn = head.alert;
            head = head.next;
            if(head == null){ tail = null; }
            else if(head.next == null){ tail = head; }
        }

        return toReturn;
    }

    public Alert peek() {
        if (head == null) {
            return null;
        }

        return head.alert;
    }

    public int count(){
        int count = 0;
        QueueRecord last = head;

        while(true){
            if(last == null){break;}

            count++;
            if(last.next == null){
                break;
            }
            last = last.next;
        }

        return count;
    }

    private class QueueRecord{
        public QueueRecord next;
        public Alert alert;

        public QueueRecord(Alert alr){
            alert = alr;
        }
    }
}

