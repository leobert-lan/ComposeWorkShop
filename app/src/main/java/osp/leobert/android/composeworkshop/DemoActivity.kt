package osp.leobert.android.composeworkshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import osp.leobert.android.composeworkshop.ui.theme.ComposeWorkShopTheme

/**
 * <p><b>Package:</b> osp.leobert.android.composeworkshop </p>
 * <p><b>Project:</b> ComposeWorkShop </p>
 * <p><b>Classname:</b> DemoActivity </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2021/8/31.
 */
abstract class DemoActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWorkShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    content()
                }
            }
        }
    }

    @Composable
    abstract fun content()
}