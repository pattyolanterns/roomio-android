package tom_dev.com.roomio_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Mate {
    private String name;
    private String id;
    private byte[] img;
    private String email;
    private ArrayList<Transaction> transactions;
    private byte[] image;

    public Mate() {

    }

    public Mate(String name, String id) {
        this.id = id;
        this.name = name;
        this.transactions = new ArrayList<Transaction>();
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setTransactions(ArrayList<Transaction> t) {
        transactions = t;
    }

    public void addTransaction(Transaction t) {
        transactions.add((t));
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public Transaction getTransaction(int index) {
        if (index + 1 > transactions.size()) {
            // should throw an exception
            return null;
        }

        return transactions.get(index);
    }

    public double getBalance() {
        return 420.69;
    }

    public Bitmap getImage() {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public String getID() {
        return id;
    }
}