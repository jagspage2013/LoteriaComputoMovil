package unam.fi.computomovil.loteria.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unam.fi.computomovil.loteria.R;
import unam.fi.computomovil.loteria.activity.MainActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class StartFragment extends Fragment implements View.OnClickListener {

    private StartFragmentCallback startFragmentCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        startFragmentCallback =(StartFragmentCallback)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_start, container, false);
        v.findViewById(R.id.btn_start_griton).setOnClickListener(this);
        v.findViewById(R.id.btn_start_jugador).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start_griton: startFragmentCallback.onButtonClick(MainActivity.BE_GRITON);break;
            case R.id.btn_start_jugador: startFragmentCallback.onButtonClick(MainActivity.BE_JUGADOR);break;
        }
    }

    public interface StartFragmentCallback{
        void onButtonClick(int tag);
    }
}
