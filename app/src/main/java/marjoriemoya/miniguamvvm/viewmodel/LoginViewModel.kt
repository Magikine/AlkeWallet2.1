
package marjoriemoya.miniguamvvm
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import marjoriemoya.miniguamvvm.databinding.ActivityLoginPageBinding
import marjoriemoya.miniguamvvm.view.HomePageActivity
import marjoriemoya.miniguamvvm.view.SignupPageActivity
import marjoriemoya.miniguamvvm.viewmodel.RegisterViewModel

class LoginViewModel :  AppCompatActivity() {




    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        //Configuracion Binding
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configuracion ViewModel
        viewModel = RegisterViewModel(this).get(LoginViewModel::class.java)


        //Configurar onClick
        binding.btnPg2.setOnClickListener {

            //Vamos a rescartar la informacion que ingreso el usuario
            var correoIngresado = binding.lblNombrePg4.text.toString()
            var passwordIngresado = binding.txtPasword.text.toString()

            viewModel.hacerLogin(correoIngresado, passwordIngresado)
        }
        //Se configura el observador que va a estar observando al sujeto "loginResultLiveData"

        viewModel.loginResultLiveData
            .observe(this) { loginOk: Boolean ->
                if (loginOk == true) {
                    val irMenuPrincipal = Intent(this, HomePageActivity::class.java)
                    startActivity(irMenuPrincipal)
                } else {
                    Toast.makeText(this, "Datos Invalidos", Toast.LENGTH_LONG).show()
                }
            }
        fun obtenerDatos(datos: List<Any>) {
            // Lógica para obtener datos
        }

        binding.btnPg2.setOnClickListener {
            val irLogin = Intent(this, SignupPageActivity::class.java)
            startActivity(irLogin)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun hacerLogin(correoIngresado: String, passwordIngresado: String) {

    }
}

private fun Any.observe(loginViewModel: LoginViewModel, any: Any) {

}

private fun ViewModelProvider.get(modelClass: Class<LoginViewModel>) {

}
