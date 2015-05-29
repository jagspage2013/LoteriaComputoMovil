package unam.fi.computomovil.loteria.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import unam.fi.computomovil.loteria.R;

/**
 * Created by José Ángel García Salinas on 21/05/15.
 */
public class ObtainedCardAdapter extends BaseAdapter {

    ArrayList<Drawable> elements ;


    public ObtainedCardAdapter(){
        elements = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return elements.size();
    }

    @Override
    public Object getItem(int i) {
        return elements.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_card_obtained,null);
        ImageView ve = (ImageView)v.findViewById(R.id.row_image_card);
        ve.setImageDrawable(elements.get(i));
        return v;
    }

    public void addElement(Drawable b){
        elements.add(0,b);
        notifyDataSetChanged();

    }

}
