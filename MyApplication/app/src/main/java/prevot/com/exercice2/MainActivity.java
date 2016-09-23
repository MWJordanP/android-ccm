package prevot.com.exercice2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private EditText editText;
    private Button button;
    private TextView textView;

    List<Integer> listInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.id_plain);
        button = (Button) findViewById(R.id.id_button_submit);
        textView = (TextView) findViewById(R.id.id_text_view_value);
        listInt = new ArrayList<>();
    }

    public void submitMemory(View view) {
        try {
            int e = Integer.parseInt(editText.getText().toString());
            listInt.add(e);
            editText.setText("");
        } catch (NumberFormatException e1) {
            editText.setText("");
        }
    }

    public void onClickCalcul(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("number", listInt.size());
        for (int i = 0; i < listInt.size(); i++) {
            String key = "key_" + i;
            intent.putExtra(key, listInt.get(i));
        }
        startActivityForResult(intent, 13);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            int resultat = data.getExtras().getInt("value");
            textView.setText("" + resultat);
        }
    }
}
