package com.example.moustache;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "CPR";

    ImageView wheel_iv, arrow_iv;
    TextView points, pointsTv, questionTv, answerTv, scoresTv;
    EditText pointsEt, letterEt, wordEt;
    Button spinBtn, wordBtn;
    Random r;

    Integer i, i1;

    int oldDegree = 0;
    int curDegree = 0;
    int level = 1;

    String ans;

    String ansDisp;
    char[] ansDispcharArray;

    String q[] = {
            "In the middle of the XIV century, clothes appeared in Russia, which were sewn from the most expensive fabrics. For winter, she was lined with fur. Representatives of the upper classes wore such clothes. What was the name of such clothes?",
            "The clothes of the Chukchi and Eskimos have always been deaf without a cut. The men wore two fur shirts in winter. One with wool on the outside, the other with wool on the inside. What was this shirt called?",
            "The Chukchi and Eskimos have outerwear that protects fur clothing from snow. It is sewn from cotton fabric, tarpaulin or synthetic materials. Previously, the Aleuts sewed these clothes from the intestines of sea animals. What is the name of such clothes?",
            "In the old days, the Pomors made especially warm hats from the skin of a young deer or a young seal. Ethnographers believe that such a Pomor hat was one of the most ancient fur hats in the North. What was the name of the cap of the Pomors?",
            "What is the name of women's winter clothing? This is heartwarming, in different Russian provinces it looked like a jacket, like a vest with sockets on the back. She has several names, most likely, this is a derivative of the name of men's clothing.",
            "Dahl's dictionary says that in the Yaroslavl province this was the name of a women's fur coat. What does this name sound like?",
            "Dahl has the name of a sheepskin coat worn together with an army jacket for warmth, that is, a pair of outer dresses for warmth. How does is called?",
            "In Russia, there was a belief that on the chicken holiday - the day of the Kura and Kurka, a seven-year-old black rooster laid an egg. Who hatched from this egg in the summer, according to legends?",
            "In Old Russia, it was believed that a good rooster should be lively and pugnacious. To do this, he was fed on Maundy Thursday with millet mixed with pepper. And where was the mixture of millet and pepper necessarily poured into?",
            "In Chinese mythology, the symbol of the masculine principle in the Universe is a rooster that sits on a tree? This rooster is not simple, but ... Which one?",
            "Previously, a rooster-crowned chicken was considered the wrong bird. She was grabbed and moved in the house from the table to the threshold in a special way, of what?",
            "On the feast of the Exaltation, cabbage pies were one of the main treats in Russia. Minced meat for them was made liquid and the contents after baking were eaten with spoons. What was the name of such a cake?",
            "In Russia, porridge was cooked not only from whole or crushed grains. There were also flour porridges (cereals made from flour). What was the name of the flour porridge?",
            "Many names for cereals in Russia came from the name of cereals. And this porridge was named after the method of its preparation. What was the name of this porridge?",
            "What was the name of dried radish in old Russia, as well as watermelon or cherries, which were crushed and brewed in molasses with spices?",
            "What was the name of the healer in Kievan Rus who saved people from toothache?",
            "Previously, in Russia, epidemics were fought with the help of a special rite. Young girls or widows harnessed to the plow and drew a line with it around the house, or even around the whole village. What was the name of this rite?",
            "What was the name of the healer in Russia who healed with herbs and roots?",
            "The history of the disease in old Russia was called 'doctor's' ... What?",
            "January 1, old style Vasiliev's day. In the Ryazan province on this day, people walked in droves under the windows and asked for pies. Ahead of all was a girl with a bag for collecting cake. She was considered the leader of the crowd and was in charge of the pie division. How was she called?",
            "August 18, old style Frolov day. In the steppe provinces, from that day, the help began. These are such works to help widows and orphans. At such gatherings, they mowed hay, fertilized the fields, chopped wood, threshed sheaves. And what was the name of the work on joint flax fluttering?",
            "On April 18, according to the old style, carrots and beets were sown. Before sowing, peasant women went to a secret spring in the morning and moistened seeds in water, and copper money was thrown at the bottom of the spring. Such a spring was called a vowed spring ... What?",
            "There was such a custom in Russia. On January 2, according to the old style, the older woman in the house met her grandmother at the gate with bread and salt, with a low bow, with the affectionate word 'Welcome.' Without entering the hut, the grandmother began to wash the lintel with a special drug, and then wiped it off with a clean towel. What did she wash off like that?",
            "What was the name of a girl in the Penza province who got married secretly, without the permission of her parents?",
            "What was the name of a quarrelsome and foolish person in the Kursk province earlier?",
            "As the people used to call a small thing that was hung for decoration? Also, this word was found in the meaning of 'hanging berry'.",
            "How in the old days did the people call the future desired event, happiness, luck and courage?",
            "The soldier's duffel bag has been known since antiquity. In the old days, it was made in an artisanal way from any suitable material. The ends of a rope were tied to its corners. And what was put in the corners of the bag during the manufacturing process?",
            "At the end of the 15th century, a new type of finely woven chain mail appeared in Russia, which was called 'shell'. In the 16th century, chain mail began to spread entirely from flat rings. What was the name of the chain mail made of flat rings?",
            "What was the name of a part of military ammunition in the form of a sling with accessories suspended from it for loading rifles?",
            "What was the name of weapons and military armor in the old days?",
            "A pantaler is a hussar sling over the shoulder for attaching a gun or a cartridge bag. Also on it were provided for the needles. These needles were used to clean holes in a pistol or a gun. What were these needles called?",
            "The Chinese venerate the turtle sacredly. Every residential building and every workplace should have a talisman in the form of this animal. It is believed that he protects the owner from ill-wishers, bad energy and what something else?",
            "Many turtles have a slow metabolism. Therefore, they can do without food and water for a very long time. Why did sailors take such turtles with them on a long voyage before?",
            "In a number of myths, the turtle was of great help to people. For example, the Vietnamese believed that this animal taught them to build houses. What houses did the turtle teach the Vietnamese to build?",
            "In the old days in Belarus, peasants believed that the tortoise was useful in their economy. And where, according to legend, they buried the turtles?",
            "In the 16th century in Europe, small bouquets for decorating clothes came into fashion. Usually they were worn by noble people. What were these bouquets called?",
            "Delphinium flower is blue. In the Middle Ages, it was believed that this color has a beneficial effect on a person's tired eyes. Therefore, its flowers were used to decorate the walls of the premises with ... Who?",
            "In Tibet, monks made an infusion of chamomile, drank it before going to bed. In the morning, the composition of the infusion was slightly changed and drank again. The course of taking chamomile infusion was repeated after five years. Why did Tibetan monks prepare chamomile infusion?",
            "This flower in Russia began to be called iris at the end of the 19th century. And what was the name of the iris among the people before that?",
            "The Moskvoretsk Tower of the Kremlin used to be called Beklemishevskaya, after the boyar Beklemishev. In the 15th century, his courtyard was adjacent to the Kremlin. The boyar himself was extremely sharp on his tongue, for which he was nicknamed Beresen. And what is bersen?",
            "The first wooden fortress walls in the center of Moscow were built in the 12th century by order of Prince Yuri Dolgoruky. Then it was customary to name structures depending on the type of forest from which they were built. What was the name of the coniferous forest that grew near the moss bogs?",
            "The name of the capital of Russia is associated with the Moscow River. This was the name of this river long before the appearance of a settlement on the banks of this river. Today there are many versions of the origin of this name. According to one of them, the word 'Moscow' comes from the disappeared Volga-Finnish language and means 'river ... what'?",
            "The encyclopedic dictionary of Brockhaus and Efron says: 'The Red Square in Moscow Kitay-Gorod is 135 fathoms long, 75 fathoms wide, between the Kremlin wall and the stalls. Its beginning is close to the beginning of Moscow itself; then it was small in size and a place of public gatherings. Under Fyodor Alekseevich, the people here held family trials. On Maundy Thursday they came here ... '. For what?",
            "The reconstruction of the clock on the Spasskaya tower of the Moscow Kremlin, as a result of which the modern chimes appeared, was carried out by the masters Johannes and Nikolai Butenop and ended in 1852. During the revolution, a shell hit the watch. What did the chimes start to play after that?",
            "In 1992, the Exhibition of Achievements of the National Economy VDNKh in Moscow was renamed. Now it is the All-Russian Exhibition Center AREC. In the 19th century, this territory was also called the AREC, since it was located here ... What?",
            "Once, during archaeological excavations, a wooden object dating back to the 17th century was discovered under the building of the Big Theater. What was it?",
            "In the dictionary of Vladimir Ivanovich Dahl, there is a word that in the old days in the Russian North was called a shallow, not exposed by the ebb",
            "In the dictionary of Vladimir Ivanovich Dahl, there is a word that was called a one-tree boat, a canoe dug from one deck and, in general, a narrow unstable boat. How was it called?",
            "In 1904, Russian Rear Admiral Konstantin Petrovich Ivanov served as a lieutenant on the cruiser Rurik. The Russo-Japanese War was going on. In battle, the cruiser was knocked out and sank with the St. Andrew's flag raised. This meant: 'I am dying, but I do not give up.' Three years later, for heroic actions, the emperor awarded, including Ivanov, the Order of St. George, IV degree and ordered to change the surname. So the naval officer became not just Ivanov, but ... What kind of Ivanov?",
            "In the old days, sailors who crossed the equator for the first time always swam in its waters. There was a special prohibition on crossing the equator. By the way, there were several of them. It was impossible to stand with your back to the frontal windows, bring on board fishing boots on your shoulder and shave. And what else was banned?",
            "In the old days sailors considered it a bad omen to meet a person before boarding ... With what?",
            "In ancient times, sailors did not know how to determine the direction of their voyage. There is a legend that the Vikings used an ordinary spoon as a compass. One of them scooped water overboard with a spoon, tasted it and said: 'We are sailing in the right direction: the water is not so salty and smells like familiar…' What?",
            "What was the name of a sailing cargo ship for coastal navigation, which was used in the Azov and Black Seas in the old days?"
    };

    String a[] = {
            "OKHABEN", "KUKHLYANKA", "CAMLAKE", "SLAP", "EPANECHKA",
            "DURKA", "DOWN", "COCKATRICE", "DAMPER", "THREE-LEGGED",
            "SOMERSAULT", "BREAD", "FLOUR", "SALAMATA", "MAZUNYA",
            "TOOTHWOLF", "PLOWING", "ZELEINIK", "FAIRY", "MAHANOSKA",
            "RATTLES", "STUDENETS", "LICHOMANIAC", "SELF-ROLL", "SKIMMER",
            "JAY", "MESH", "SPUD", "BAYDAN", "BERENDEIKA",
            "ARMATURE", "MORDANT", "CONFUSION", "CONSERVES", "PILE",
            "PIGSTY", "BOUTONNIERE", "EMBROIDERER", "REJUVENATION", "COCKALORUM",
            "GOOSEBERRY", "KREMLEVNIK", "SHE-BEAR", "HAIRCUT", "INTERNATIONALE",
            "CIRCUS", "QUEEN", "SUBMARINER", "GAS CHAMBER", "THIRTEENTH",
            "SPIT", "FLATFOOT", "SLOPS", "HOE"
    };

    final float FACTOR = 5f;

    int res = 0;
    int scores = 0;

    private static final String[] sectors = {
            "1000", "400", "650", "0", "500", "750", "2000", "350", "1000", "-1", "700", "850", "1500", "600",
            "450", "2", "800", "950", "1000", "400", "650", "0", "500", "750", "2000", "350", "1000", "-1",
            "700", "850", "1500", "600", "450", "2", "800", "950"
    };

    private void revealLetter (char letter){
        int indexOfLetter = ans.indexOf(letter);
        int count = 0;

        while (indexOfLetter >= 0) {
            ansDispcharArray[indexOfLetter] = ans.charAt(indexOfLetter);
            indexOfLetter = ans.indexOf(letter, indexOfLetter + 1);
            MediaPlayer right = MediaPlayer.create(MainActivity.this, R.raw.zvuk_pravilno_ugadannoy_bukvyi_pole_chudes_5206);
            right.start();
            count++;
        }
        res = res * count;
        ansDisp = String.valueOf(ansDispcharArray);
    }

    private void displayWord () {

        String formStr = "";

        for (char character : ansDispcharArray) {
            formStr += character + " ";
        }
        answerTv.setText(formStr);

    }

    private void ifLetterCorrect (char letter){
        char L = Character.toUpperCase(letter);

        if (ans.indexOf(L) >= 0) {

            if (ansDisp.indexOf(L) < 0) {
                revealLetter(L);
                displayWord();

                if (!ansDisp.contains("*")) {
                    MediaPlayer win = MediaPlayer.create(MainActivity.this, R.raw.zvuk_otgadannogo_slova_v_ture_5235);
                    win.start();

/*                    Toast.makeText(getApplicationContext(), "You win! Your result is " + res + " points!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);

 */
                }
            } else {
                MediaPlayer wrong = MediaPlayer.create(MainActivity.this, R.raw.zvuk_nepravilnoy_bukvyi_v_pole_chudes_nevernyiy_otvet_5212);
                wrong.start();
                res = 0;
            }
        } else {
            MediaPlayer wrong = MediaPlayer.create(MainActivity.this, R.raw.zvuk_nepravilnoy_bukvyi_v_pole_chudes_nevernyiy_otvet_5212);
            wrong.start();
            res = 0;
        }
        scores += res;
        scoresTv.setText(Integer.toString(scores));

    }

    private int getResult (int curDegree){
        MediaPlayer prize = MediaPlayer.create(MainActivity.this, R.raw.sektor_priz_na_barabane_5216);
        MediaPlayer chance = MediaPlayer.create(MainActivity.this, R.raw.sektor_shans_na_barabane_zvonok_po_telefonu_5220);
        MediaPlayer zero = MediaPlayer.create(MainActivity.this, R.raw.u_vas_nol_perehod_hoda_na_drugogo_uchastnika_5218);
        MediaPlayer bankrupt = MediaPlayer.create(MainActivity.this, R.raw.vyi_bankrot_5217);
        MediaPlayer plus = MediaPlayer.create(MainActivity.this, R.raw.vyipal_sektor_plyus_5225);
        MediaPlayer x2 = MediaPlayer.create(MainActivity.this, R.raw.zvuk_vyipalo_na_barabane_h2_umnojenie_ochkov_v_2_raza_5229);

        String text = "";
        int res;
        res = 0;

        int factor_x = 1;
        int factor_y = 3;

        for (int i = 0; i < 36; i++) {
            if (curDegree >= FACTOR * factor_x && curDegree < FACTOR * factor_y) {
                text = sectors[i];
                res = Integer.parseInt(text);
            }

            factor_x += 2;
            factor_y += 2;
        }

        Log.v(TAG, "getResult 1 "+text);

        if ( res == 1000 ) {
            plus.start();
        }

        if ( res == 0) {
            zero.start();
        }

        if ( res == 2000 ) {
            chance.start();
        }

        if ( res == -1 ) {
            res = - scores ;
            bankrupt.start();
        }

        if ( res == 1500 ) {
            prize.start();
        }

        if ( res == 2 ) {
            res = scores;
            x2.start();
        }

        Log.v(TAG, "getResult 2 "+Integer.toString(res));

        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheel_iv = (ImageView) findViewById(R.id.wheelIv);
        arrow_iv = (ImageView) findViewById(R.id.arrowIv);
        points = (TextView) findViewById(R.id.points);
//        pointsTv = (TextView) findViewById(R.id.pointsTv);
        questionTv = (TextView) findViewById(R.id.questionTv);
        answerTv = (TextView) findViewById(R.id.answerTv);
        scoresTv = (TextView) findViewById(R.id.scoresTv);
        letterEt = (EditText) findViewById(R.id.letterEt);
        wordEt = (EditText) findViewById(R.id.wordEt);
        spinBtn = (Button) findViewById(R.id.spinBtn);
        wordBtn = (Button) findViewById(R.id.wordBtn);

        r = new Random();
        i = r.nextInt(q.length);

        letterEt.setVisibility(View.GONE);
        questionTv.setText(q[i]);
        ans = a[i];
        ansDispcharArray = ans.toCharArray();

        for (int i = 0; i < ansDispcharArray.length; i++) {
            ansDispcharArray[i] = '*';
        }

        ansDisp = String.valueOf(ansDispcharArray);

        letterEt.setText("");
        wordEt.setText("");

        letterEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    ifLetterCorrect(s.charAt(0));
                }
            }

            @Override
            public void afterTextChanged(Editable ed) {
                letterEt.getText().clear();
                letterEt.setVisibility(View.GONE);
            }
        });



        wordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinBtn.setVisibility(View.GONE);
                letterEt.setVisibility(View.GONE);

                if (wordEt.getText().toString().toUpperCase().equals(a[i])) {
                    MediaPlayer corWord = MediaPlayer.create(MainActivity.this, R.raw.zvuk_otgadannogo_slova_v_ture_5235);
                    corWord.start();
                    scores += 5000;
 /*                   Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.customdialog);
                    Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_SHORT).show();
 */                   Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                    startActivity(intent);

                } else {

                    MediaPlayer lose = MediaPlayer.create(MainActivity.this, R.raw.zvuk_nepravilnogo_slova_v_troyke_igrokov_teleperedachi_pole_chudes_5228);
                    lose.start();
                    scores = 0;
/*                    Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
*/                }
            }
        });

        spinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.zvuk_vrascheniya_barabana_peredacha_1995_goda_5224);

                music.start();
                oldDegree = curDegree % 360;
                curDegree = r.nextInt(3600) + 360;

                RotateAnimation animation = new RotateAnimation(oldDegree, curDegree,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                animation.setFillAfter(true);
                animation.setDuration(70000);
                animation.setInterpolator(new AccelerateDecelerateInterpolator());
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        spinBtn.setVisibility(View.GONE);
                        wordEt.setVisibility(View.GONE);
                        wordBtn.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        music.stop();
                        letterEt.setVisibility(View.VISIBLE);
                        wordEt.setVisibility(View.GONE);
                        spinBtn.setVisibility(View.GONE);
                        wordBtn.setVisibility(View.GONE);
                        res = getResult(360 - (curDegree % 360));
                        Log.v(TAG, Integer.toString(res) );

                        //                        scoresTv.setText(Integer.toString();

                        while (letterEt.getText().toString() == "") {

                            wordEt.setVisibility(View.GONE);
                            spinBtn.setVisibility(View.GONE);
                            wordBtn.setVisibility(View.GONE);
                        }

                        letterEt.getText().clear();
                        wordBtn.setVisibility(View.VISIBLE);
                        spinBtn.setVisibility(View.VISIBLE);
                        wordEt.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                wheel_iv.startAnimation(animation);
            }
        });

    }
}