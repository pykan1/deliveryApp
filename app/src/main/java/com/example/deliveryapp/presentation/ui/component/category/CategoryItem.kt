package com.example.deliveryapp.presentation.ui.component.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.deliveryapp.domain.model.CategoryModel
import com.example.deliveryapp.presentation.screen.category.CategoryEvent
import com.example.deliveryapp.presentation.screen.category.CategoryViewModel

@Composable
fun CategoryItem(
    navController: NavController,
    categoryViewModel: CategoryViewModel,
    model: CategoryModel
) {

    val viewModel = CategoryItemViewModel()
    val stateCategoryItem = viewModel.stateCategoryItem.collectAsState()
    viewModel.send(InitDataEvent(model.category, model.img, model.id_category))
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
    ) {
        if (stateCategoryItem.value.isLoading) {
            CircularProgressIndicator()
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                if (stateCategoryItem.value.decodeImg == null) {
                    CircularProgressIndicator()
                } else {
                    Image(
                        bitmap = stateCategoryItem.value.decodeImg!!,
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                    )
                }
                Text(text = stateCategoryItem.value.title,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}
