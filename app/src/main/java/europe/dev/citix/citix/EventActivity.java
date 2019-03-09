package europe.dev.citix.citix;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import europe.dev.citix.citix.adapters.ViewPagerAdapter;

public class EventActivity extends AppCompatActivity {
    ViewPager viewPager;
    private TextView going;
    private TextView intersted;
    private ImageView back;
    private TextView stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        going = findViewById(R.id.textView6);
        intersted = findViewById(R.id.textView7);
        back = findViewById(R.id.back);
        stats = findViewById(R.id.textView8);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);
        _setClickHandlersText();
        setBackListener();
        populateUI();
        setStats();
    }

    @Override
    public void onBackPressed() {
        Intent home_intent = new Intent(this, MainActivity.class);
        startActivity(home_intent);
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
        finish();
    }

    private void _setClickHandlersText() {
        final int Green = Color.parseColor("#075E18");
        going.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intersted.getCurrentTextColor() == -1)
                    if (going.getCurrentTextColor() != Green) {
                        going.setTextColor(Color.parseColor("#075E18"));
                        postGoing(true);
                    } else {
                        going.setTextColor(Color.parseColor("#ffffff"));
                        postGoing(false);
                    }

                else {
                    intersted.setTextColor(Color.parseColor("#ffffff"));
                    if (going.getCurrentTextColor() != Green) {
                        going.setTextColor(Color.parseColor("#075E18"));
                        postGoing(true);
                    } else {
                    }
                    postGoing(true);
                    going.setTextColor(Color.parseColor("#075E18"));
                }
            }
        });
        intersted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (going.getCurrentTextColor() == -1)
                    if (intersted.getCurrentTextColor() != Green) {
                        intersted.setTextColor(Color.parseColor("#075E18"));
                        postIntersted(true);
                    } else {
                        intersted.setTextColor(Color.parseColor("#ffffff"));
                        postIntersted(false);
                    }
                else {
                    going.setTextColor(Color.parseColor("#ffffff"));
                    if (intersted.getCurrentTextColor() != Green) {
                        intersted.setTextColor(Color.parseColor("#075E18"));
                        postIntersted(true);
                    } else {
                    }
                    postIntersted(true);
                    intersted.setTextColor(Color.parseColor("#075E18"));
                }
            }
        });
    }

    private void setBackListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setStats(){
        //make the request
        stats.setText("29 Intersted | 125 Going ");
    }

    private void postGoing(boolean reaction) {
    }

    private void postIntersted(boolean reaction) {
    }

    private void populateUI() {

    }

}
