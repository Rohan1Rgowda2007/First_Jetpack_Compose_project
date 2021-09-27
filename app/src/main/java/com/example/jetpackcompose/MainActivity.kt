package com.example.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DefaultPreview()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center

        ) {
            Column(
                modifier = Modifier
                    .padding(start = 60.dp, end = 60.dp),
                verticalArrangement = Arrangement.Center
            ) {

                var text by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = {
                        Text(text = "Type Here")
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Magenta,
                        unfocusedBorderColor = Green
                    )
                )

                Spacer(modifier = Modifier.padding(33.dp))

                // custom textField EditText

                var textNormal by remember { mutableStateOf("") }
                TextField(
                    value = textNormal,
                    maxLines = 1,
                    onValueChange = {
                        textNormal = it.trim { it < ' ' }
                    },
                    label = {
                        Text(text = "Hello world")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_sentiment_satisfied_24),
                            contentDescription = "Icon"
                        )
                    },
                )

                Spacer(modifier = Modifier.padding(20.dp))

                Row(
                    modifier = Modifier
                        .padding(start = 70.dp),

                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Text Fields", fontSize = 30.sp)
                }

                Spacer(modifier = Modifier.padding(24.dp))

                val contexts = LocalContext.current

                Button(
                        onClick = {
                            // TODO not implemented here
                                  Toast.makeText(
                                  contexts,
                                  "Hello it is a Toast Meassage",
                                  Toast.LENGTH_SHORT
                                  ).show()
                    },
                    modifier = Modifier.padding(start = 90.dp)
                ) {
                    Text(text = "Press me ")
                }
            }
        }

    }
}
