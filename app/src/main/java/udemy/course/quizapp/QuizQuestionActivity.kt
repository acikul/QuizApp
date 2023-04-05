package udemy.course.quizapp

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import udemy.course.quizapp.models.Constants
import udemy.course.quizapp.models.Question

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var userName: String? = null
    private var correctNum: Int = 0

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

        userName = intent.getStringExtra(Constants.USER_NAME)
        correctNum = 0

        findEverythingById()
        setOnClickListeners()

        questionList = Constants.getQuestions()
        loadQuestion()
    }

    private fun findEverythingById() {
        questionText = findViewById(R.id.question_text)
        questionImage = findViewById(R.id.question_image)

        progressBar = findViewById(R.id.progress_bar)
        progressText = findViewById(R.id.progress_text)

        option1 = findViewById(R.id.option_1)
        option2 = findViewById(R.id.option_2)
        option3 = findViewById(R.id.option_3)
        option4 = findViewById(R.id.option_4)

        submitButton = findViewById(R.id.submit_btn)
    }

    private fun setOnClickListeners() {
        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)
    }

    private fun loadQuestion() {
        currentSelection = null
        clearOptionSelection()

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
        } else {
            submitButton?.text = "SUBMIT"
        }
    }

    private fun optionSelected(optionTextView: TextView, selectedOptionId: Int) {
        clearOptionSelection()
        currentSelection = selectedOptionId
        optionTextView.setTypeface(optionTextView.typeface, Typeface.BOLD)
        optionTextView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun clearOptionSelection() {
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

    private fun answerCheckAndColor(answer: Int, drawableTextView: Int) {
        when (answer) {
            1 -> option1?.background = ContextCompat.getDrawable(this, drawableTextView)
            2 -> option2?.background = ContextCompat.getDrawable(this, drawableTextView)
            3 -> option3?.background = ContextCompat.getDrawable(this, drawableTextView)
            4 -> option4?.background = ContextCompat.getDrawable(this, drawableTextView)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option_1 -> { if (currentSelection != Int.MAX_VALUE) option1?.let { optionSelected(it, 1) } }
            R.id.option_2 -> { if (currentSelection != Int.MAX_VALUE) option2?.let { optionSelected(it, 2) } }
            R.id.option_3 -> { if (currentSelection != Int.MAX_VALUE) option3?.let { optionSelected(it, 3) } }
            R.id.option_4 -> { if (currentSelection != Int.MAX_VALUE) option4?.let { optionSelected(it, 4) } }

            R.id.submit_btn -> {
                if (currentSelection == null) {
                    Toast.makeText(this, "Please select an answer before submitting", Toast.LENGTH_LONG).show()
                } else if (currentSelection == Int.MAX_VALUE) {
                    if (currentPosition < questionList!!.size) {
                        currentPosition++
                        loadQuestion()
                    } else {
                        val resultIntent = Intent(this, ResultActivity::class.java)
                        resultIntent.putExtra(Constants.USER_NAME, userName)
                        resultIntent.putExtra(Constants.NUM_QUESTIONS, questionList?.size)
                        resultIntent.putExtra(Constants.NUM_CORRECT, correctNum)
                        startActivity(resultIntent)
                        finish()
                    }
                } else {
                    val question = questionList?.get(currentPosition - 1)
                    if (question?.answer != currentSelection) {
                        answerCheckAndColor(currentSelection!!, R.drawable.incorrect_option_border_bg)
                    } else {
                        correctNum++
                    }
                    answerCheckAndColor(question?.answer!!, R.drawable.correct_option_border_bg)
                    currentSelection = Int.MAX_VALUE
                    submitButton?.text = if (currentPosition != questionList!!.size) "NEXT QUESTION" else "FINISH"
                }
            }
        }
    }
}