package unam.fi.computomovil.loteria.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

import unam.fi.computomovil.loteria.R;
import unam.fi.computomovil.loteria.fragment.GritonFragment;
import unam.fi.computomovil.loteria.fragment.PlayerFragment;
import unam.fi.computomovil.loteria.fragment.StartFragment;
import unam.fi.computomovil.loteria.interfaces.FragmentInteractionListener;
import unam.fi.computomovil.loteria.util.GameConstantsManager;


public class MainActivity extends AppCompatActivity implements StartFragment.StartFragmentCallback,FragmentInteractionListener{

    public static final int BE_JUGADOR = 0;
    public static final int START =2;
    public static final int BE_GRITON= 1;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.show();
        swithFragment(new StartFragment(), START);


    }

    private void swithFragment(Fragment fragment,int tag){

        if(tag ==BE_JUGADOR || tag == BE_GRITON){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.fragment, fragment)
                    .addToBackStack(tag + "")
                    .commit();

        }else{
            actionBar.setTitle("Inicio");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment)
            .commit();

        }

    }

    @Override
    public void onButtonClick(int tag) {
        switch (tag){
            case BE_GRITON:
                    swithFragment(GritonFragment.newInstance(),BE_GRITON);
                    actionBar.setTitle("Gritón");
                break;
            case BE_JUGADOR:
                    showJugador();
                actionBar.setTitle("Jugador");

                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            actionBar.setTitle("Inicio");

        }else{
            finish();
        }

    }

    @Override
    public void onFragmentInteraction(int fragType, int action) {
        if(fragType== GameConstantsManager.GRITON){

        }

        if(fragType == GameConstantsManager.PLAYER){
            if(action == PlayerFragment.TERMINAR){
                actionBar.setTitle("Inicio");
                getSupportFragmentManager().popBackStack();
            }
        }
    }

    private void showJugador(){
        new AlertDialog.Builder(this)
                .setTitle("Elige el tamaño del tablero")
                .setAdapter(
                        new ArrayAdapter<>(
                                this,
                                android.R.layout.simple_list_item_1,
                                new String[]{"   3x3", "   4x4", "   5x5"}),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                goToJugador(i);
                            }
                        }).show();
    }

    private void goToJugador(int type){
        int aux = -1;
        switch (type){
            case 0: aux = PlayerFragment.X3; break;
            case 1: aux = PlayerFragment.X4; break;
            case 2: aux = PlayerFragment.X5; break;


        }
        swithFragment(PlayerFragment.newInstance(aux),BE_JUGADOR);

    }
}
