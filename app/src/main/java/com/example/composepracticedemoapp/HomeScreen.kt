package com.example.composepracticedemoapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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

// Jetpack compose with Constraint Layout  (Add dependency for constraint layout)
@Composable
fun HomeScreenConstraintLayout() {
    val constraints = ConstraintSet {
        val btnMainActivity = createRefFor("btnMainActivity")
        val btnBasicFields = createRefFor("btnBasicFields")
        val btnBasicStateHandle = createRefFor("btnBasicStateHandle")
        val btnListCompose = createRefFor("btnListCompose")
        val btnSimpleAnimation = createRefFor("btnSimpleAnimation")
        val btnProgressBar = createRefFor("btnProgressBar")
        val btnMusicKnob = createRefFor("btnMusicKnob")
        val btnMeditationUi = createRefFor("btnMeditationUi")
        val btnInstaProfile = createRefFor("btnInstaProfile")
        val btnBottomNavBar = createRefFor("btnBottomNavBar")
        val btnHandleButtonClick = createRefFor("btnHandleButtonClick")
        val btnMultiSelectLazyColumn = createRefFor("btnMultiSelectLazyColumn")
        val btnPermissionHandle = createRefFor("btnPermissionHandle")

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
        }

        constrain(btnInstaProfile) {
            top.linkTo(btnMusicKnob.bottom, margin = 20.dp)
            end.linkTo(parent.end)
        }
        createHorizontalChain(btnMeditationUi, btnInstaProfile, chainStyle = ChainStyle.Spread)

        constrain(btnBottomNavBar) {
            top.linkTo(btnMeditationUi.bottom, margin = 20.dp)
            start.linkTo(parent.start)
        }

        constrain(btnHandleButtonClick) {
            top.linkTo(btnMeditationUi.bottom, margin = 20.dp)
            end.linkTo(parent.end)
        }

        constrain(btnMultiSelectLazyColumn) {
            top.linkTo(btnHandleButtonClick.bottom, margin = 20.dp)
            start.linkTo(parent.start)
        }

        constrain(btnPermissionHandle) {
            top.linkTo(btnHandleButtonClick.bottom, margin = 20.dp)
            end.linkTo(parent.end)
        }
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {

        IntentButton(
            modifier = Modifier.layoutId("btnMainActivity"),
            className = MainActivity::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnBasicFields"),
            className = BasicFields::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnBasicStateHandle"),
            className = BasicStateHandle::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnListCompose"),
            className = ListCompose::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnSimpleAnimation"),
            className = SimpleAnimation::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnProgressBar"),
            className = CircularProgressBar::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnMusicKnob"),
            className = DraggableMusicKnob::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnMeditationUi"),
            className = MeditationUi::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnInstaProfile"),
            className = InstaProfile::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnBottomNavBar"),
            className = BadgesBottomNavBar::class.java,
            text = "BottomNavBar"
        )

        IntentButton(
            modifier = Modifier.layoutId("btnHandleButtonClick"),
            className = HandleButtonCallBack::class.java
        )

        IntentButton(
            modifier = Modifier.layoutId("btnMultiSelectLazyColumn"),
            className = MultiSelectLazyColumn::class.java,
            text = "SelectColumn"
        )

        IntentButton(
            modifier = Modifier.layoutId("btnPermissionHandle"),
            className = PermissionHandling::class.java
        )
    }
}

/**
 * Just a simple button for display constraintsLayout buttons.
 * @param modifier layoutId Modifier to be link button with defined the constraintsLayout ID.
 * @param className pass a class name (like classname::class.java) to redirect on that class)
 * @param text default null if you won't pass anything then it will display classname as a button text.
 *
 * Created by Tirth Patel.
 */
@Composable
fun IntentButton(
    modifier: Modifier,
    className: Class<*>,
    text: String? = null,
) {
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(
                Intent(
                    context,
                    className
                )
            )
        },
        modifier = modifier
    ) {
        Text(text = text ?: className.simpleName)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ComposePracticeDemoAppTheme {
        HomeScreenConstraintLayout()
    }
}