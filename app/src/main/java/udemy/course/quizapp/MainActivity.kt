package udemy.course.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn: Button = findViewById(R.id.start_btn)
        val nameInput: EditText = findViewById(R.id.text_input_name)

        startBtn.setOnClickListener {
            if (nameInput.text.isEmpty()) {
                Toast.makeText(this, "You haven't entered your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                startActivity(intent)
                // finish()
            }
        }

    }
}