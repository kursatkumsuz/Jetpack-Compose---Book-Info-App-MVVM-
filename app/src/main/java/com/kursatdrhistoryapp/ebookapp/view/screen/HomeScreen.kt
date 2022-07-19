package com.kursatdrhistoryapp.ebookapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kursatdrhistoryapp.ebookapp.R
import com.kursatdrhistoryapp.ebookapp.model.BookModel
import com.kursatdrhistoryapp.ebookapp.navigation.BookScreens
import com.kursatdrhistoryapp.ebookapp.viewmodel.MainScreenViewModel

@Composable
fun HomeScreen(navController: NavController) {
        MainContent(navController)

}


@Composable
fun MainContent(navController: NavController) {
    val viewModel: MainScreenViewModel = viewModel()
    val list = viewModel.bookList.observeAsState(listOf())
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        BookList(list.value , navController)
    }
}

@Composable
fun BookList(list: List<BookModel> , navController: NavController) {

    LazyColumn() {
        items(list.size) { index ->
            ListItem(list[index] , navController)
        }
    }
}

@Composable
fun ListItem(book: BookModel , navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(30.dp, 20.dp),
        shape = RoundedCornerShape(28.dp),
        elevation = 12.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF212741))
        ) {
            Image(
                painter = painterResource(id = book.image), contentDescription = "Book Cover",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(110.dp)
            )
            Text(
                text = book.title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 130.dp, top = 20.dp)
            )

            Text(
                text = book.author,
                color = Color.LightGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal, fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(start = 130.dp, top = 50.dp)
            )

            Box(
                modifier = Modifier
                    .padding(start = 130.dp, top = 110.dp)
                    .background(color = Color(0xFF181B2E))
                    .size(75.dp, 35.dp)
                    .clip(RoundedCornerShape(topStart = 26.dp, bottomEnd = 26.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = book.category, color = Color(0xFF5D6597), fontSize = 14.sp)
            }

            Box(
                modifier = Modifier
                    .size(65.dp, 40.dp)
                    .clip(RoundedCornerShape(topStart = 26.dp, bottomEnd = 26.dp))
                    .background(color = Color(0xFF121524))
                    .align(alignment = Alignment.BottomEnd)
                    .clickable {

                        navController.navigate(BookScreens.DetailScreen.name+"/${book.id}")
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_navigate_next_24),
                    contentDescription = "icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(34.dp)
                        .align(alignment = Alignment.Center)
                )
            }
        }

    }
}