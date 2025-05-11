package id.idham.techdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import id.idham.techdemo.core.designsystem.theme.TechDemoTheme
import id.idham.techdemo.ui.TechDemoApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.attributes.preferredRefreshRate = 90f
        enableEdgeToEdge()
        setContent {
            TechDemoTheme {
                TechDemoApp()
            }
        }
    }
}
