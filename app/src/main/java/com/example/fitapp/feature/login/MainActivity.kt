package com.example.fitapp.feature.login

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitapp.R
import com.example.fitapp.feature.home.HomeActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter
    private companion object LoginActivity {
        private const val TAG = "LoginActivity"
        private const val RC_GOOGLE_SIGN_IN = 4926
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = MainPresenter(this)
        auth = Firebase.auth

        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        val login_btn = findViewById<ImageButton>(R.id.login_btn)
        login_btn.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_GOOGLE_SIGN_IN)
        }
        //login_btn.setOnClickListener{ presenter.onLoginBtnClicked()}
        val user = Firebase.auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val username = it.displayName
            val email = it.email}



    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)

                val db = FirebaseFirestore.getInstance()
                val collectionRef = db.collection("user")

// create a query to search for documents where the email field matches the email you want to check
                val query = collectionRef.whereEqualTo("email", account.email)

// execute the query and add a listener to retrieve the results
                query.get()
                    .addOnSuccessListener { documents ->
                        if (documents.isEmpty) {
                            // the email does not exist in the database
                            println("isEmpty")
                            AddUser(account.displayName,account.email)
                        } else {
                            // the email exists in the database
                            val document = documents.first()
                            val data = document.data
                            // access fields using data["field_name"]
                            println("isntEmpty")
                        }
                    }
                    .addOnFailureListener { exception ->
                        // handle any errors
                    }



                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }
    private fun GetDataFromDB () {

}
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }
    private fun AddUser(displayName:String?, email:String?){
        val user_login = hashMapOf(
            "name" to displayName,
            "email" to email,
            "numberofworkouts" to 0
        )
        val db = Firebase.firestore
        db.collection("user")
            .add(user_login)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user == null) {
            Log.w(TAG, "user not signed in..")
            return
        }
        startActivity(Intent(this, HomeActivity::class.java))
        finish()

    }
    override fun navigateTologin(){


    }

}

