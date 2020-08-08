package jlexdev.com.dialogshp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import jlexdev.com.dialogshp.R;
import jlexdev.com.dialogshp.dialogs.ListCheckboxDialog;
import jlexdev.com.dialogshp.dialogs.ListRadioDialog;
import jlexdev.com.dialogshp.dialogs.LoginDialog;
import jlexdev.com.dialogshp.dialogs.SimpleDialog;
import jlexdev.com.dialogshp.dialogs.SimpleListDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private ListView lstDialogs;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        lstDialogs = (ListView)v.findViewById(R.id.lst_dialogs);

        // Datos de la Lista
        final String[] data = {
                "Diálogo Simple",
                "Diálogo con Lista Simple",
                "Diálogo con Lista de Radios",
                "Diálogo con Lista de CheckBoxes",
                "Diálogo Personalizado",
                "DatePickerDialog",
                "TimePickerDialog",
                "Diálogo Full Screen"
        };

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_dialogs,
                R.id.tv_item_list,
                data
        );

        lstDialogs.setAdapter(arrayAdapter);


        // Asignar acciones
        lstDialogs.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Obtengo el manejador de fragmentos /// Si fuera Activity y No Fragment: getSupportFragmentManager()
                        FragmentManager fragmentManager = getFragmentManager();

                        switch (position){
                            case 0:
                                new SimpleDialog().show(fragmentManager, "SimpleDialog");
                                break;
                            case 1:
                                new SimpleListDialog().show(fragmentManager, "SimpleListDialog");
                                break;
                            case 2:
                                new ListRadioDialog().show(fragmentManager, "ListRadioDialog");
                                break;
                            case 3:
                                new ListCheckboxDialog().show(fragmentManager, "ListCheckboxDialog");
                                break;
                            case 4:
                                new LoginDialog().show(fragmentManager, "LoginDialog");



                        }
                    }
                }
        );


        return v;
    }











}
