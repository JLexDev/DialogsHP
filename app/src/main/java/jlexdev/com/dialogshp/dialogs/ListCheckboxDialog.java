package jlexdev.com.dialogshp.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JLex on 2/11/16.
 */

public class ListCheckboxDialog extends android.support.v4.app.DialogFragment {

    public ListCheckboxDialog() {
    }



    public Dialog onCreateDialog(Bundle savedInstanceState){
        return createCheckboxListDialog();
    }


    /** Crea un Diálogo con una lista de Checkboxes de selección mútiple
     *
     * @return Diálogo
     */
    private Dialog createCheckboxListDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final ArrayList itemsSeleccionados = new ArrayList();

        CharSequence[] items = new CharSequence[3];

        items[0] = "Desarrollo Android";
        items[1] = "Desarrollo iOS";
        items[2] = "Desarrollo Web";

        builder
                .setTitle("Intereses")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        if (isChecked){
                            // Guardo índice seleccionado
                            itemsSeleccionados.add(which);
                            Toast.makeText(getActivity(),
                                    "Checks seleccionados: (" + itemsSeleccionados.size() + ")", Toast.LENGTH_SHORT).show();
                        } else if (itemsSeleccionados.contains(which)){
                            // Remover índice sin selección
                            itemsSeleccionados.remove(Integer.valueOf(which));
                        }
                    }
                });

        return builder.create();
    }

}
