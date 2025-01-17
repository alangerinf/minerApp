package com.mat.app3.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.mat.app3.*
import com.mat.app3.Utils.*
import kotlinx.android.synthetic.main.activity_sing_up.*


class SingUpActivity : AppCompatActivity() {

    private val mAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        buttonGoLogin.setOnClickListener {
            goToActivity<LoginActivity> {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        buttonSingUp.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val confirmPassword = editTextConfirmPassword.text.toString()
            if (isValidEmail(email) && isValidPassword(password) && isValidConfirmPassword(password, confirmPassword)) {
                singUpByEmail(email, password)
            } else {
                toast("Please make sure all the data is correct.")
            }
        }

        editTextEmail.validate {
            editTextEmail.error = if (isValidEmail(it)) null else "Email is not valid"
            }
        editTextPassword.validate {
            editTextPassword.error = if (isValidPassword(it)) null else "Password Should contain 1 lowercase, 1 uppercase, 1 numbers, 1 special character and 4 character length al least."
        }
        editTextConfirmPassword.validate {
            editTextConfirmPassword.error = if (isValidConfirmPassword(editTextPassword.text.toString(), it)) null else "Confirm Password does not match with Password"
        }
    }


    private fun singUpByEmail(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    mAuth.currentUser!!.sendEmailVerification().addOnCompleteListener(this) {
                        toast("An email has been sent to you. please confirm before sing in.")

                        goToActivity<LoginActivity> {
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        }
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    }
                    } else {
                    toast("An unexpected error occured, please try again.")
                }

            }
        }

}
