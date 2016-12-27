package me.wluo.imhere.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by niwei on 2016/12/27.
 */

public class MainEditText extends EditText {
    private static final String SIYUAN = "fonts/8pinmatrix.TTF";

    public MainEditText(Context context) {
        super(context);
        init(context);
    }

    public MainEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MainEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        AssetManager assets = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(assets, SIYUAN);
        setTypeface(typeface);
    }
}
