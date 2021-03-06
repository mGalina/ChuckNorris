># Chuck Norris App
- The application is a list of jokes about Chuck Norris in Russian, which are given in random order.
- Has been formulated to support emotional health.
- It is a powerful psychological tranquilizer with no side effects.
- 18+

![](gif_app.gif)

> MainActivity 
```
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
```
    
> activity_main.xml
```
    <?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/imageChuck"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_marginTop="60dp"
        android:contentDescription="@string/todo"
        android:visibility="visible"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/images_chuck" />

    <TextView
        android:id="@+id/factTv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="10dp"
        android:fontFamily="sans-serif-condensed"
        android:gravity="center_horizontal"
        android:paddingLeft="30dp"
        android:paddingRight="30dp"
        android:text="@string/chuck_norris_fact"
        android:textSize="22sp"
        app:layout_constraintBottom_toTopOf="@+id/nextBtn"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageChuck" />

    <Button
        android:id="@+id/nextBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="30dp"
        android:fontFamily="sans-serif-condensed"
        android:text="@string/next"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

    <ProgressBar
        android:id="@+id/progressBar"
        style="?android:attr/progressBarStyle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:visibility="gone"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```
