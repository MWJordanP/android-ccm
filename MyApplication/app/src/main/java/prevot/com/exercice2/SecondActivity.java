package prevot.com.exercice2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private int values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int number = bundle.getInt("number", 0);
        values = 0;
        for (int i = 0; i < number; i++) {
            values += bundle.getInt("key_" + i);
        }
        TextView textView = (TextView) findViewById(R.id.id_text_view_call);
        textView.setText("" + values);
    }

    public void quitCall(View view) {
        Intent intentFinish = new Intent(this, MainActivity.class);
        intentFinish.putExtra("value", values);
        setResult(RESULT_OK, intentFinish);
        finish();
    }
}
