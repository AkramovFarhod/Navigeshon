package com.example.mynavigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PersonScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(40.dp), verticalArrangement = Arrangement.spacedBy(21.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(modifier = Modifier.padding(), text ="Gram Taxi" )
        val (text, setText) = remember { mutableStateOf("") }
        val (text1, setText1) = remember { mutableStateOf("") }
        val (text2, setText2) = remember { mutableStateOf("") }
        val (text3, setText3) = remember { mutableStateOf("") }
        val (text4, setText4) = remember { mutableStateOf("") }

        MyTextField(label = " Фамилия ", value = text, onValueChanged = setText)
        MyTextField(label = " Имя ", value = text1, onValueChanged = setText1)
        MyTextField(label = " Сколько лет ", value = text2, onValueChanged = setText2)
        MyTextField(label = " Пол ", value = text3, onValueChanged = setText3)
        MyTextField(label = " Где работаешь ", value = text4, onValueChanged = setText4)

        Button(
            onClick = {  },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            enabled = text.isNotBlank() && text1.isNotBlank(),
        ) {
            Text(text = "Добовления")
        }
    }
}


@Composable
fun MyTextField(
    label:String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    value:String,
    onValueChanged:(String) -> Unit

) {

    OutlinedTextField(
        value = value,
        onValueChange =onValueChanged,
        label = { Text(text = label) },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions
    )
}