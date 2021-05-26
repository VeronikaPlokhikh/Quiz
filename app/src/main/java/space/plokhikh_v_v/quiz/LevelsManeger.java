package space.plokhikh_v_v.quiz;

public class LevelsManeger {


    //Массив для первого уровня -начало
    private final int[] images1 = {
            R.drawable.level_zero,
            R.drawable.level_one,
            R.drawable.level_two,
            R.drawable.level_three,
            R.drawable.level_four,
            R.drawable.level_five,
            R.drawable.level_six,
            R.drawable.level_seven,
            R.drawable.level_eight,
            R.drawable.level_nine,
    };



   private final int[] texts1 = {
            R.string.lvl1text0,
            R.string.lvl1text1,
            R.string.lvl1text2,
            R.string.lvl1text3,
            R.string.lvl1text4,
            R.string.lvl1text5,
            R.string.lvl1text6,
            R.string.lvl1text7,
            R.string.lvl1text8,
            R.string.lvl1text9,
    };

    //Массив для первого уровня -конец

    //Массив для второго уровня -начало
    private final int[] images2 = {
            R.drawable.twolevel_one,
            R.drawable.twolevel_two,
            R.drawable.twolevel_three,
            R.drawable.twolevel_four,
            R.drawable.twolevel_five,
            R.drawable.twolevel_six,
            R.drawable.twolevel_seven,
            R.drawable.twolevel_eight,
            R.drawable.twolevel_nine,
            R.drawable.twolevel_ten,
    };



    private final int[] texts2 = {
            R.string.lvl2text1,
            R.string.lvl2text2,
            R.string.lvl2text3,
            R.string.lvl2text4,
            R.string.lvl2text5,
            R.string.lvl2text6,
            R.string.lvl2text7,
            R.string.lvl2text8,
            R.string.lvl2text9,
            R.string.lvl2text10,
    };

    //Массив для второго уровня -конец

    //Массив для третьего уровня -начало
    final int[] images3 = {
            R.drawable.three_level1, R.drawable.three_level2,R.drawable.three_level3, R.drawable.three_level4, R.drawable.three_level5,
            R.drawable.three_level6, R.drawable.three_level7, R.drawable.three_level8, R.drawable.three_level9, R.drawable.three_level10,
            R.drawable.three_level11, R.drawable.three_level12, R.drawable.three_level13, R.drawable.three_level14, R.drawable.three_level15,
            R.drawable.three_level16, R.drawable.three_level17, R.drawable.three_level18, R.drawable.three_level19, R.drawable.three_level20,
            R.drawable.three_level21,

    };



    final int[] texts3 = {
            R.string.lvl3text1, R.string.lvl3text2, R.string.lvl3text3, R.string.lvl3text4,R.string.lvl3text5, R.string.lvl3text6,
            R.string.lvl3text7, R.string.lvl3text8, R.string.lvl3text9, R.string.lvl3text10, R.string.lvl3text11, R.string.lvl3text12,
            R.string.lvl3text13, R.string.lvl3text14, R.string.lvl3text15, R.string.lvl3text16, R.string.lvl3text17, R.string.lvl3text18,
            R.string.lvl3text19, R.string.lvl3text20, R.string.lvl3text21,

    };

    //Массив для третьего уровня -конец

    private final  int [][]allImeges = {
            images1, images2, images3,
    };


    private final  int [][]allText = {
            texts1, texts2, texts3,
    };
    private int level;
    public LevelsManeger (int l){
        level = l;
    }
    public int[] getImages(){
        return allImeges[level];
    }
    public int[] getTexts(){
        return allText[level];
    }
}

