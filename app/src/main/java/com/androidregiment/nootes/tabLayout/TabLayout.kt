package com.androidregiment.nootes.tabLayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavController
import com.androidregiment.nootes.component.AddFloatingActionButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun TabLayout(
    navController: NavController,
) {
    val modalBottomSheetState =
        rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            confirmStateChange = { value ->
                ModalBottomSheetValue.Expanded == value || ModalBottomSheetValue.Hidden == value
            }
        )

    val list = listOf(TabLayoutScreen.AllNotes, TabLayoutScreen.AllTasks(modalBottomSheetState))

    val pagerState = rememberPagerState()

    val activeScreenPosition by derivedStateOf {
        pagerState.currentPage
    }

    TabLayoutContent(
        activeScreenPosition = activeScreenPosition,
        list = list,
        pagerState = pagerState,
        navController = navController,
        modalBottomSheetState = { modalBottomSheetState }
    )
}

@OptIn(
    ExperimentalPagerApi::class, ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun TabLayoutContent(
    modifier: Modifier = Modifier,
    list: List<TabLayoutScreen>,
    activeScreenPosition: Int,
    pagerState: PagerState,
    navController: NavController,
    modalBottomSheetState: () -> ModalBottomSheetState,
) {
    val kc = LocalSoftwareKeyboardController.current

    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        floatingActionButton = {

            AddFloatingActionButton(
                modalBottomSheetState = modalBottomSheetState,
                modifier = Modifier
            ) {
                if (pagerState.currentPage == 0) {
                    navController.navigate("add_notes")
                } else {
                    coroutineScope.launch {
                        modalBottomSheetState().show()
                    }
                    kc?.show()
                }
            }

        }
    ) { paddingValues ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TabsRow(
                activeScreenPosition = activeScreenPosition,
                list = list,
            )
            TabsScreen(
                list = list,
                pagerState = pagerState,
                navController = navController
            )
        }
    }
}