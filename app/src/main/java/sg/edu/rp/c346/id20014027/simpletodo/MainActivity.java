package sg.edu.rp.c346.id20014027.simpletodo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etToDo;
    Button btnAdd;
    Button btnClear;
    ListView lvToDo;
    ArrayList<String> alTodo;
    ArrayAdapter<String> aaToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToDo = findViewById(R.id.editToDo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvToDo = findViewById(R.id.listViewToDo);
        alTodo = new ArrayList<>();
        aaToDo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTodo);
        lvToDo.setAdapter(aaToDo);

        btnAdd.setOnClickListener(view -> {
            String ToDo = etToDo.getText().toString();
            alTodo.add(ToDo);
            aaToDo.notifyDataSetChanged();
            etToDo.getText().clear();
        });

        btnClear.setOnClickListener(view -> {
            alTodo.clear();
            aaToDo.notifyDataSetChanged();
        });
    }
}