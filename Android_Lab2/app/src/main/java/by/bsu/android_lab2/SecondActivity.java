package by.bsu.android_lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Button button = (Button) findViewById(R.id.buttonOK);
        final EditText editText = (EditText) findViewById(R.id.inputNumber);
        final TextView textView = (TextView) findViewById(R.id.number);
        textView.setText(intent.getStringExtra(Constants.EXTRA_KEY));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldValue = textView.getText().toString();
                String inputNmb = editText.getText().toString();
                if (!inputNmb.equals("")) {
                    Integer newValue = Service.calcSum(oldValue, inputNmb);
                    Intent newIntent = new Intent(SecondActivity.this, MainActivity.class);
                    newIntent.putExtra(Constants.EXTRA_KEY, String.valueOf(newValue));
                    setResult(Activity.RESULT_OK, newIntent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.errorText, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
