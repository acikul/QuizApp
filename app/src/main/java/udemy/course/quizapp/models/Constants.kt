package udemy.course.quizapp.models

import udemy.course.quizapp.R

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val q1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Australia",
            "Honduras",
            "Bolivia",
            "Argentina",
            4
        )

        val q2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Australia",
            "Honduras",
            "United Kingdom",
            "Bolivia",
            1
        )

        val q3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Germany",
            "Poland",
            "Netherlands",
            1
        )

        val q4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Denmark",
            "Brazil",
            "Colombia",
            "Peru",
            2
        )

        val q5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Sweden",
            "Finland",
            "Norway",
            1
        )

        val q6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "San Marino",
            "Indonesia",
            "Fiji",
            "Philippines",
            3
        )

        val q7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Spain",
            "Hungary",
            "Italy",
            1
        )

        val q8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Palestine",
            "Bangladesh",
            "Syria",
            "India",
            4
        )

        val q9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "UAE",
            "Qatar",
            "Morocco",
            1
        )

        val q10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Canada",
            "United Kingdom",
            2
        )

        questionList.addAll(arrayOf(q1, q2, q3, q4, q5, q6, q7, q8, q9 ,q10))

        return questionList
    }
}