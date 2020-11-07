package by.bsu.android_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.buttonOK);
        final EditText editText = (EditText) findViewById(R.id.inputNumber);
        final TextView textView = (TextView) findViewById(R.id.number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldValue = textView.getText().toString();
                String inputNmb = editText.getText().toString();
                if (!inputNmb.equals("")) {
                    Integer newValue = Service.calcSum(oldValue, inputNmb);
                    Intent newIntent = new Intent(MainActivity.this, SecondActivity.class);
                    newIntent.putExtra(Constants.EXTRA_KEY, String.valueOf(newValue));
                    startActivityForResult(newIntent, Constants.REQUEST_CODE);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.errorText, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Integer prevResult = Integer.valueOf(data.getStringExtra(Constants.EXTRA_KEY));
                final TextView textView = (TextView) findViewById(R.id.number);
                final EditText editText = (EditText) findViewById(R.id.inputNumber);
                editText.setText("0");
                textView.setText(prevResult.toString());
            }
        }
    }
}