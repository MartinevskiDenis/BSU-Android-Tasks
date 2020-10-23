package by.bsu.android_lab1;

import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent = getIntent();
        Button button = (Button) findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.editTextNumberSigned);
        final TextView textView = (TextView) findViewById(R.id.textView);
        if (intent.getStringExtra("prevResult") != null) {
            textView.setText(intent.getStringExtra("prevResult"));
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldValue = textView.getText().toString();
                String inputNmb = editText.getText().toString();
                try{
                    Integer newValue = Service.calcSum(oldValue, inputNmb);
                    Intent newIntent = new Intent(MainActivity.this, SecondActivity.class);
                    newIntent.putExtra("prevResult", String.valueOf(newValue));
                    startActivity(newIntent);
                } catch (NullPointerException | IllegalArgumentException e) {
                    Toast.makeText(getApplicationContext(), "Введите число", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}