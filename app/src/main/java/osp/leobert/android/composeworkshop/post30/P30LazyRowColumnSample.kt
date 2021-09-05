package osp.leobert.android.composeworkshop.post30

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import osp.leobert.android.composeworkshop.DemoActivity
import osp.leobert.android.composeworkshop.post21.CodeSample

class P30LazyRowColumnSample : DemoActivity() {

    @Composable
    override fun content() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
//                .scrollable(
//                    state = rememberScrollState(),
//                    orientation = Orientation.Vertical,
//
//                    )
                .verticalScroll(
                    state = rememberScrollState()
                )

        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(Color.Green)
            )

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
