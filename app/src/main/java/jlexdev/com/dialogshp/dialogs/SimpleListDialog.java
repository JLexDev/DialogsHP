package jlexdev.com.dialogshp.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by JLex on 21/10/16.
 */

public class SimpleListDialog extends android.support.v4.app.DialogFragment {

    public SimpleListDialog() {
    }



    public Dialog onCreateDialog(Bundle savedInstanceState){
        return createSimpleListDialog();
    }


    /** Crear un Diálogo con una lista de selección simple
     *
     * @return La instancia del diálogo
     */
    public AlertDialog createSimpleListDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final CharSequence[] items = new CharSequence[3];

        items[0] = "Apple";
        items[1] = "Banana";
        items[2] = "Lemon";

        builder
                .setTitle("Diálogo de Lista")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),
                                "Seleccionaste: " + items[which], Toast.LENGTH_SHORT).show(); // "which" indica el índice seleccionado
                    }
                });

        return  builder.create();
    }


}
