package com.dicoding.picodiploma.loginwithanimation.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.dicoding.picodiploma.loginwithanimation.data.utils.isValidEmail

class EmailEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatEditText(context, attrs)  {

    private var isError = false

    init {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (isError) return
                if (!isValidEmail(s)) {
                    isError = true
                    setError("Email Tidak Valid!", null)
                    isError = false
                } else if (isValidEmail(s)) {
                    error = null
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

}