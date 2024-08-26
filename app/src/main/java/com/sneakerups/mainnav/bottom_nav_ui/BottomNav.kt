package com.sneakerups.mainnav.bottom_nav_ui

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.core.os.BuildCompat
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sneakerups.homecomponent.SideNavigationRail
import com.sneakerups.mainnav.BottomNavGraph
import com.sneakerups.mainnav.BottomNavSealedClass
import com.sneakerups.ui.theme.commonTextBlackLightColor
import com.sneakerups.utils.pxToDp


@Composable
fun BottomNav() {

    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomBarContainer(navController = navController)
        //BottomNavigationRail()
    }) {
        Modifier
            .padding(it)
            .fillMaxSize()

        BottomNavGraph(navController = navController)

    }


}


@SuppressLint("SuspiciousIndentation")
@Composable
fun BottomNavLandscape() {
    val navController = rememberNavController()

    Row(modifier = Modifier.fillMaxSize()) {
        SideNavigationRail(modifier = Modifier)
        BottomNavGraph(navController = navController)
    }


}





@Composable
fun SideBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavSealedClass.Home,
        BottomNavSealedClass.Calendar,
        BottomNavSealedClass.Rank,
        BottomNavSealedClass.Profile
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination


    var expanded by remember { mutableStateOf(false) }
    var pxToMove by remember { mutableStateOf(0) }
    var isDoneAnimation by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    var indicatorWidth by remember { mutableIntStateOf(240) }
    var indicatorHeight by remember { mutableIntStateOf(0) }

    val offset by animateIntOffsetAsState(
        targetValue = if (expanded) {
            IntOffset(pxToMove, 0)
        } else {
            IntOffset(0, 0)
        },
        animationSpec = tween(300, easing = LinearOutSlowInEasing),
        finishedListener = {
            isDoneAnimation = true
            !expanded
        }, label = "offset"
    )

    var scaleX by remember {
        mutableFloatStateOf(1f)
    }

    val scale by animateFloatAsState(
        targetValue = scaleX,
        animationSpec = tween(300, easing = LinearOutSlowInEasing),
        finishedListener = {
            scaleX = 1f
        }, label = ""
    )



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {


        Box(
            modifier = Modifier
                .offset { offset }
                .scale(scale, 1f)
                .clip(CircleShape)
                .background(Color.White)
                .background(commonTextBlackLightColor)
                .height(indicatorHeight.pxToDp())
                .width(indicatorWidth.pxToDp())
        )


        //Text(modifier = Modifier.align(Alignment.BottomCenter), text = "Location: $pxToMove, Width: $indicatorWidth")


        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {


            itemsIndexed(screens) { index, screen ->

                var moveTo by remember { mutableStateOf(0) }

                var indexWidthValue by remember { mutableStateOf(0) }


                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController,
                    modifier = Modifier
                        .animateItem()
                        .fillMaxWidth()
                        .onGloballyPositioned {
                            val positionRoot: Offset = it.positionInParent()
                            moveTo = positionRoot.x.toInt()
                            indexWidthValue = it.size.width
                            indicatorHeight = it.parentCoordinates!!.size.height
                        },
                    isDoneAnimation = isDoneAnimation,
                    click = {
                        if (selectedIndex != index) {
                            selectedIndex = index
                            expanded = true
                            pxToMove = moveTo
                            indicatorWidth = indexWidthValue
                            scaleX = 1.2f
                            isDoneAnimation = false

                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        }
                    }
                )
            }

        }
    }


}




@Composable
@Preview(showBackground = true)
fun BottomNavePreview() {
    //val navController = rememberNavController()
    BottomNav()
    //BottomBar(navController = navController)
    // BottomNavLandscape()
}