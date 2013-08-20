package ru.hw_team.lev.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * @author Oleg Illiashenko
 *         Email: ctanok@gmail.com
 *         Date: 20.08.13
 */
public class DialogUtility {

    private static AlertDialog alert = null;

    public static void showChooseDialog(Context context, String message, String positiveButtonText,
                                        String negativeButtonText, final OnChooseListener onChooseListener) {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(context);

        localBuilder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(positiveButtonText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                DialogUtility.alert.dismiss();
                                onChooseListener.choosePositive();
                            }
                        })
                .setNegativeButton(negativeButtonText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                DialogUtility.alert.dismiss();
                                onChooseListener.chooseNegative();
                            }
                        });
        alert = localBuilder.create();
        alert.show();
    }
}
