package unam.fi.computomovil.loteria.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import unam.fi.computomovil.loteria.R;
import unam.fi.computomovil.loteria.adapters.ObtainedCardAdapter;
import unam.fi.computomovil.loteria.util.GameConstantsManager;

public class GritonFragment extends Fragment implements View.OnClickListener {

    private ImageView card;
    private ObtainedCardAdapter adapter;
    private GameConstantsManager gameConstantsManager;
    private Context context;

    public static GritonFragment newInstance() {
        GritonFragment fragment = new GritonFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameConstantsManager = new GameConstantsManager(GameConstantsManager.GRITON,getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_griton, container, false);
        card = (ImageView)v.findViewById(R.id.img_griton_card);
        GridView obtainedCards = (GridView)v.findViewById(R.id.list_obtained_cards);
        adapter = new ObtainedCardAdapter();
        obtainedCards.setAdapter(adapter);
        Button btn_pop_card = (Button)v.findViewById(R.id.btn_pop_card);
        btn_pop_card.setOnClickListener(this);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        popCard();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_pop_card:
                popCard();
                break;
        }
    }

    private void popCard(){
        try {
            Drawable v = gameConstantsManager.getGritonCard();
            card.setImageDrawable(v);
            adapter.addElement(v);
        }catch (Exception e){
            Log.d("Lorería","Termino el juego");
        }
    }

    private void promptWinDialog() {
        new AlertDialog.Builder(context)
                .setTitle("Loteria!!!!!!!")
                .setCancelable(false)
                .setPositiveButton("Terminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Volver a Empezar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .show();
    }
}
