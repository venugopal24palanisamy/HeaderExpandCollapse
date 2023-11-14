package com.debduttapanda.motionlayoutwithnestedscrollandswipeable.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.layoutId
import com.debduttapanda.motionlayoutwithnestedscrollandswipeable.R
import com.debduttapanda.motionlayoutwithnestedscrollandswipeable.getEndConstraints
import com.debduttapanda.motionlayoutwithnestedscrollandswipeable.getStartConstraints

@OptIn(ExperimentalMotionApi::class)
@Composable
fun HeaderView(content: @Composable () -> Unit, process: Float) {
    MotionLayout(
        modifier = Modifier.fillMaxSize(),
        start = getStartConstraints(),
        end = getEndConstraints(),
        progress = process,
    ) {

        content()

        Box(
            modifier = Modifier
                .layoutId("header")
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Gray)
        ) {

        }
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = null,
            modifier = Modifier
                .layoutId("backIcon")
                .clickable { /* Handle back button click */ }
        )

        // Settings icon
        Icon(
            painter = painterResource(id = R.drawable.ic_settings),
            contentDescription = null,
            modifier = Modifier
                .layoutId("settingsIcon")
                .clickable { /* Handle settings button click */ }
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier.layoutId("content1")
        )

        Text(
            "Numbers",
            color = Color.White,
            modifier = Modifier
                .layoutId("content2")
        )
    }
}


@Preview(showBackground = true)

@Composable
fun HeaderPreview() {
    HeaderView({ Box(
        modifier = Modifier
            .layoutId("body")
            .fillMaxWidth()
            .background(Color.White)
    ) },1.0f)
}