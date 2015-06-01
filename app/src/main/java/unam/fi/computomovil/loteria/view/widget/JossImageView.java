package unam.fi.computomovil.loteria.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by José Ángel García Salinas on 28/05/15.
 */
public class JossImageView extends ImageView {

    private  int id_;

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }


    public JossImageView(Context context) {
        super(context);
    }

    public JossImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public JossImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public JossImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }




}
