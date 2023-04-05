package udemy.course.quizapp

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import udemy.course.quizapp.models.Constants
import udemy.course.quizapp.models.Question

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var currentPosition = 1
    private var questionList: ArrayList<Question>? = null
    private var currentSelection: Int? = null

    private var questionText: TextView? = null
    private var questionImage: ImageView? = null

    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null

    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null

    private var submitButton: Button? = null

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

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)

        submitButton = findViewById(R.id.submit_btn)
        submitButton?.setOnClickListener(this)

        questionList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        currentPosition = 1
        val question = questionList!!.get(currentPosition - 1)

        questionText?.text = question.questionText
        questionImage?.setImageResource(question.image)

        progressBar?.progress = currentPosition
        progressText?.text = "$currentPosition/${progressBar?.max}"

        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4

        if (currentPosition == questionList!!.size) {
            submitButton?.text = "FINISH"
        }
    }

    private fun resetSelection() {
        val options = ArrayList<TextView>()
        option1?.let { options.add(it) }
        option2?.let { options.add(it) }
        option3?.let { options.add(it) }
        option4?.let { options.add(it) }

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOption(optionTextView: TextView, selectedOptionId: Int) {
        resetSelection()
        currentSelection = selectedOptionId
        optionTextView.setTypeface(optionTextView.typeface, Typeface.BOLD)
        optionTextView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option_1 -> { option1?.let { selectedOption(it, 1) } }
            R.id.option_2 -> { option2?.let { selectedOption(it, 2) } }
            R.id.option_3 -> { option3?.let { selectedOption(it, 3) } }
            R.id.option_4 -> { option4?.let { selectedOption(it, 4) } }

            R.id.submit_btn -> {
                // TODO implement submit button
            }
        }
    }
}