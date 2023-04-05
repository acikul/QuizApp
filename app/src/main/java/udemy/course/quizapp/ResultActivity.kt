package udemy.course.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import udemy.course.quizapp.models.Constants

class ResultActivity : AppCompatActivity() {
    private var congratsName: TextView? = null
    private var congratsScore: TextView? = null
    private var doneButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        congratsName = findViewById(R.id.congrats_name)
        congratsScore = findViewById(R.id.congrats_score)
        doneButton = findViewById(R.id.done_btn)

        congratsName?.text = intent.getStringExtra(Constants.USER_NAME)
        congratsScore?.text = "You scored ${intent.getIntExtra(Constants.NUM_CORRECT, 0)} out of ${intent.getIntExtra(Constants.NUM_QUESTIONS, 10)}"

        doneButton?.setOnClickListener{
            val startIntent = Intent(this, MainActivity::class.java)
            startActivity(startIntent)
            finish()
        }
    }
}