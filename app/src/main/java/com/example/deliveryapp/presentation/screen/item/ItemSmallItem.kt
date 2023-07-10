package com.example.deliveryapp.presentation.screen.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.deliveryapp.R
import com.example.deliveryapp.domain.model.ItemModel

@Composable
fun ItemSmallItem(itemModel: ItemModel) {

    val viewModel = hiltViewModel<ItemViewModel>()
    val stateItem by viewModel.stateItem.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.send(InitItemEvent(itemModel))
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
    ) {
        Column(modifier = Modifier) {
            Box(modifier = Modifier.weight(1f)) {
                if (stateItem.decodeImg == null) {
                    Image(
                        painter = painterResource(id = R.drawable.not_image),
                        contentDescription = null
                    )
                } else {
                    Image(
                        bitmap = stateItem.decodeImg!!,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier.size(10.dp)
                        )
                        Text(
                            text = "${stateItem.rate}",
                            fontSize = 10.sp,
                            color = Color.Black
                        )
                    }
                    Text(
                        text = stateItem.name,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.not_image),
                            contentDescription = null,
                            modifier = Modifier.size(10.dp)
                        )
                    }
                }
            }
        }
    }


}