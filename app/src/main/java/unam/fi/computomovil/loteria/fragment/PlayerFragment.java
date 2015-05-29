package unam.fi.computomovil.loteria.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import unam.fi.computomovil.loteria.R;
import unam.fi.computomovil.loteria.interfaces.FragmentInteractionListener;
import unam.fi.computomovil.loteria.util.GameConstantsManager;
import unam.fi.computomovil.loteria.view.widget.JossImageView;


public class PlayerFragment extends Fragment implements View.OnClickListener {

    //Constants
    public static final int TERMINAR = 1+GameConstantsManager.PLAYER;
    public static final String GAME_SIZE ="game_size";
    public static final int X3 =9;
    public static final int X4 =16;
    public static final int X5 =25;

    private int gameSize;

    private GameConstantsManager gameConstantsManager;
    private ArrayList<JossImageView> cards;
    private ArrayList<ImageView> frijoles;

    private int gameCount;
    private FragmentInteractionListener listener;
    private Context context;

    public static PlayerFragment newInstance(int typeGame) {
        PlayerFragment fragment = new PlayerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(GAME_SIZE,typeGame);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
        listener = (FragmentInteractionListener) this.context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameSize = getArguments().getInt(GAME_SIZE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = null;
        switch (gameSize){
            case X3: v = inflater.inflate(R.layout.fragment_player3, container, false); break;
            case X4: v = inflater.inflate(R.layout.fragment_player4, container, false);break;
            case X5: v = inflater.inflate(R.layout.fragment_player5, container, false);break;
        }
        cards = new ArrayList<>();
        frijoles = new ArrayList<>();
        TypedArray card_ids = context.getResources().obtainTypedArray(R.array.card_ids);
        TypedArray frijol_ids = context.getResources().obtainTypedArray(R.array.frijol_ids);

        for (int i = 0; i < gameSize; i++) {
            JossImageView josview = (JossImageView) v.findViewById(card_ids.getResourceId(i, 0));
            josview.setId(i);
            cards.add(josview);
            frijoles.add((ImageView) v.findViewById(frijol_ids.getResourceId(i, 0)));
        }
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        populateCards();
    }

    private void populateCards() {
        gameConstantsManager = new GameConstantsManager(GameConstantsManager.PLAYER, context,gameSize);
        gameCount = 0;
        int x = 0;
        for (JossImageView i : cards) {
            Log.d(context.getPackageName(), "Se define el drawable " + x++);
            i.setImageDrawable(gameConstantsManager.getPlayerCard());
            i.setOnClickListener(this);
        }
        for (ImageView j :frijoles){
            j.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        if (view instanceof JossImageView) {
            ImageView v = frijoles.get(((JossImageView) view).getId());
            if (v.getVisibility() == View.GONE) {
                v.setVisibility(View.VISIBLE);
                gameCount++;

            } else {
                v.setVisibility(View.GONE);
                gameCount--;
            }
            if (gameCount == gameSize) {
                promptWinDialog();
            }
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
                        listener.onFragmentInteraction(GameConstantsManager.PLAYER,TERMINAR);
                    }
                })
                .setNegativeButton("Volver a Empezar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        populateCards();
                    }
                })
                .show();
    }
}
