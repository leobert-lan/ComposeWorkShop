package osp.leobert.android.composeworkshop.post30

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import osp.leobert.android.composeworkshop.DemoActivity

class P30ColumnRowScrollSample : DemoActivity() {

    @Composable
    override fun content() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .verticalScroll(
                    state = rememberScrollState()
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .horizontalScroll(
                        state = rememberScrollState()
                    )
            ) {
                Box(
                    Modifier
                        .size(400.dp)
                        .background(Color.Green)
                )
                Box(
                    Modifier
                        .size(400.dp)
                        .background(Color.Blue)
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Box(
                Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(Color.Blue)
            )

        }
    }


}
