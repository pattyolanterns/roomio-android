package tom_dev.com.roomio_android;
public class Transaction {
    private String title;
    private double value;
    private Mate sender;
    private Mate receiver;

    public Transaction(Mate s, Mate r, double v, String t) {
        this.value = v;
        this.sender = s;
        this.receiver = r;
        this.title = t;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double v) {
        value = v;
    }

    public Mate getSender() {
        return sender;
    }

    public void setSender(Mate s) {
        sender = s;
    }

    public Mate getReceiver() {
        return receiver;
    }

    public void setReceiver(Mate r) {
        receiver = r;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }
}
