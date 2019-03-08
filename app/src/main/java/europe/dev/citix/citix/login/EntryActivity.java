package europe.dev.citix.citix.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import europe.dev.citix.citix.MainActivity;
import europe.dev.citix.citix.R;

public class EntryActivity extends AppCompatActivity {

    private Button mLogin;
    private Button mRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        mLogin = findViewById(R.id.email_sign_in_button);
        mRegister = findViewById(R.id.register);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EntryActivity.this, LoginActivity.class));
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EntryActivity.this, RegisterActivity.class));
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}
