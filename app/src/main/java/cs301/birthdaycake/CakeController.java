package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    private CakeView myView;
    private CakeModel model;

    public CakeController(CakeView myView) {
        this.myView = myView;
        model = myView.getModel();
    }

    @Override
    public void onClick(View view) {
        Log.d("button","I am clicked");
        model.isLit = false;
        myView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (model.hasCandles) {
            model.hasCandles = false;
        } else {
            model.hasCandles = true;
        }
        myView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        model.numCandle = i;
        myView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        model.coordX = motionEvent.getX();
        model.coordY = motionEvent.getY();
        String coordinate = model.coordX + ", " + model.coordY;
        myView.invalidate();
        return false;
    }
}
