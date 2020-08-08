package jlexdev.com.dialogshp.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by JLex on 21/10/16.
 */

public class SimpleDialog extends android.support.v4.app.DialogFragment{

    public SimpleDialog() {
    }

    /* Declaración de interfaz de comunicación */
    // Permite compartir los métodos de acción
    public interface OnSimpleDialogListener{
        void onPossitiveButtonClick();
        void onNegativeButtonClick();
    }

    // Consigue la instancia de la actividad
    OnSimpleDialogListener listener; // Declara un atributo del tipo de la interfaz



    public Dialog onCreateDialog(Bundle savedIntanceState){
        return createSimpleDialog();
    }



    /** Método Diálogo de Alerta Sencillo
     *
     * @return Nuevo Diálogo
     */
    private Dialog createSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder
                .setTitle("Título")
                .setMessage("El mensaje para el usuario")
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                listener.onPossitiveButtonClick();
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                listener.onNegativeButtonClick();
                            }
                        })
        /**     .setNeutralButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // Acción
                            }
                        })
        */
        ;

        return builder.create();
    }


    /* Comprueba que la actividad ha implementado la interfaz */
    // Recibe la instancia de la actividad contenedora del fragmento
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (OnSimpleDialogListener) context;
        } catch (ClassCastException e){ // Si no es posible, lanzo el Exception
            throw new ClassCastException(
                    context.toString() +
                            "No implementó OnSimpleDialogListener");
        }
    }

}
