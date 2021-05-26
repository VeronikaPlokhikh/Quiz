package space.plokhikh_v_v.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level",1);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Здесь будет команда для кнопки

                // начало конструкции
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent); finish();
                } catch (Exception e) {

                }
                //конец конструкции
            }
        });

        //кнопка для перехода на первый уровень - начало
        Button textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=1) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 1);
                        startActivity(intent);

                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на первый уровень - конец

        //кнопка для перехода на второй уровень - начало
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=2) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 2);
                        startActivity(intent);
                        finish();
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на второй уровень - конец

        //кнопка для перехода на третий уровень - начало
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=3) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 3);
                        startActivity(intent);
                        finish();
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на третий уровень - конец

        //кнопка для перехода на четвертый уровень - начало
        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=4) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 4);
                        startActivity(intent);
                        finish();
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на четвертый уровень - конец

        //кнопка для перехода на пятый уровень - начало
        TextView textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=5) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 5);
                        startActivity(intent);
                        finish();
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на  уровень пятый- конец

        //кнопка для перехода на шестой уровень - начало
        TextView textView6 = (TextView)findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=6) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 6);
                        startActivity(intent);
                        finish();
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на  уровень шестой- конец

        //кнопка для перехода на седьмой уровень - начало
        TextView textView7 = (TextView)findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=7) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 7);
                        startActivity(intent);
                        finish();
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на  уровень седьмой- конец

        //кнопка для перехода на восьмой уровень - начало
        TextView textView8 = (TextView)findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=8) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 8);
                        startActivity(intent);
                        finish();
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на  уровень восьмой- конец

        //кнопка для перехода на девятый уровень - начало
        TextView textView9 = (TextView)findViewById(R.id.textView9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=9) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 9);
                        startActivity(intent);
                        finish();
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на  уровень девять- конец

        //кнопка для перехода на деcятый уровень - начало
        TextView textView10 = (TextView)findViewById(R.id.textView10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=10) {
                        Intent intent = new Intent(GameLevels.this, LevelUniversal.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 10);
                        startActivity(intent);
                        finish();
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //кнопка для перехода на  уровень деcять- конец
        final int[] x = {
            R.id.textView1,
            R.id.textView2,
            R.id.textView3,
            R.id.textView4,
            R.id.textView5,
            R.id.textView6,
            R.id.textView7,
            R.id.textView8,
            R.id.textView9,
            R.id.textView10,
        };
        for (int i=1; i<level; i++){
            TextView tv = findViewById(x[i]);
            tv.setText(""+(i+1));
        }

    }
    //системная кнопка "назад"- начало
    @Override
    public void onBackPressed (){
        // начало конструкции
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent); finish();
        } catch (Exception e) {

        }
        //конец конструкции
    }
    //системная кнопка "назад"- конец
}