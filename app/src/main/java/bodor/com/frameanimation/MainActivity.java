package bodor.com.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_start,button_stop;
    private ImageView imageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_stop = (Button) findViewById(R.id.buttonstop);
        button_start = (Button) findViewById(R.id.buttonrun);
        imageView = (ImageView) findViewById(R.id.imageview);
        if (imageView==null) throw new AssertionError();
        imageView.setBackgroundResource(R.drawable.fly_animation);

        animationDrawable = (AnimationDrawable) imageView.getBackground();
        imageView.setVisibility(View.INVISIBLE);


        button_start.setOnClickListener(this);
        button_stop.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonrun:
                imageView.setVisibility(View.VISIBLE);
                if (!animationDrawable.isRunning())
                animationDrawable.start();
                break;
            case R.id.buttonstop:
                imageView.setVisibility(View.VISIBLE);
                if (animationDrawable.isRunning())
                    animationDrawable.stop();
                break;
        }
    }
}
