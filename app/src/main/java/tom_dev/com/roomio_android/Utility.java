package tom_dev.com.roomio_android;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class Utility {

    private Context context;

    public Utility(Context context) {
        this.context = context;
    }

    public void hideKeyboard(EditText et) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }
}
