package europe.dev.citix.citix.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import europe.dev.citix.citix.EventActivity;
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
                Intent intent_next = new Intent(EntryActivity.this, LoginActivity.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_next = new Intent(EntryActivity.this, RegisterActivity.class);
                startActivity(intent_next);
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}
