 package com.example.chucknorris

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

@Suppress("DEPRECATION", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {

    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nextBtn.setOnClickListener {
            nextBtn.text = getText(R.string.next2)
            imageChuck.setImageResource(R.drawable.chuck_norris)
            loadRandomFact()
        }
    }

    private fun loadRandomFact() {
        runOnUiThread {
            progressBar.visibility = View.VISIBLE
        }

        val res: Resources = resources
        val txt = getString(R.string.fact + 1.rand(res.getInteger(R.integer.numFacts)))

        runOnUiThread {
            progressBar.visibility = View.GONE
            factTv.text = txt
        }
    }

    private fun Int.rand(to: Int) : Int {
        return random.nextInt(to - this) + this
    }
}