package imageloader.skripsi.abyansafitra.skripsipowerconsumption;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button buttonPicasso, buttonGlide, buttonUIL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        buttonPicasso = (Button) findViewById(R.id.btnPicasso);
        buttonGlide = (Button) findViewById(R.id.btnGlide);
        buttonUIL = (Button) findViewById(R.id.btnUIL);

        buttonPicasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPicasso = new Intent(Home.this, MainActivityPicasso.class);
                startActivity(toPicasso);

            }
        });
        buttonGlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toGlide = new Intent(Home.this, MainActivityGlide.class);
                startActivity(toGlide);
            }
        });

        buttonUIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toUIL = new Intent(Home.this, MainActivityUIL.class);
                startActivity(toUIL);
            }
        });

    }
}
