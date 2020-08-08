package jlexdev.com.dialogshp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import jlexdev.com.dialogshp.R;
import jlexdev.com.dialogshp.dialogs.SimpleDialog;
import jlexdev.com.dialogshp.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements
        SimpleDialog.OnSimpleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if  (savedInstanceState == null){
            MainFragment mainFragment = new MainFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, mainFragment, "MainFragment")
                    .commit();
        }
    }


    @Override
    public void onPossitiveButtonClick() {
        Toast.makeText(
                this,
                "Botón Positivo Pulsado",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(
                this,
                "Botón Negativo Pulsado",
                Toast.LENGTH_SHORT)
                .show();
    }
}
