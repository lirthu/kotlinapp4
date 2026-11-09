package com.example.kotlin4

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ComplexColorCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.kotlin4.databinding.ActivityLearnWordBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityLearnWordBinding

    private var _binding: ActivityLearnWordBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityLearnWordBinding must not be null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLearnWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layoutThirdVariant.setOnClickListener {
            markAnswerCorrect(binding.layoutThirdVariant,
                binding.tvThirdNumberVariant,
                binding.tvThirdWordVariant)
            showResultMessage(true)
        }
        binding.layoutFirstVariant.setOnClickListener {
            markAnswerWrong(binding.layoutFirstVariant,
                binding.tvFirstNumberVariant,
                binding.tvFirstWordVariant)
            showResultMessage(false)
        }
        binding.btnContinue.setOnClickListener {
            markAnswerNeutral(
                binding.layoutThirdVariant,
                binding.tvThirdNumberVariant,
                binding.tvThirdWordVariant
            )
            markAnswerNeutral(
                binding.layoutFirstVariant,
                binding.tvFirstNumberVariant,
                binding.tvFirstWordVariant
            )
        }

//        val tvMainWord: TextView = findViewById(R.id.tvMainWord)
//        tvMainWord.setTextColor(Color.GRAY)
//        tvMainWord.setTextColor(Color.parseColor("#AA0AEF"))
//        tvMainWord.setTextColor(ContextCompat.getColor(this, R.color.buttonBlueColor))

        with(binding) {
            tvMainWord.text = "Galaxy"
            tvFirstWordVariant.text = "Слон"
            tvSecondWordVariant.text = "Бургер"
            tvThirdWordVariant.text = "Галактика"
            tvFourthWordVariant.text = "Робот"
            tvMainWord.setTextColor(Color.GRAY)
            btnCloseButton.isVisible = false
            tvFioStudent.text = "Выполнил Краснов Артём Владиславович 407ИС-23"

        }
    }
    private fun markAnswerCorrect(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView
    ) {

        layoutAnswer.setBackground(
            ContextCompat.getDrawable(
                this@MainActivity,
            R.drawable.shape_rounded_containers_correct,
            )
        )

        tvVariantNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_correct,
        )

        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white,
            )
        )

        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor,
            )
        )
    }
    private fun markAnswerWrong(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView
    ) {
        layoutAnswer.setBackground(
            ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.shape_rounded_containers_wrong,
            )
        )

        tvVariantNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_wrong,
        )

        tvVariantNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white,
            )
        )

        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongAnswerColor,
            )
        )
    }


    private fun markAnswerNeutral(
        layoutAnswer: LinearLayout,
        tvVariantNumber: TextView,
        tvVariantValue: TextView
    ) {
        layoutAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers,
        )

        tvVariantValue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.textVariantsColor,
            )
        )

        tvVariantNumber.apply {
            background = ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.shape_rounded_variants,
            )
            setTextColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.textVariantsColor,
                )
            )
        }
        binding.layoutInfoBlock.isVisible = false
        binding.btnSkipButton.isVisible = true
    }
    private fun showResultMessage(isCorrect: Boolean) {
        val setColor: Int
        val setIcon: Int
        val setText: Int

        if (isCorrect) {
            setColor = R.color.correctAnswerColor
            setIcon = R.drawable.ic_thumb_correct
            setText = R.string.textview_correct_text
        } else {
            setColor = R.color.wrongAnswerColor
            setIcon = R.drawable.ic_thumb_wrong
            setText = R.string.textview_wrong_text
        }

        with(binding){
            btnSkipButton.isVisible = false
            layoutInfoBlock.isVisible = true
            btnContinue.setTextColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    setColor)
            )
            layoutInfoBlock.setBackgroundColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    setColor)
            )
            tvCorrectWord.text = resources.getString(setText)
            ivIconOrrect.setImageDrawable(
                ContextCompat.getDrawable(
                    this@MainActivity,
                    setIcon)
            )
        }
    }
}