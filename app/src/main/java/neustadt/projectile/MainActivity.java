package neustadt.projectile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView angle;
    private EditText angle_entry;
    private TextView velocity;
    private EditText velocity_entry;
    private TextView time;
    private EditText time_entry;
    private Button calculate;
    private TextView distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angle = (TextView) findViewById(R.id.angle);
        angle_entry = (EditText) findViewById(R.id.angle_entry);
        final String angleText = angle_entry.getText().toString();

        velocity = (TextView) findViewById(R.id.velocity);
        velocity_entry = (EditText) findViewById(R.id.velocity_entry);
        time = (TextView) findViewById(R.id.time);
        time_entry = (EditText) findViewById(R.id.time_entry);
        calculate = (Button) findViewById(R.id.calculate);
        distance = (TextView) findViewById(R.id.distance);

        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(this, DisplayMessageActivity.class);
                distance.setText(calculate());
                         }
        });
         }
public String calculate() {
    double angle = Double.parseDouble(angle_entry.getText().toString());
    double velocity = Double.parseDouble(velocity_entry.getText().toString());
    double time = Double.parseDouble(time_entry.getText().toString());
    double radians = Math.toRadians(angle);
    double x = Math.sin(radians) * velocity * time;
    double y = Math.cos(radians) * velocity * time
            - (.5 * 9.8 * time * time);
    return "(" + x + "," + y + ")";
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
