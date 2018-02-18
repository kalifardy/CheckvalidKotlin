package com.app.keyalive.checkvalid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ValidEdit(username)
        ValidEdit(password)
    }
    private fun ValidEdit(editText: EditText){
        RxTextView.textChanges(editText).map { t: CharSequence -> t.length<5 && t.length >0 }.debounce(1,TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    t: Boolean? -> if (t!!){
                    editText.setError("Kudu 5 Hurup")
//                    password.setError("Kudu 5 Hurup")
                }

                }
    }

}
