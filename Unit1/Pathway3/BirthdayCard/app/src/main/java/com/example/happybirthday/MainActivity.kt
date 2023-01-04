/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.happybirthday

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage("Happy birthday hyeon", " - from zu")
                }
            }
        }
    }
}

// 7. 텍스트 정렬 및 패딩 추가
@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    // Create a column so that texts don't overlap
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth() // 컴포저블의 너비가 사용가능한 최대 너비로 설정된다.
                .wrapContentWidth(Alignment.Start)
                .padding(start = 16.dp, end = 16.dp)
            // wrapContentWidth : 사용가능한 화면 너비(또는 상위 너비)에 맞춰 컴포저블이 래핑되고 정렬된다.
            // Alignment.Start : 텍스트 컴포저블 또는 하위 요소가 화면의 시작 부분 또는 상위 요소에 맞춰 정렬된다.


        )
        Text(
            text = from,
            fontSize = 24.sp,
        )

    }
}

// 5. Box 레이아웃 추
@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
    Box {
    Image(painter = image,
        contentDescription = null,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
    BirthdayGreetingWithText(message=message,from=from)
}
}

// 4. 이미지 컴포저블 추가
@Preview(showBackground = true)
@Composable
private fun BirthdayCardTPreview() {
    BirthdayCardTheme {
        BirthdayGreetingWithImage(message = "Happy Birthday hyeon!","- from zu")
    }
}
