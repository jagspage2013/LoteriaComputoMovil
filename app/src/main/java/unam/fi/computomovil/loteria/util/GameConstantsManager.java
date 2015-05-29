package unam.fi.computomovil.loteria.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import unam.fi.computomovil.loteria.R;
import unam.fi.computomovil.loteria.fragment.PlayerFragment;

/**
 * Created by José Ángel García Salinas on 21/05/15.
 */
public class GameConstantsManager {

    public static final int GRITON = 2;
    public static final int PLAYER = 3;

    private Stack<Drawable> gritonCards;
    private Stack<Drawable> playerCards;
    private ArrayList<Integer> playernumber;

    private Context context;
    private Random random;
    private TypedArray drawableArray;


    public GameConstantsManager(int type ,Context context){
        this.context = context;
        drawableArray = context.getResources().obtainTypedArray(R.array.card_drawables);

        if(type==GRITON){
            gritonInit();
        }else if(type == PLAYER){
            jugadorInit(PlayerFragment.X3);
        }

    }

    public GameConstantsManager(int type ,Context context,int gameSize) {
        this.context = context;
        drawableArray = context.getResources().obtainTypedArray(R.array.card_drawables);

        if (type == GRITON) {
            gritonInit();
        } else if (type == PLAYER) {
            jugadorInit(gameSize);
        }
    }


    public void gritonInit(){
        gritonCards = new Stack<>();
        for (int i = 0; i < drawableArray.length() ; i++) {
            gritonCards.push(drawableArray.getDrawable(i));
        }
    }

    public  void jugadorInit(int gameSize){
        playerCards = new Stack<>();
        playernumber = new ArrayList<>();
        random = new Random();
        fillPlayerCards(gameSize);
    }

    private  void fillPlayerCards(int gameSize){

        int count =0;
        int cardNum = -1;

        while(count<gameSize){
            cardNum = getUniqueNumber();
            if(!playernumber.contains(cardNum)){
                playerCards.push(context.getResources().getDrawable(drawableArray.getResourceId(cardNum, 0)));
                playernumber.add(cardNum);
                count++;
            }
        }
    }

    private  int getUniqueNumber(){
        return random.nextInt(54);
    }

    public Drawable getGritonCard(){
        return gritonCards.pop();
    }
    public Drawable getPlayerCard(){
        return playerCards.pop();
    }
}
