package com.example.kotlin4

import android.graphics.Color
import android.os.Bundle
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
            it.isVisible = false
        }

//        val tvMainWord: TextView = findViewById(R.id.tvMainWord)
//        tvMainWord.setTextColor(Color.GRAY)
//        tvMainWord.setTextColor(Color.parseColor("#AA0AEF"))
//        tvMainWord.setTextColor(ContextCompat.getColor(this, R.color.buttonBlueColor))

        with(binding) {
            tvMainWord.text = "Mobilki"
            tvMainWord.setTextColor(Color.GRAY)
            btnCloseButton.isVisible = false
            tvFioStudent.text = "Выполнил Краснов Артём Владиславович 407ИС-23"
        }
    }
    private fun markAnswerCorrect() {

        binding.layoutThirdVariant.setBackground(
            ContextCompat.getDrawable(
                this@MainActivity,
            R.drawable.shape_rounded_containers_correct,
            )
        )

        binding.tvThirdNumberVariant.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_correct,
        )

        binding.tvThirdNumberVariant.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white,
            )
        )

        binding.tvThirdWordVariant.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor,
            )
        )
        binding.btnSkipButton.isVisible = false
        binding.layoutInfoBlock.setBackgroundColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor,
            )
        )
        binding.ivIconOrrect.setImageDrawable(
            ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.ic_thumb_correct,
            )
        )
        binding.tvCorrectWord.text = resources.getString(R.string.textview_correct_text)
        binding.btnContinue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor,
            )
        )
        binding.layoutInfoBlock.isVisible = true
    }
}