package com.example.composepracticedemoapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.composepracticedemoapp.ui.theme.ComposePracticeDemoAppTheme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeDemoAppTheme {
                HomeScreenConstraintLayout()
            }
        }
    }
}

// Jetpack compose with Constraint Layout  (Add dependency first)
@Composable
fun HomeScreenConstraintLayout() {
    val context = LocalContext.current
    val constraints = ConstraintSet {
        val btnMainActivity = createRefFor("btnMainActivity")
        val btnBasicFields = createRefFor("btnBasicFields")
        val btnBasicStateHandle = createRefFor("btnBasicStateHandle")
        val btnListCompose = createRefFor("btnListCompose")
        val btnSimpleAnimation = createRefFor("btnSimpleAnimation")
        val btnProgressBar = createRefFor("btnProgressBar")
        val btnMusicKnob = createRefFor("btnMusicKnob")
        val btnMeditationUi = createRefFor("btnMeditationUi")

        constrain(btnMainActivity) {
            top.linkTo(parent.top, margin = 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.value(180.dp)
            height = Dimension.value(40.dp)
        }

        constrain(btnBasicFields) {
            top.linkTo(btnMainActivity.bottom, margin = 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

        constrain(btnBasicStateHandle) {
            top.linkTo(btnBasicFields.bottom, margin = 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

        constrain(btnListCompose) {
            top.linkTo(btnBasicFields.bottom, margin = 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

        constrain(btnSimpleAnimation) {
            top.linkTo(btnBasicStateHandle.bottom, margin = 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        createHorizontalChain(btnBasicStateHandle, btnListCompose, chainStyle = ChainStyle.Packed)

        constrain(btnProgressBar) {
            top.linkTo(btnSimpleAnimation.bottom, margin = 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(btnMusicKnob) {
            top.linkTo(btnSimpleAnimation.bottom, margin = 20.dp)
            start.linkTo(btnProgressBar.end)
            end.linkTo(parent.end)
        }
        createHorizontalChain(btnProgressBar, btnMusicKnob, chainStyle = ChainStyle.SpreadInside)

        constrain(btnMeditationUi) {
            top.linkTo(btnMusicKnob.bottom, margin = 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {

        Button(modifier = Modifier
            .layoutId("btnMainActivity"),
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            }) {
            Text(text = "Main Activity")
        }

        Button(
            onClick = {
                context.startActivity(Intent(context, BasicFields::class.java))
            },
            modifier = Modifier
                .layoutId("btnBasicFields")
        ) {
            Text(text = "Basic Fields")
        }
        Button(
            onClick = {
                context.startActivity(Intent(context, BasicStateHandle::class.java))
            },
            modifier = Modifier
                .layoutId("btnBasicStateHandle")
        ) {
            Text(text = "Basic State Handle")
        }
        Button(
            onClick = {
                context.startActivity(Intent(context, ListCompose::class.java))
            },
            modifier = Modifier
                .layoutId("btnListCompose")
        ) {
            Text(text = "Basic List Compose")
        }
        Button(
            onClick = {
                context.startActivity(Intent(context, SimpleAnimation::class.java))
            },
            modifier = Modifier
                .layoutId("btnSimpleAnimation")
        ) {
            Text(text = "Simple Animation")
        }
        Button(
            onClick = {
                context.startActivity(
                    Intent(
                        context,
                        CircularProgressBar::class.java
                    )
                )
            },
            modifier = Modifier.layoutId("btnProgressBar")
        ) {
            Text(text = "Progress Bar")
        }
        Button(
            onClick = {
                context.startActivity(
                    Intent(
                        context,
                        DraggableMusicKnob::class.java
                    )
                )
            },
            modifier = Modifier.layoutId("btnMusicKnob")
        ) {
            Text(text = "Music Knob")
        }
        Button(
            onClick = {
                context.startActivity(
                    Intent(
                        context,
                        MeditationUi::class.java
                    )
                )
            },
            Modifier.layoutId("btnMeditationUi")
        ) {
            Text(text = "Meditation Design")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ComposePracticeDemoAppTheme {
        HomeScreenConstraintLayout()
    }
}