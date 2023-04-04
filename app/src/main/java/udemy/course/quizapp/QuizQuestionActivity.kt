package udemy.course.quizapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import udemy.course.quizapp.models.Constants

class QuizQuestionActivity : AppCompatActivity() {
    private var questionText: TextView? = null
    private var questionImage: ImageView? = null

    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null

    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        questionText = findViewById(R.id.question_text)
        questionImage = findViewById(R.id.question_image)

        progressBar = findViewById(R.id.progress_bar)
        progressText = findViewById(R.id.progress_text)

        option1 = findViewById(R.id.option_1)
        option2 = findViewById(R.id.option_2)
        option3 = findViewById(R.id.option_3)
        option4 = findViewById(R.id.option_4)

        val questionList = Constants.getQuestions()
        var currentPosition = 1
        val question = questionList[currentPosition-1]

        questionText?.text = question.questionText
        questionImage?.setImageResource(question.image)

        progressBar?.progress = currentPosition
        progressText?.text = "$currentPosition/${progressBar?.max}"

        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4

    }
}