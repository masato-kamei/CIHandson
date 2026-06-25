package jp.co.fnl.kamei.cihandson

import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.co.fnl.kamei.cihandson.ui.theme.CIHandsonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ★ lintエラーを発生させるためのコード（compileは通る）
        val unused = 125  // 未使用変数（通常はWarning）

        // ★ これを追加（lint Errorになる可能性が高い）
        Handler().postDelayed({
            println("Hello from background")
        }, 1000)

        enableEdgeToEdge()
        setContent {
            CIHandsonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",  // ★ ここがlintで引っかかる（HardcodedText）
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Good afternoon $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CIHandsonTheme {
        Greeting("Android")
    }
}