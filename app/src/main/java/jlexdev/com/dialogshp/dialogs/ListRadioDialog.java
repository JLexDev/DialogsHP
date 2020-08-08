package jlexdev.com.dialogshp.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by JLex on 2/11/16.
 */

public class ListRadioDialog extends android.support.v4.app.DialogFragment {

    public ListRadioDialog() {
    }



    public Dialog onCreateDialog(Bundle savedInstanceState){
        return createRadioListDialog();
    }


    /** Crea un Diálogo con una lista de radios
     *
     * @return Diálogo
     */
    private Dialog createRadioListDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final CharSequence[] items = new CharSequence[3];

        items[0] = "Soltero/a";
        items[1] = "Casado/a";
        items[2] = "Divorciado/a";

        builder
                .setTitle("Estado Civil")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),
                                "Seleccionaste: " + items[which], Toast.LENGTH_SHORT).show();
                    }
                });

        return builder.create();
    }

}
