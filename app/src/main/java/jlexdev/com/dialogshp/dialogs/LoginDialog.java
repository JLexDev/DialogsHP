package jlexdev.com.dialogshp.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import jlexdev.com.dialogshp.R;

/**
 * Created by JLex on 2/11/16.
 */

public class LoginDialog extends android.support.v4.app.DialogFragment {

    private static final String TAG = LoginDialog.class.getSimpleName();

    public LoginDialog() {
    }



    public Dialog onCreateDialog(Bundle savedInstanceState){
        return createLoginDialog();
    }


    /** Crea un Diálogo con personalización - Formulario Login
     *
     * @return Diálogo
     */
    private Dialog createLoginDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_login, null);

        builder.setView(v);

        Button signUp = (Button)v.findViewById(R.id.btn_crear_cuenta);
        Button signIn = (Button)v.findViewById(R.id.btn_entrar);

        signUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Crear Cuenta
                        dismiss();
                    }
                }
        );

        signIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Loguear
                        dismiss();
                    }
                }
        );

        return builder.create();
    }

}
