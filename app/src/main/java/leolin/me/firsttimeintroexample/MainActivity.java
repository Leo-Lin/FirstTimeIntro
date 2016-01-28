package leolin.me.firsttimeintroexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Android的簡易儲存空間
        preferences = getSharedPreferences("introduction", MODE_PRIVATE);

        //進入Activity後，檢查是否有看過教學
        boolean seenIntroduction = preferences.getBoolean("SeenIntroduction", false);
        if (seenIntroduction == false) {
            //如果沒有，則顯示教學
            View introduction1 = findViewById(R.id.intro1);
            introduction1.setVisibility(View.VISIBLE);
        }
    }

    public void goIntro2(View view) {
        View introduction1 = findViewById(R.id.intro1);
        View introduction2 = findViewById(R.id.intro2);
        introduction1.setVisibility(View.GONE);
        introduction2.setVisibility(View.VISIBLE);
    }

    public void endIntro(View view) {
        View introduction2 = findViewById(R.id.intro2);
        introduction2.setVisibility(View.GONE);

        //看完教學，儲存此user已經看過教學
        preferences.edit().putBoolean("SeenIntroduction", true);
    }
}
