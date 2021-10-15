package com.example.taller3madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FourthActivity : AppCompatActivity() {

    var characterName: String = "MadLibs"
    val descriptions = hashMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        if(intent.hasExtra("CHARACTER"))
            characterName = intent.getStringExtra("CHARACTER")!!

        setDescriptions()

        showCharacter(characterName)

        val data = intent.getStringExtra("MadLIB")

        val btnThird = findViewById<Button>(R.id.btnThird)
        btnThird.setOnClickListener { goToSecondActivity()

        }
    }
    fun goToSecondActivity(){

        val thirdActivity = Intent(this, SecondActivity::class.java)
        startActivity(thirdActivity)
    }

    fun showCharacter(name: String){
        val description = findViewById<TextView>(R.id.textDescription)
        description.text = descriptions.get(name)
        val image = findViewById<ImageView>(R.id.imageCharacter)
        image.setImageResource(resources.getIdentifier(name, "drawable", packageName))
    }

    fun setDescriptions() {
        descriptions.put("simple","Historia 1 I wannabe a <job> when I grow up.\n" +
                "Just like my dad.\n" +
                "Life is <adjective> like that! ")
        descriptions.put("tarzan","One of the most <adjective> characters in fiction is named\n" +
                "\"Tarzan of the <plural-noun> .\" Tarzan was raised by a/an\n" +
                "<noun> and lives in the <adjective> jungle in the\n" +
                "heart of darkest <place> . He spends most of his time\n" +
                "eating <plural-noun> and swinging from tree to <noun> .\n" +
                "Whenever he gets angry, he beats on his chest and says,\n" +
                "\" <funny-noise> !\" This is his war cry. Tarzan always dresses in\n" +
                "<adjective> shorts made from the skin of a/an <noun>\n" +
                "and his best friend is a/an <adjective> chimpanzee named\n" +
                "Cheetah. He is supposed to be able to speak to elephants and\n" +
                "<plural-noun> . In the movies, Tarzan is played by <person's-name> .")
        descriptions.put("university","Our American universities offer students many <adjective>\n" +
                "courses that will prepare them to become professional <plural-noun> .\n" +
                "You can get a degree as a Bachelor of <plural-noun> or take a\n" +
                "regular liberal <plural-noun> course. Or, if you want to become\n" +
                "a/an <adjective> engineer, you can study <adjective> mathematics\n" +
                "and differential <plural-noun> . Then, after <number> years, if\n" +
                "you want to continue your studies you can write a/an <noun> and\n" +
                "become a Doctor of <plural-noun> . \n" +
                "\n" +
                "When you get out into the <adjective> world, if you have a diploma \n" +
                "from a university, you will be able to get a job easily as a/an <job-title> \n" +
                "or even a/an <job-title> . If you don't have a diploma, you may have to take\n" +
                "a job as a <noun> . \n" +
                "\n" +
                "Remember, it's important that you study hard in high school so you are able \n" +
                "to do well on your college entrance <plural-noun> . It is true that \"a little \n" +
                "learning is a/an <adjective> thing.\"")
        descriptions.put("clothes","<Male-Name> has announced that his <adjective>\n" +
                "clothing store in the heart of downtown <CITY> is having\n" +
                "a/an <adjective> sale of all merchandise, including\n" +
                "<unusual-adjective> suits and slightly irregular <plural-noun>\n" +
                "available. Men's cable-knit <plural-noun> , only \$15.99.\n" +
                "Hand-woven Italian <plural-noun> , 1/2-price. Double-\n" +
                "breasted cashmere <plural-noun> , \$50.00. Genuine imported\n" +
                "<Color!> <adjective> shoes, <Exciting-adjective> handerchiefs,\n" +
                "and women's embroidered <plural-noun> , all at rock-bottom prices.\n" +
                "This is a chance to get some really <Interesting-Adjective> bargains.")
        descriptions.put("dance","Here's how you dance the Monstrosity. Stand with your feet together.\n" +
                "Now, move your left foot <aDvErB> to the side. Now stamp your\n" +
                "right foot <NUMBER> times and put your hands on your partner's\n" +
                "<Plural-Noun> . Next, you both <verb> slowly to the right and bend\n" +
                "your <body-part> backward. For the next eight counts,\n" +
                "both of you <verb> <adverb> to the left. Next, you and\n" +
                "your partner stand back to back and wiggle your <pluRAL-nOUN> and\n" +
                "slap your <plural-noun> together. Don't forget to keep stamping\n" +
                "your right foot. Now, face your partner again, put your <plural-noun>\n" +
                "together and shout, \" <FUNNY-noise> !\" Now, <verb> backward\n" +
                "and repeat the whole thing <Number> times. If you feel that you can't\n" +
                "learn this dance, you can always <verB> the next one out.")
    }
}