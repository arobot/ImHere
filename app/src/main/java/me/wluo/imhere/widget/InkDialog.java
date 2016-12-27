package me.wluo.imhere.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import me.wluo.imhere.R;

/**
 * Created by niwei on 2016/12/27.
 */

public class InkDialog extends Dialog {
    public InkDialog(Context context) {
        super(context);
    }

    public InkDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {
        private Context context;
        private String title;
        private String msg;
        private String positiveButtonText;
        private String negativeButtonText;
        private View contentView;
        private OnClickListener positiveClickListener;
        private OnClickListener negativeClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder setMessage(int message) {
            this.msg = (String) context.getText(message);
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setContentView(View v) {
            this.contentView = v;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText, DialogInterface.OnClickListener listener) {
            this.positiveButtonText = (String) context.getText(positiveButtonText);
            this.positiveClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText, OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText, OnClickListener listener) {
            this.negativeButtonText = (String) context.getText(negativeButtonText);
            this.negativeClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText, OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeClickListener = listener;
            return this;
        }

        public InkDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final InkDialog dialog = new InkDialog(context, R.style.Dialog);
            View layout = inflater.inflate(R.layout.ink_dialog_layout, null);
            dialog.addContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            //Title
            MainTextView titleTv = ((MainTextView) layout.findViewById(R.id.dialog_title));
            if ("".equals(title)) {
                titleTv.setVisibility(View.GONE);
            } else {
                titleTv.setText(title);
            }
            // set the confirm button
            MainTextView positiveBtn = ((MainTextView) layout.findViewById(R.id.dialog_positive_button));
            if (positiveButtonText != null) {
                positiveBtn.setText(positiveButtonText);
                if (positiveClickListener != null) {
                    positiveBtn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            positiveClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        }
                    });
                }
            } else {
                // if no confirm button just set the visibility to GONE
                positiveBtn.setVisibility(View.GONE);
            }
            // set the cancel button
            MainTextView negativeBtn = ((MainTextView) layout.findViewById(R.id.dialog_negative_button));
            if (negativeButtonText != null) {
                negativeBtn.setText(negativeButtonText);
                if (negativeClickListener != null) {
                    negativeBtn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            negativeClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                        }
                    });
                }
            } else {
                // if no confirm button just set the visibility to GONE
                negativeBtn.setVisibility(View.GONE);
            }
            if (positiveButtonText != null && negativeButtonText != null) {
                layout.findViewById(R.id.dialog_btn_divider).setVisibility(View.VISIBLE);
            }
            if (positiveButtonText == null && negativeButtonText == null) {
                layout.findViewById(R.id.dialog_content_btn_divider).setVisibility(View.GONE);
            }

            MainTextView msgTv = (MainTextView) layout.findViewById(R.id.dialog_msg);
            if ("".equals(msg) || msg == null) {
                msgTv.setVisibility(View.GONE);

            } else if (contentView != null) {
                // if no message set
                // add the contentView to the dialog body
                ((LinearLayout) layout.findViewById(R.id.dialog_content))
                        .removeAllViews();
                ((LinearLayout) layout.findViewById(R.id.dialog_content)).addView(
                        contentView, new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
            } else {
                msgTv.setText(msg);
            }
            return dialog;
        }
    }
}
