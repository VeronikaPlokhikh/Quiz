package space.plokhikh_v_v.quiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class LevelUniversal extends AppCompatActivity {
    public static final String LEVEL_ARG = "level";
    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft; //Переменная для левой картинки + текст
    public int numRight; //Переменная для правой картинки + текст
    private LevelsManeger levelsManeger;
    Random random = new Random();//для генерации случайных чисел
    public int count = 0; //счетчик правл.ответов
    private ImageView img_left;
    private ImageView img_right;
    private TextView text_left;
    private TextView text_right;
    private Animation a;
    private ProgressBar progressBar;



    private void generateNewQuestion(){
        numLeft = random.nextInt(10);//Генерирую случайные числа от 0 и 9
        img_left.setImageResource(levelsManeger.getImages()[numLeft]);//достаем из масива картинку
        img_left.startAnimation(a);
        text_left.setText(levelsManeger.getTexts()[numLeft]);//достаем из масива текст

        numRight = random.nextInt(10);

        //цикл с предусловием, проверяющий равенство чисел - начало
        while (numLeft==numRight){
            numRight = random.nextInt(10);
        }
        //цикл с предусловием, проверяющий равенство чисел - конец

        img_right.setImageResource(levelsManeger.getImages()[numRight]);//достаем из масива картинку
        img_right.startAnimation(a);
        text_right.setText(levelsManeger.getTexts()[numRight]);//достаем из масива текст

    }
    public void processAnswer(boolean isRight){
        //Если отпустил палец - начало
        if (isRight){
            //Если левая картинка больше
            if (count<20){
                count=count+1;
            }

            //Опред. прав. ответы и закрашиваем зеленым - конец
        }else{
            //Если левая картинка меньше
            if (count>0){
                if(count==1){
                    count=0;
                }else{
                    count=count-2;
                }
            }

            //Опред. прав. ответы и закрашиваем зеленым - конец
        }
        progressBar.setProgress(count);
        //Если отпустил палец - конец
        if(count==20){
            //ВЫХОД ИЗ УРОВНЯ
            dialogEnd.show();
        }else{
            generateNewQuestion();

            img_right.setEnabled(true);//Включаем назад праавую картинку
            img_left.setEnabled(true);//Включаем назад левую картинку
        }

    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        progressBar = findViewById(R.id.progress1);
        progressBar.setMax(20);
        progressBar.setProgress(0);
        int level = getIntent().getIntExtra(LEVEL_ARG, 1)-1;
        levelsManeger = new LevelsManeger(level);
        //создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);

        img_left = (ImageView) findViewById(R.id.image_left);
        //код который скругляет углы левой картинки
        // img_left.setClipToOutline(true);

        img_right = (ImageView) findViewById(R.id.image_right);
        //код который скругляет углы правой картинки
        // img_right.setClipToOutline(true);

        //путь к левой TextView
        text_left = findViewById(R.id.text_left);
        //путь к правой TextView
        text_right = findViewById(R.id.text_right);

        //развернуть игру на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //развернуть игру на весь экран - конец

        //Вызов диалогового окна в начале
        dialog = new Dialog(this);//создаю новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываю заголовок
        dialog.setContentView(R.layout.previewdialog);//путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалог.окну
        dialog.setCancelable(false);//окно не закроется кнопкой "Назад"

        //Кнопка которая должна закрыть диалог.окно-начало
        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обрабатываю нажатие конпки-начало
                try {
                    //вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(LevelUniversal.this, GameLevels.class);
                    startActivity(intent);
                    //вернуться назад к выбору уровня - конец
                } catch (Exception e) {
                    //здесь кода не будет
                }
                dialog.dismiss();
                //обрабатываю нажатие конпки-конец
            }
        });
        //Кнопка которая должна закрыть диалог.окно-конец

        //Кнопка "Продолжить" - начало
        Button btncontinue = (Button) dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        //Кнопка "Продолжить" - конец
        dialog.show();//показать диалог.окно
        
        
        //______________________________________________________________________
        //Вызов диалогового окна в конце
        dialogEnd = new Dialog(this);//создаю новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываю заголовок
        dialogEnd.setContentView(R.layout.dialogend);//путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалог.окну
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);//окно не закроется кнопкой "Назад"

        //Кнопка которая должна закрыть диалог.окно-начало
        TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обрабатываю нажатие конпки-начало
                try {
                    //вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(LevelUniversal.this, GameLevels.class);
                    startActivity(intent);
                    //вернуться назад к выбору уровня - конец
                } catch (Exception e) {
                    //здесь кода не будет
                }
                dialogEnd.dismiss();
                //обрабатываю нажатие конпки-конец
            }
        });
        //Кнопка которая должна закрыть диалог.окно-конец

        //Кнопка "Продолжить" - начало
        Button btncontinue2 = (Button) dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=10) {
                        Intent intent = new Intent(LevelUniversal.this, GameLevels.class);
                        intent.putExtra(LevelUniversal.LEVEL_ARG, 10);
                        startActivity(intent);
                    }else{
                        //пусто
                    }
                }catch (Exception e){
                    //Здесь кода не будет
                }
                dialogEnd.dismiss();
            }
        });

        //Кнопка "Продолжить" - конец

        //______________________________________________________________________

        //Кнопка "Назад" - начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Обрабатываю нажатие "Назад" - начало
                try {
                    //Вернуться назад - начало
                    finish();
                    //Вернуться назад - конец
                } catch (Exception e) {
                    //Здесь кода не будет
                }
                //Обрабатываю нажатие "Назад" - конец
            }
        });
        //Кнопка "Назад" - конец


        //Подключаем Анимацию - начало
         a = AnimationUtils.loadAnimation(LevelUniversal.this, R.anim.alpha);
        //Подключаем Анимацию - конец


        generateNewQuestion();


        //обрабатываю нажатие на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касания картинки - начало
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //Если коснулся пальцем картинки - начало
                    img_right.setEnabled(false);//блокируем правую картинку
                    if (numLeft>numRight) {
                        img_left.setImageResource(R.drawable.img_true);
                    }else{
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    //Если коснулся пальцем картинки - конец
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    processAnswer(numLeft>numRight);
                }
                //Условие касания картинки - конец
                return true;
            }
        });

        //обрабатываю нажатие на левую картинку - конец

        //обрабатываю нажатие на правую картинку - начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Условие касания картинки - начало
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //Если коснулся пальцем картинки - начало
                    img_left.setEnabled(false);//блокируем левую картинку
                    if (numLeft<numRight) {
                        img_right.setImageResource(R.drawable.img_true);
                    }else{
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    //Если коснулся пальцем картинки - конец
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    processAnswer(numLeft<numRight);

                }
                //Условие касания картинки - конец
                return true;
            }
        });



    }


}