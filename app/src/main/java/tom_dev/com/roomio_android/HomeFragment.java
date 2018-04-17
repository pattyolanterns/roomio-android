package tom_dev.com.roomio_android;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;
    private TextView tv_balance;
    private MateAdapter mateAdapter;
    private Button btn_add_tramsaction;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.me_recycler_view);
        //recyclerView.setLayoutManager(new LinearLayoutManager());

        //mateAdapter = new MateAdapter(getActivity().getApplicationContext(), items);
        //recyclerView.setAdapter(mateAdapter);

        tv_balance = view.findViewById(R.id.tv_balance);

        btn_add_tramsaction = view.findViewById(R.id.add_button);
        btn_add_tramsaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // setup initial fragment
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                AddTransactionFragment fragment = new AddTransactionFragment();
//                transaction.replace(R.id.fragment_container, fragment);
//                transaction.commit();
            }
        });

        return view;
    }

}
