package com.ingic.template.helpers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ingic.template.R;

public class UIHelper {
    private static long lastClickTime;
    private static Toast toast;

    public static void showLongToastInCenter(Context ctx, int messageId) {
        if (ctx == null) return;
        if (toast != null) toast.cancel();
        toast = Toast.makeText(ctx, messageId, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showLongToastInCenter(Context ctx, String message) {
        if (ctx == null || message == null) return;
        if (toast != null) toast.cancel();
        toast = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showShortToastInCenter(Context ctx, String message) {
        if (ctx == null || message == null) return;
        if (toast != null) toast.cancel();
        toast = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showConnectionFailedToast(Context ctx) {
        showLongToastInCenter(ctx, R.string.msg_connection_failed);
    }

    public static void showConnectionErrorToast(Context ctx) {
        showLongToastInCenter(ctx, R.string.msg_connection_error);
    }

    public static void hideSoftKeyboard(Context context, EditText editText) {

        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

    }

    public static void hideSoftKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public static void showAlertDialog(String message, CharSequence title,
                                       Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setTitle(title)
                .setCancelable(true)
                .setNegativeButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    // public static void showSelectMultiple(Context ctx, BaizaContacts
    // baizaContact){
    // final Context _ctx = ctx;
    // final BaizaContacts _baizaContact = baizaContact;
    //
    // AlertDialog ad = new AlertDialog.Builder(_ctx)
    // .setTitle("Select Phone Number")
    // .setCancelable(false)
    // .setSingleChoiceItems(baizaContact.getPhoneNumbersAsCharSequence(), 0,
    // new DialogInterface.OnClickListener() {
    //
    // @Override
    // public void onClick(DialogInterface dialog, int which) {
    // dialog.dismiss();
    // _baizaContact.setSelectedNumber(which);
    // }
    // })
    // .create();
    // ad.show();
    // }

    public static Rect locateView(View v) {
        int[] loc_int = new int[2];
        if (v == null)
            return null;
        try {
            v.getLocationOnScreen(loc_int);
        } catch (NullPointerException npe) {
            // Happens when the view doesn't exist on screen anymore.
            return null;
        }
        Rect location = new Rect();
        location.left = loc_int[0];
        location.top = loc_int[1];
        location.right = location.left + v.getWidth();
        location.bottom = location.top + v.getHeight();
        return location;
    }

    public static void textMarquee(TextView txtView) {
        // Use this to marquee Textview inside listview

        txtView.setEllipsize(TruncateAt.END);
        // Enable to Start Scroll

        // txtView.setMarqueeRepeatLimit(-1);
        // txtView.setHorizontallyScrolling(true);
        // txtView.setSelected(true);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static int getScreenWidth(Activity ctx) {
        Display display = ctx.getWindowManager().getDefaultDisplay();

        if (OSHelper.hasHoneycombMR2()) {
            Point size = new Point();
            display.getSize(size);
            return size.x;
        } else {
            return display.getWidth();
        }

    }

    public static void dimBehind(Dialog dialog) {
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.9f;
        dialog.getWindow()
                .addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.setCancelable(false);
    }

    public static boolean doubleClickCheck() {
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000) {
            return false;
        }
        lastClickTime = SystemClock.elapsedRealtime();
        return true;
    }
}
