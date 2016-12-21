package me.wluo.imhere.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by niwei on 2016/12/21.
 */

public class LedTextView extends TextView {
    private static final String DS_DIGIT_FONT = "fonts/DS-DIGIT.TTF";

    public LedTextView(Context context) {
        super(context);
        init(context);
    }

    public LedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LedTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        AssetManager assets = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(assets, DS_DIGIT_FONT);
        setTypeface(typeface);
    }
}
