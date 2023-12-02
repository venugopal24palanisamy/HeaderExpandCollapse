package com.debduttapanda.motionlayoutwithnestedscrollandswipeable

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Velocity
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.*
import com.debduttapanda.motionlayoutwithnestedscrollandswipeable.animationScrollflags.MiExitUntilCollapsedState
import com.debduttapanda.motionlayoutwithnestedscrollandswipeable.components.HeaderView
import com.debduttapanda.motionlayoutwithnestedscrollandswipeable.ui.theme.MotionLayoutWithNestedScrollAndSwipeableTheme
import java.util.*

enum class SwipingStates {
    //our own enum class for stoppages e.g. expanded and collapsed
    EXPANDED,
    COLLAPSED
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotionLayoutWithNestedScrollAndSwipeableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DummyView1()
                }
            }
        }
    }
}

val MinToolbarHeight = 60.dp
val MaxToolbarHeight = 150.dp
@OptIn(ExperimentalMaterialApi::class, ExperimentalMotionApi::class)
@Composable
fun DummyView1() {
    val swipingState = rememberSwipeableState(initialValue = SwipingStates.EXPANDED)


    val marioToolbarHeightRange = with(LocalDensity.current) {
        MinToolbarHeight.roundToPx()..MaxToolbarHeight.roundToPx()
    }
    val toolbarState = rememberSaveable(saver = MiExitUntilCollapsedState.Saver) {
        MiExitUntilCollapsedState(marioToolbarHeightRange)
    }
    val scrollState = rememberScrollState()
    toolbarState.scrollValue = scrollState.value


    BoxWithConstraints(
        //to get the max height
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderView(content = {
            Box(
                modifier = Modifier
                    .layoutId("body")
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                //content, not necessarily scrollable or list
                Column(modifier = Modifier.verticalScroll(scrollState)) {
                    Box(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(
                                Color.Black,
                                RoundedCornerShape(12.dp)
                            )
                            .border(
                                BorderStroke(
                                    2.dp,
                                    Color.Gray
                                ),
                                RoundedCornerShape(12.dp)
                            )
                            .padding(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("dassdasd")
                    }

                    Box(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(
                                Color.Black,
                                RoundedCornerShape(12.dp)
                            )
                            .border(
                                BorderStroke(
                                    2.dp,
                                    Color.Gray
                                ),
                                RoundedCornerShape(12.dp)
                            )
                            .padding(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("dassdasd")
                    }

                    Box(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(
                                Color.Black,
                                RoundedCornerShape(12.dp)
                            )
                            .border(
                                BorderStroke(
                                    2.dp,
                                    Color.Gray
                                ),
                                RoundedCornerShape(12.dp)
                            )
                            .padding(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("dassdasd")
                    }
                    Box(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(
                                Color.Black,
                                RoundedCornerShape(12.dp)
                            )
                            .border(
                                BorderStroke(
                                    2.dp,
                                    Color.Gray
                                ),
                                RoundedCornerShape(12.dp)
                            )
                            .padding(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("dassdasd")
                    }

                    Box(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(
                                Color.Black,
                                RoundedCornerShape(12.dp)
                            )
                            .border(
                                BorderStroke(
                                    2.dp,
                                    Color.Gray
                                ),
                                RoundedCornerShape(12.dp)
                            )
                            .padding(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("dassdasd")
                    }
                }


            }
        }, process = toolbarState.progress)

        /*Box(
            modifier = Modifier
                .fillMaxSize()
                .swipeable(
                    state = swipingState,
                    thresholds = { _, _ ->
                        FractionalThreshold(0.5f)//it can be 0.5 in general
                    },
                    orientation = Orientation.Vertical,
                    anchors = mapOf(
                        0f to SwipingStates.COLLAPSED,//min height is collapsed
                        heightInPx to SwipingStates.EXPANDED,//max height is expanded
                    )
                )
                .nestedScroll(nestedScrollConnection)
        ) {
            val computedProgress by remember {//progress value will be decided as par state
                derivedStateOf {
                    if (swipingState.progress.to == SwipingStates.COLLAPSED)
                        swipingState.progress.fraction
                    else
                        1f - swipingState.progress.fraction
                }
            }


            DisposableEffect(computedProgress) {
                 Log.w("DummyView1", computedProgress.toString())
                onDispose {
                    // Cleanup, if needed
                }
            }
            val startHeightNum = 150


        }*/
    }

}


fun getStartConstraints(): ConstraintSet = ConstraintSet {
    val header = createRefFor("header")
    val body = createRefFor("body")
    val content1 = createRefFor("content1")
    val content2 = createRefFor("content2")
    val backIcon = createRefFor("backIcon")
    val settingsIcon = createRefFor("settingsIcon")

    constrain(header) {
        this.width = Dimension.matchParent
        this.height = Dimension.value(150.dp)
    }
    constrain(body) {
        this.width = Dimension.matchParent
        this.height = Dimension.fillToConstraints
        this.top.linkTo(header.bottom, 0.dp)
        this.bottom.linkTo(parent.bottom, 0.dp)
    }
    constrain(content1) {
        this.start.linkTo(header.start)
        this.end.linkTo(header.end)
        this.top.linkTo(header.top, 5.dp)
        this.bottom.linkTo(content2.top, 10.dp)
        this.height = Dimension.value(64.dp)
    }
    constrain(content2) {
        this.start.linkTo(header.start)
        this.end.linkTo(header.end)
        this.bottom.linkTo(header.bottom, 24.dp)
    }

    constrain(backIcon) {
        start.linkTo(header.start, 16.dp)
        top.linkTo(header.top, 16.dp)
    }

    constrain(settingsIcon) {
        end.linkTo(header.end, 16.dp)
        top.linkTo(header.top, 16.dp)
    }
}

fun getEndConstraints(): ConstraintSet = ConstraintSet {
    val header = createRefFor("header")
    val body = createRefFor("body")
    val content1 = createRefFor("content1")
    val content2 = createRefFor("content2")

    val backIcon = createRefFor("backIcon")
    val settingsIcon = createRefFor("settingsIcon")

    constrain(header) {
        this.height = Dimension.value(60.dp)
    }
    constrain(body) {
        this.width = Dimension.matchParent
        this.height = Dimension.fillToConstraints
        this.top.linkTo(header.bottom, 0.dp)
        this.bottom.linkTo(parent.bottom, 0.dp)
    }
    constrain(backIcon) {
        start.linkTo(header.start, 16.dp)
        top.linkTo(header.top, 16.dp)
        bottom.linkTo(header.bottom, 16.dp)
    }
    constrain(content1) {
        this.start.linkTo(backIcon.end, 8.dp)
        this.top.linkTo(header.top, 16.dp)
        this.bottom.linkTo(header.bottom, 16.dp)
        this.height = Dimension.value(24.dp)
    }
    constrain(content2) {
        this.start.linkTo(content1.end, 8.dp)
        this.bottom.linkTo(header.bottom)
        this.top.linkTo(header.top)
    }



    constrain(settingsIcon) {
        end.linkTo(parent.end, 16.dp)
        top.linkTo(parent.top, 16.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun DummyView2() {
    DummyView1()
}
